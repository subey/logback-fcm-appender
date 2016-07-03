package net.subey.logback;

/**
 * @link https://firebase.google.com/docs/cloud-messaging/http-server-ref#downstream-http-messages-json
 */
public class FcmMessage {
    private String message_id;
    private String to;
    private FcmNotification notification;
    private Integer time_to_live = 1728000; //20*86400=1728000 sec -> 20 days
    private Boolean delivery_receipt_requested;
    private String collapse_key; //This parameter identifies a group of message
    private String priority = "normal"; //This parameter identifies a group of message


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

    public String getCollapse_key() {
        return collapse_key;
    }

    public void setCollapse_key(String collapse_key) {
        this.collapse_key = collapse_key;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
