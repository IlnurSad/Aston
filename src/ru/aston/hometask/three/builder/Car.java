package ru.aston.hometask.three.builder;

public class Car {
    private final String brand;
    private final String model;
    private final Integer year;
    private final String color;
    private final boolean hasGPS;
    private final boolean hasLeatherSeats;

    private Car(CarBuilder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.hasGPS = builder.hasGPS;
        this.hasLeatherSeats = builder.hasLeatherSeats;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public Integer getYear() { return year; }
    public String getColor() { return color; }
    public boolean hasGPS() { return hasGPS; }
    public boolean hasLeatherSeats() { return hasLeatherSeats; }

    @Override
    public String toString() {
        return String.format("Car{brand='%s', model='%s', year=%d, color='%s', GPS=%s, Leather=%s}",
                brand, model, year, color, hasGPS, hasLeatherSeats);
    }

    public static class CarBuilder {
        private final String brand;
        private final String model;

        private Integer year;
        private String color;
        private boolean hasGPS;
        private boolean hasLeatherSeats;

        public CarBuilder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public CarBuilder year(Integer year) {
            this.year = year;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder hasGPS(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public CarBuilder hasLeatherSeats(boolean hasLeatherSeats) {
            this.hasLeatherSeats = hasLeatherSeats;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}