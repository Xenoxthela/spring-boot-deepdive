package de.volkswagen.petstore.pet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //(classes = PetstoreApplication.class)
class PetServiceTest {

    @Autowired
    private PetService petService;

    @Test
    void testPetServiceInitialization() {
        assertThat(petService.getPets()).isNotEmpty();
    }

    @Test
    void testFindPetByName() {
        //given
        String petName = "Duke";
        
        //then
        assertThat(petService.findPetByName(petName)).isNotNull();
    }

}
