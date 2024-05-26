package com.test;

public class ResourceProcessorModified {
    private final Resource resource;

    public ResourceProcessorModified(Resource resource) {
        this.resource = resource;
    }

    public synchronized void increase() {
        while (resource.getValue() >= 5) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resource.setValue(resource.getValue() + 1);
        System.out.println(resource.getValue());
        notify();
    }

    public synchronized void decrease() {
        while (resource.getValue() <= 1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resource.setValue(resource.getValue() - 1);
        System.out.println(resource.getValue());
        notify();
    }
}
