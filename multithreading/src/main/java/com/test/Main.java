package com.test;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource(0);
        ResourceProcessor processor = new ResourceProcessor(resource);
        Increaser[] increasers = new Increaser[3];

        for (int i = 0; i < 3; i++) {
            increasers[i] = new Increaser(processor);
            //increasers[i].start();
        }

        //task 7
        resource.setValue(0);
        Increaser increaser = new Increaser(processor);
        Decreaser decreaser = new Decreaser(processor);

        new Thread(increaser).start();
        new Thread(decreaser).start();
    }
}