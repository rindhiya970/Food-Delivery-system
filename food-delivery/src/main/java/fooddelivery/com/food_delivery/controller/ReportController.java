package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // 🔐 ADMIN ONLY (we’ll enforce role later)
    @GetMapping("/orders")
    public ResponseEntity<byte[]> downloadOrdersReport() throws Exception {

        byte[] excelData = reportService.generateOrdersReport();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=orders_report.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelData);
    }
}
