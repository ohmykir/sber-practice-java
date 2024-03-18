package com.test;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone () {
    }

    public Phone (String number, String model, double weight) {
        this.model = model;
        this.number = number;
        this.weight = weight;
    }

    public Phone (String number, String model) {
        this.number = number;
        this.model = model;
    }

    public String getNumber() {
        return  this.number;
    }

    public void receiveCall (String name){
        System.out.println("Звонит: " + name);
    }
    public void receiveCall (String name, String number) {
        System.out.printf("Звонит: %s (%s)", name, number);
        System.out.println();
    }
    @Override
    public String toString() {
        return ("Номер: " + this.number + "; модель: " + this.model + "; вес: " + this.weight);
    }

    public static void sendMessage(String[] numbers){
        for(String number : numbers){
            System.out.println(number);
        }
    }
}