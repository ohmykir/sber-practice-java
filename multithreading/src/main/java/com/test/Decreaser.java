package com.test;

class Decreaser extends Thread {
    private final ResourceProcessor processor;

    public Decreaser(ResourceProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            processor.decrease();
        }
    }
}
