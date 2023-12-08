package de.volkswagen.petstore.order;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;

import de.volkswagen.petstore.pet.Pet;
import de.volkswagen.petstore.pet.PetService;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final PetService petService;

    public OrderController(OrderService orderService, PetService petService) {
        this.orderService = orderService;
        this.petService = petService;
    }

    public void getAllOrders() {
        orderService.getOrders().forEach(order -> System.out.println("Order: " + order.getAddress()));

    }

    public void createNewOrder(List<String> petNames, List<Integer> quantities, String address) {
        if (petNames == null || quantities == null) {
            throw new IllegalArgumentException("Pet names and quantities cannot be null");
        }
        if (petNames.size() != quantities.size()) {
            throw new IllegalArgumentException("Amount of pets and there quantities must be the same");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address must be filled");
        }

        Map<Pet, Integer> petQuantities = mapPetNamesToQuantities(petNames, quantities);

        orderService.addNewOrder(petQuantities, address);
    }

    private Map<Pet, Integer> mapPetNamesToQuantities(List<String> petNames, List<Integer> quantities) {

        return petNames.stream()
                .collect(Collectors.toMap(petService::findPetByName, name -> quantities.get(petNames.indexOf(name))));
    }

}
