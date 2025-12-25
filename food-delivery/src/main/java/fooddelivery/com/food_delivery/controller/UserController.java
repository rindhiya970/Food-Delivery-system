package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.entity.User;
import fooddelivery.com.food_delivery.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 🔐 PROTECTED API
    @GetMapping("/me")
    public User getCurrentUser(Authentication authentication) {

        String email = authentication.getName();
        return userService.findByEmail(email);
    }
}
