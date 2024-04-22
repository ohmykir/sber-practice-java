package com.test;

import java.util.ArrayList;

public class Menagerie { //зверинец))
    public static void setUp(ArrayList<Sounding> animals) {
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cow());
        animals.add(new Parrot());

        animals.add(new Sounding() {
            @Override
            public void sound() {
                System.out.println("growl");
            }
        });

        animals.add(() -> System.out.println("chirp"));

        animals.add(System.out::println);

    }

    public static void sound(ArrayList<Sounding> animals) {
        /* for (Sounding animal : animals) {
            animal.sound();
        } */

        animals.forEach(Sounding::sound);
    }

    public static void main(String[] args) {
        ArrayList<Sounding> animals = new ArrayList<>();
        setUp(animals);
        sound(animals);
    }
}
