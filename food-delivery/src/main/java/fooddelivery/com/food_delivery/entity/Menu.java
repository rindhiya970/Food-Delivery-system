package fooddelivery.com.food_delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Long restaurantId;
}
