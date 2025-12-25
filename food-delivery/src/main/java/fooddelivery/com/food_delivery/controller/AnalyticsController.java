package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    // ✅ TOTAL REVENUE
    @GetMapping("/revenue")
    public Double totalRevenue() {
        return analyticsService.totalRevenue();
    }

    // ✅ TOTAL ORDERS COUNT
    @GetMapping("/orders/count")
    public Long totalOrders() {
        return analyticsService.totalOrders();
    }

    // ✅ ORDERS PER DAY (ECharts-ready)
    @GetMapping("/orders/per-day")
    public List<Object[]> ordersPerDay() {
        return analyticsService.ordersPerDay();
    }
}
