
package fooddelivery.com.food_delivery.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class PaymentService {

    private final WebClient webClient;

    public PaymentService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String processPayment() {

        try {
            return webClient.get()
                    .uri("/posts/1") // fake payment API
                    .retrieve()
                    .bodyToMono(String.class)
                    .timeout(Duration.ofSeconds(3))
                    .onErrorResume(e -> {
                        // fallback
                        return Mono.just("Payment service unavailable - fallback response");
                    })
                    .block();

        } catch (Exception e) {
            return "Payment failed - fallback executed";
        }
    }
}
