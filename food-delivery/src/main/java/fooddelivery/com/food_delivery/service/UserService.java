package fooddelivery.com.food_delivery.service;

import fooddelivery.com.food_delivery.entity.User;

public interface UserService {

    User findByEmail(String email);

    void createUser(User user);
}
