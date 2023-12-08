package de.volkswagen.petstore.order;

import java.time.LocalDate;
import java.util.Map;

import de.volkswagen.petstore.pet.Pet;

public class Order {

    private String address;
    private OrderStatus status;
    private Map<Pet, Integer> petQuantities;

    private LocalDate date;

    private double discount;

    public Order() {

    }

    public Order(String address, OrderStatus status, Map<Pet, Integer> petQuantities, LocalDate date, double discount) {
        this.address = address;
        this.status = status;
        this.petQuantities = petQuantities;
        this.date = date;
        this.discount = discount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Map<Pet, Integer> getPetQuantities() {
        return petQuantities;
    }

    public void setPetQuantities(Map<Pet, Integer> petQuantities) {
        this.petQuantities = petQuantities;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
