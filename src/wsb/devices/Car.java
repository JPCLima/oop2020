package wsb.devices;

import wsb.creatures.Human;
import wsb.Soldable;

import java.util.Comparator;

public abstract class Car extends Device implements Soldable, Comparable<Car> {
    public final Integer yearOfProduction;
    public final Double sizeOfAnEngine;
    public String plates;
    private Engine engine;
    private boolean isRunning;

    public Car(String producer, String model, Integer yearOfProduction, Double sizeOfAnEngine, Double hoursePower, Double volume, Double milage) {
        super(producer, model);
        this.yearOfProduction = yearOfProduction;
        this.sizeOfAnEngine = sizeOfAnEngine;
        this.isRunning = false;
        this.engine = new Engine(hoursePower, volume, milage);
    }

    abstract public void refuel();

    private class Engine {
        private Double horsePower;
        private Double volume;
        private Double milage;

        public Engine(double horsePower, double volume, double milage){
            this.horsePower = horsePower;
            this.volume = volume;
            this.milage = milage;
        }

        public void turnOn(){
            isRunning = true;
            System.out.println("Car turn ON");
        }

        public void turnOff(){
            isRunning = false;
            System.out.println("Car turn ON");
        }

    }


    public void stopCar(){
        engine.turnOn();
    }

    public void startCar(){
        engine.turnOn();
    }

    public String toString() {
        return this.producer + " " + this.model;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.yearOfProduction - otherCar.yearOfProduction;
    }

    @Override
    public void sell(Human buyer, Human seller, Double price) throws Exception {
        if(!seller.hasACar(this)){
            throw new Exception("seller don't have a car");
        }
        if(!buyer.hasAFreePlace()){
            throw new Exception("bouer dont have a plase");
        }
        if(buyer.cash < price){
            throw new Exception("afwfwaawfawf");
        }
        buyer.removeCar(this);
        seller.addCar(this);
        buyer.cash -= price;
        seller.cash += price;
        System.out.println("great, transaction is done");
    }
}