package fooddelivery.com.food_delivery.service;

import fooddelivery.com.food_delivery.entity.Order;
import fooddelivery.com.food_delivery.repository.OrderRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportService {

    private final OrderRepository orderRepository;

    public ReportService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public byte[] generateOrdersReport() throws Exception {

        List<Order> orders = orderRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Orders");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Order ID");
        header.createCell(1).setCellValue("Customer Email");
        header.createCell(2).setCellValue("Amount");
        header.createCell(3).setCellValue("Status");
        header.createCell(4).setCellValue("Created At");

        int rowIdx = 1;
        for (Order order : orders) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(order.getId());
            row.createCell(1).setCellValue("N/A"); // placeholder for email
            row.createCell(2).setCellValue(order.getTotalAmount());
            row.createCell(3).setCellValue(order.getStatus());
            row.createCell(4).setCellValue(order.getCreatedAt().toString());

        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }
}
