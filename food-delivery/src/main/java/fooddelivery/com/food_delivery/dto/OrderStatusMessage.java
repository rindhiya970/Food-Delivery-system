package fooddelivery.com.food_delivery.dto;

public class OrderStatusMessage {

    private Long orderId;
    private String status;

    public OrderStatusMessage() {}

    public OrderStatusMessage(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
