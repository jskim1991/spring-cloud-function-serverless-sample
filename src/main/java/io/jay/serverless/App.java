package io.jay.serverless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class App {

    private final OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Supplier<List<Order>> orders() {
        return () -> orderRepository.findAll();
    }

    @Bean
    public Function<String, List<Order>> orderByName() {
        return (name) -> orderRepository.findAll().stream()
                .filter(order -> name.equals(order.getName()))
                .collect(Collectors.toList());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Order {
    private int id;
    private String name;
    private double price;
    private int quantity;
}

@Repository
class OrderRepository {
    public List<Order> findAll() {
        return Arrays.asList(
                new Order(101, "Mobile", 1999, 1),
                new Order(201, "Something", 999, 99)
        );
    }
}
