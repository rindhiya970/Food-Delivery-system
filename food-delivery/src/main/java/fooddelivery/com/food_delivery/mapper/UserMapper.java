package fooddelivery.com.food_delivery.mapper;

import fooddelivery.com.food_delivery.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByEmail(String email);

    void insertUser(User user);
}
