package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.dto.OrderStatusMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderStatusController {

    private final SimpMessagingTemplate messagingTemplate;

    public OrderStatusController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/api/order/{orderId}/status")
    public String updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {

        OrderStatusMessage message =
                new OrderStatusMessage(orderId, status);

        messagingTemplate.convertAndSend(
                "/topic/orders", message);

        return "Order status sent via WebSocket";
    }
}
