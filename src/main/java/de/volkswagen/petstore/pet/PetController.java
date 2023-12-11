package de.volkswagen.petstore.pet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;

@Controller
public class PetController {

    private static final Logger logger = LoggerFactory.getLogger(PetController.class);

    @Value("${petshop.is_black_friday:false}")
    private boolean isBlackFriday;

    @Value("${petshop.discount_percentage:0}")
    private int discountPercentage;

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostConstruct
    public void getAllPets() {
        logger.info("PetController wurde geladen");
        
        petService.getPets().forEach(pet -> {
            double price = pet.getPrice();
            if (isBlackFriday) {
                price *= (100 - discountPercentage) / 100.0;
            }
            System.out.println("Pet: " + pet.getName() + ", Price: " + price);
        });
    }

}
