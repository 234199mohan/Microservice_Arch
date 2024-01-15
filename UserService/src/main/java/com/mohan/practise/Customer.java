package com.mohan.practise;

public class Customer {

    private String name;
    private String area;
    private int amount;

    public Customer(String name, String area, int amount) {
        this.name = name;
        this.area = area;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
