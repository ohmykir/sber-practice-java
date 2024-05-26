package com.test;

public class ResourceProcessor {
    private final Resource resource;

    public ResourceProcessor(Resource resource) {
        this.resource = resource;
    }

    public void increase() {
        synchronized (resource) {
            resource.setValue(resource.getValue() + 1);
            System.out.println(resource.getValue());
        }
    }

    public void decrease() {
        synchronized (resource) {
            resource.setValue(resource.getValue() - 1);
            System.out.println(resource.getValue());
        }
    }
}
