package wsb.devices;

public class DieselCar extends Car {
    public DieselCar(String producer, String model, Integer yearOfProduction, Double sizeOfAnEngine, Double hoursePower, Double volume, Double milage) {
        super(producer, model, yearOfProduction, sizeOfAnEngine, hoursePower, volume, milage);
    }

    @Override
    public void refuel() {
        System.out.println("Refueled with diesel (screw the world)");
    }

    public String toString() {
        return "This is a stinky diesel car " + super.toString();
    }
}
