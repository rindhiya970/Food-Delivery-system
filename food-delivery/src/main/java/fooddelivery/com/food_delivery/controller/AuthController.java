package fooddelivery.com.food_delivery.controller;

import fooddelivery.com.food_delivery.dto.LoginRequest;
import fooddelivery.com.food_delivery.entity.User;
import fooddelivery.com.food_delivery.security.JwtUtil;
import fooddelivery.com.food_delivery.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        if (userService.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        userService.createUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {

    Map<String, Object> response = new HashMap<>();

    // TEMP BYPASS LOGIN
    response.put("token", "DUMMY_TOKEN");
    response.put("role", "USER");

    return ResponseEntity.ok(response);
}

}
