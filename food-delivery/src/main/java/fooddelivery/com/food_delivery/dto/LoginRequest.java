package fooddelivery.com.food_delivery.dto;

public class LoginRequest {

    private String email;
    private String password;

    // getter
    public String getEmail() {
        return email;
    }

    // setter
    public void setEmail(String email) {
        this.email = email;
    }

    // getter
    public String getPassword() {
        return password;
    }

    // setter
    public void setPassword(String password) {
        this.password = password;
    }
}
