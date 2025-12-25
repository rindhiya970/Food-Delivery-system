package fooddelivery.com.food_delivery.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fooddelivery.com.food_delivery.entity.Order;
import fooddelivery.com.food_delivery.repository.OrderRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initOrders(OrderRepository orderRepository) {
        return args -> {
            if (orderRepository.count() == 0) {
                Order order = new Order();
                order.setStatus("PLACED");
                orderRepository.save(order);
            }
        };
    }
}
