package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.entity.Menu;
import fooddelivery.com.food_delivery.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{restaurantId}")
    public List<Menu> getMenu(@PathVariable Long restaurantId) {
        return menuService.getMenuByRestaurant(restaurantId);
    }
}
