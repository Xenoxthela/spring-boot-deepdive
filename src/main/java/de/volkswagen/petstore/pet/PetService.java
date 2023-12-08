package de.volkswagen.petstore.pet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class PetService { // implements InitializingBean, DisposableBean

    // @Override
    // public void destroy() thorws Exception {
    // sysout
    // }

    // @Lazy
    List<Pet> pets = new ArrayList();

    @PostConstruct
    public void created() throws Exception {
        new Pet("Duke", PetType.DOG, 20, 900, "Golden Retriever", "a lot of walking");
        new Pet("cat1", PetType.CAT, 15, 300, "typedescriptionCat", "husbandryCat");
        new Pet("Bunny", PetType.RABBIT, 10, 40, "typeDescriptionRabbit", "husbandryRabbit");
        new Pet("Khan", PetType.SNAKE, 10, 50, "typeDesSnkae", "husbbSnake");

        System.out.println("PetService has been created");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("PetService has been destroyed");

    }

    public List<Pet> getPets() {
        return pets;
    }

    public Pet findPetByName(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        throw new IllegalArgumentException("Pet not found");
    }

}
