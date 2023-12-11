package de.volkswagen.petstore.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.volkswagen.petstore.pet.Pet;
import de.volkswagen.petstore.pet.PetType;

@SpringBootTest(classes = OrderService.class)
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void testAddNewOrder() {
        //given
        Map<Pet, Integer> petQuantities = new HashMap<>();
        petQuantities.put(new Pet("cat1", PetType.CAT, 15, 300, "typedescriptionCat", "husbandryCat"), 1);

        //when
        orderService.addNewOrder(petQuantities, "123 Teststreet");

        //then
        assertThat(orderService.getOrders()).isNotEmpty();
    }
}
