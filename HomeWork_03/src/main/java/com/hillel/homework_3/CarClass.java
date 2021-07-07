package com.hillel.homework_3;

public class CarClass {
    private static final int tankVolume = 55;
    private static final int fuelConsumptionPerHundredKm = 12;
    private static final double constForResidue = 100.0D;
    double stopA = 177.8D;
    double stopB = 152.8D;
    double stopC = 148.2D;

    public CarClass() {
    }

    double consumptionA() {
        return (fuelConsumptionPerHundredKm * stopA) / constForResidue;
    }

    double consumptionB() {
        return (fuelConsumptionPerHundredKm * stopB) / constForResidue;
    }

    double consumptionC() {
        return (fuelConsumptionPerHundredKm * stopC) / constForResidue;
    }

    void refuelInfoA() {
        double left = tankVolume - consumptionA();
        System.out.println("Fuel when start the way: " + tankVolume
                + "\nAmount of fuel that was left when reached the Krivoe Ozero: "
                + left + "\nNeed to refuel " + consumptionA() + " liters");
    }

    double refuelA() {
        double left = tankVolume - consumptionA();
        return left + consumptionA();
    }

    void refuelInfoB() {
        double left = tankVolume - consumptionB();
        System.out.println("Fuel when start the way: " + tankVolume
                + "\nAmount of fuel that was left when reached the Zhaskov : "
                + left + "\nNeed to refuel " + consumptionB() + " liters");
    }

    double refuelB() {
        double left = tankVolume - consumptionB();
        return left + consumptionB();
    }

    void amountOfFuelWhenReachedKyiv() {
        double result = tankVolume - consumptionC();
        System.out.println("The fuel left when reached Kyiv: " + result);
    }
}
