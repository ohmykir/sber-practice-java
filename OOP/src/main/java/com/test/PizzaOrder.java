package com.test;

public class PizzaOrder {
    private String name;
    private Size size;
    private boolean isSousNeeded;
    private String address;
    private boolean isAccepted;

    public PizzaOrder(String name, Size size, boolean isSousNeeded, String address) {
        this.name = name;
        this.size = size;
        this.isSousNeeded = isSousNeeded;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isSousNeeded() {
        return isSousNeeded;
    }

    public void setSousNeeded(boolean sousNeeded) {
        isSousNeeded = sousNeeded;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "Name = '" + this.name + '\'' +
                ", size = " + this.size +
                ", isSousNeeded = " + this.isSousNeeded +
                ", address = '" + this.address + '\'' +
                ", isAccepted = " + this.isAccepted +
                '}';
    }

    public void order(){
        String s = this.isSousNeeded? "с соусом" : "без соуса";
        System.out.println("Заказ принят. " + this.size.getTitle() + " пицца '" + this.name + "' " + s
                                                                + " на адрес " + this.address);
        this.isAccepted = true;
    }
    public void cancel(){
        System.out.println("Заказ отменен.");
        this.isAccepted = false;
    }
}
