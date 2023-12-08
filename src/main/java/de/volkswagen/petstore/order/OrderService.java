package de.volkswagen.petstore.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.volkswagen.petstore.pet.Pet;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList();

    @Value("${petshop.is_black_friday}")
    private boolean isBlackFriday;

    @Value("${petshop.discount_percentage:0}")
    private int discountPercentage;

    public void addNewOrder(Map<Pet, Integer> petQuantities, String address) {
        Order newOrder = new Order();
        newOrder.setPetQuantities(petQuantities);
        newOrder.setAddress(address);
        newOrder.setStatus(OrderStatus.NEW);
        newOrder.setDate(LocalDate.now());

        double discount = isBlackFriday ? discountPercentage : 0;

        petQuantities.forEach((pet, quantity) -> {
            double originalPrice = pet.getPrice();
            double discountedPrice = originalPrice * (100 - discount) / 100.0;
            pet.setPrice(discountedPrice);

        });

        newOrder.setDiscount(discount);
        orders.add(newOrder);

    }

    public List<Order> getOrders() {
        return orders;
    }

}
