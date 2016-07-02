package net.subey.logback;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.concurrent.atomic.AtomicInteger;

public class FcmAppender extends AppenderBase<LoggingEvent> {

    private String key;
    private String title;
    private String to;
    private static final AtomicInteger count = new AtomicInteger(0);

    private EventEvaluator<LoggingEvent> evaluator;
    private PatternLayoutEncoder encoder;


    private void sendFcm(String body, String msgId) throws UnirestException {
        FcmMessage msg = new FcmMessage();

        msg.setMessage_id(msgId + "-" + count.incrementAndGet());
        msg.setTo(getTo());
        msg.setDelivery_receipt_requested(null);
        msg.setTime_to_live(600);
        msg.setNotification(new FcmNotification(getTitle() , body, "alert_dark_frame"));

        Gson gson = new Gson();

        System.out.println(gson.toJson(msg));

        HttpResponse<JsonNode> jsonResponse = Unirest.post("https://fcm.googleapis.com/fcm/send")
                .header("Content-Type", "application/json")
                .header("Authorization", "key=" + getKey())
                .body(gson.toJson(msg))
                .asJson();

        if(jsonResponse.getStatus() != 200 ){
            addError(jsonResponse.getRawBody().toString());
        }
    }
    protected void append(LoggingEvent eventObject) {
        if (evaluate(eventObject)) {
            try {
                String msgId = String.valueOf(eventObject.getContextBirthTime());
                String message = encoder.getLayout().doLayout(eventObject);
                sendFcm(eventObject.getFormattedMessage(), msgId);
            } catch (UnirestException e) {
                addError(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private boolean evaluate(LoggingEvent event) {
        if (evaluator == null) {
            return true;
        }
        try {
            return evaluator.evaluate(event);
        } catch (EvaluationException e) {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public PatternLayoutEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(PatternLayoutEncoder encoder) {
        this.encoder = encoder;
    }
}
