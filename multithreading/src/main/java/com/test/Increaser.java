package com.test;

public class Increaser extends Thread {
    private final ResourceProcessor processor;

    public Increaser(ResourceProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        // для 3 задачи просто на 6 поменять назад можно
        for (int i = 0; i < 10; i++) {
            processor.increase();
        }
    }
}
