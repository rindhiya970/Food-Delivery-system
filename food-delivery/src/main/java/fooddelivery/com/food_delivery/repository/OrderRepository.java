package fooddelivery.com.food_delivery.repository;

import fooddelivery.com.food_delivery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

import java.time.LocalDateTime;

public interface OrderRepository extends JpaRepository<Order, Long> {

    long countByCreatedAtAfter(LocalDateTime date);

    @Query("SELECT SUM(o.totalAmount) FROM Order o")
    Double totalRevenue();

    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.createdAt >= :date")
    Double revenueAfter(LocalDateTime date);


    @Query("SELECT COUNT(o) FROM Order o")
     Long totalOrders();


    @Query("""
    SELECT DATE(o.createdAt), COUNT(o)
    FROM Order o
    GROUP BY DATE(o.createdAt)
    ORDER BY DATE(o.createdAt)
""")
List<Object[]> ordersPerDay();



}
