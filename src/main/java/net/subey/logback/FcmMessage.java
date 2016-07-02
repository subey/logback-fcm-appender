package net.subey.logback;

public class FcmMessage {
    private String message_id;
    private String to;
    private FcmNotification notification;
    private Integer time_to_live;
    private Boolean delivery_receipt_requested;

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public FcmNotification getNotification() {
        return notification;
    }

    public void setNotification(FcmNotification notification) {
        this.notification = notification;
    }

    public Integer getTime_to_live() {
        return time_to_live;
    }

    public void setTime_to_live(Integer time_to_live) {
        this.time_to_live = time_to_live;
    }

    public Boolean getDelivery_receipt_requested() {
        return delivery_receipt_requested;
    }

    public void setDelivery_receipt_requested(Boolean delivery_receipt_requested) {
        this.delivery_receipt_requested = delivery_receipt_requested;
    }
}
