package fooddelivery.com.food_delivery.service;

import fooddelivery.com.food_delivery.entity.Menu;
import fooddelivery.com.food_delivery.repository.MenuRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // 🔥 REDIS CACHE HERE
    @Cacheable(value = "menus", key = "#restaurantId")
    public List<Menu> getMenuByRestaurant(Long restaurantId) {

        System.out.println("Fetching menu from DATABASE");

        List<Menu> menus = menuRepository.findByRestaurantId(restaurantId);

        // ✅ NEVER return null (industry rule)
        return menus == null ? Collections.emptyList() : menus;
    }
}
