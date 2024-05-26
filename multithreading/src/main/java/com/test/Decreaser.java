package com.test;

class Decreaser implements Runnable {
    private final ResourceProcessor processor;

    public Decreaser(ResourceProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        processor.decrease();
    }
}
