package de.volkswagen.petstore;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.volkswagen.petstore.order.OrderService;
import de.volkswagen.petstore.pet.PetService;
import de.volkswagen.petstore.order.OrderController;

public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private PetService petService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateNewOrderWithUnequalListSizes() {
        List<String> petNames = List.of("Dog");
        List<Integer> quantities = List.of(1, 2);
        String address = "Test Address";

        assertThrows(IllegalArgumentException.class,
                () -> orderController.createNewOrder(petNames, quantities, address));
    }

    @Test
    void testCreateNewOrderWithNonExistingPet() {
        List<String> petNames = List.of("Dragon");
        List<Integer> quantities = List.of(1);
        String address = "Test Address";

        when(petService.findPetByName(anyString())).thenThrow(new IllegalArgumentException("Pet not found"));

        assertThrows(Exception.class, () -> orderController.createNewOrder(petNames, quantities, address));
    }

    @Test
    void testCreateNewOrderWithEmptyAddress() {

        List<String> petNames = List.of("Dog");
        List<Integer> quantities = List.of(1);
        String address = "";

        assertThrows(IllegalArgumentException.class, () -> orderController.createNewOrder(petNames, quantities, address));
    }

    @Test
    void testCreateNewOrderWithNullParameters() {

        assertThrows(IllegalArgumentException.class , () -> orderController.createNewOrder(null, null, null));
        
    }

}
