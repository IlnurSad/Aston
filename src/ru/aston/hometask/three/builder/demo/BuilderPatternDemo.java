package ru.aston.hometask.three.builder.demo;

import ru.aston.hometask.three.builder.Car;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        final Car car1 = new Car.CarBuilder("Toyota", "Camry")
                .year(2022)
                .color("Blue")
                .hasGPS(true)
                .hasLeatherSeats(true)
                .build();

        System.out.println(car1);

        final Car car2 = new Car.CarBuilder("Honda", "Civic")
                .build();

        System.out.println(car2);

        final Car car3 = new Car.CarBuilder("BMW", "X5")
                .year(2023)
                .color("Black")
                .hasLeatherSeats(true)
                .build();

        System.out.println(car3);
    }
}