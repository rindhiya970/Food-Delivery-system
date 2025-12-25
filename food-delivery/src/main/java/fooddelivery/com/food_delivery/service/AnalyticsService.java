package fooddelivery.com.food_delivery.service;

import fooddelivery.com.food_delivery.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AnalyticsService {

    private final OrderRepository orderRepository;

    public AnalyticsService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Map<String, Object> getAnalytics() {

        LocalDateTime today =
                LocalDate.now().atStartOfDay();

        Map<String, Object> data = new HashMap<>();

        data.put("totalOrders", orderRepository.count());
        data.put("todayOrders",
                orderRepository.countByCreatedAtAfter(today));

        data.put("totalRevenue",
                orderRepository.totalRevenue());

        data.put("todayRevenue",
                orderRepository.revenueAfter(today));

        return data;
    }

         public Long totalOrders() {
    return orderRepository.totalOrders();
         }

       public List<Object[]> ordersPerDay() {
    return orderRepository.ordersPerDay();
      }
      
      public Double totalRevenue() {
        return orderRepository.totalRevenue();
    }

}
