package de.volkswagen.petstore.pet;

public class Pet {

    private String name;
    private PetType type;
    private int size;
    private double price;
    private String typeDescription;
    private String husbandry;



    public Pet(String name, PetType type, int size, double price, String typeDescription, String husbandry) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.typeDescription = typeDescription;
        this.husbandry = husbandry;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double discountedPrice) {
        this.price = discountedPrice;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getHusbandry() {
        return husbandry;
    }

    public void setHusbandry(String husbandry) {
        this.husbandry = husbandry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

}
