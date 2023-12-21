package com.example.demo;

enum Client {
    CLIENT1(TestServiceImpl.class),
    CLIENT2(TestServiceImpl1.class);

    private final Class<? extends TestService> serviceImplementation;

    Client(Class<? extends TestService> serviceImplementation) {
        this.serviceImplementation = serviceImplementation;
    }

    public TestService createServiceInstance() {
        try {
            System.out.println("serviceImplementation: " +serviceImplementation);
            return serviceImplementation.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error creating service instance", e);
        }
    }
}