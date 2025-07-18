package org.sytac.workshop;

public record Cat(String name, int age) {

    public Cat {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
