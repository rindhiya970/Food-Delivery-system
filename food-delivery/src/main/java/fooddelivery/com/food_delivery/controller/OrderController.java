package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.entity.Order;
import fooddelivery.com.food_delivery.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public OrderController(OrderRepository orderRepository,
                           SimpMessagingTemplate messagingTemplate) {
        this.orderRepository = orderRepository;
        this.messagingTemplate = messagingTemplate;
    }

    // ✅ UPDATE ORDER STATUS + SEND WEBSOCKET MESSAGE (NO CRASH)
    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status
    ) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setStatus(status);
                    Order savedOrder = orderRepository.save(order);

                    // 🔥 WebSocket push
                    messagingTemplate.convertAndSend(
                            "/topic/orders/" + orderId,
                            savedOrder
                    );

                    return ResponseEntity.ok(savedOrder);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
