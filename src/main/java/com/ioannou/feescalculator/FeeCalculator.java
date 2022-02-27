package com.ioannou.feescalculator;

public final class FeeCalculator {

    private FeeCalculator() {}

    public static int calculate(Vehicle vehicle) {
        int fee = 0;
        if (vehicle.getDuration() <= 30) {
            fee = 0;
        } else if (vehicle.getDuration() <= 60) {
            if (vehicle.getType() == Vehicle.Type.CAR) {
                fee = 3;
            } else if(vehicle.getType() == Vehicle.Type.TRUCK) {
                fee = 5;
            } else {
                fee = 7;
            }
        } else if (vehicle.getDuration() <= 120) {
            if (vehicle.getType() == Vehicle.Type.CAR) {
                fee = 5;
            } else if (vehicle.getType() == Vehicle.Type.TRUCK) {
                fee = 9;
            } else {
                fee = 16;
            }
        } else if (vehicle.getDuration() <= 240) {
            if (vehicle.getType() == Vehicle.Type.CAR) {
                fee = 7;
            } else if (vehicle.getType() == Vehicle.Type.TRUCK) {
                fee = 11;
            } else {
                fee = 19;
            }
        } else {
            int hours = 0;
            hours = (int) Math.floor(vehicle.getDuration() / 60);
            if (vehicle.getType() == Vehicle.Type.CAR) {
                fee = hours;
            } else if (vehicle.getType() == Vehicle.Type.TRUCK) {
                fee = hours * 2;
            } else {
                fee = hours * 3;
            }
        }
        return fee;
    }

}
