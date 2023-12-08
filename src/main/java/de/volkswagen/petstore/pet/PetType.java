package de.volkswagen.petstore.pet;

public enum PetType {
    DOG("Dog"), CAT("Cat"), RABBIT("Rabbit"), SNAKE("Snake"), RAT("Rat");

    private String name;

    PetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

