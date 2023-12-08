package de.volkswagen.petstore.pet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;

@Controller
public class PetController {

    @Value("${petshop.is_black_friday}")
    private boolean isBlackFriday;

    @Value("${petshop.discount_percentage:0}")
    private int discountPercentage;

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostConstruct
    public void getAllPets() {
        petService.getPets().forEach(pet -> {
            double price = pet.getPrice();
            if (isBlackFriday) {
                price *= (100 - discountPercentage) / 100.0;
            }
            System.out.println("Pet: " + pet.getName() + ", Price: " + price);
        });
    }

}
