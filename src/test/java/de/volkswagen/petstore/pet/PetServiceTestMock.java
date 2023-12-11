package de.volkswagen.petstore.pet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetServiceTestMock {

    @InjectMocks
    private PetService petService;

    @Test
    void testPetServiceInitialization() {
        assertThat(petService.getPets()).isNotEmpty();
    }

    @Test
    void testFindPetByName() {
        String petName = "Duke";
        assertThat(petService.findPetByName(petName)).isNotNull();
    }

}
