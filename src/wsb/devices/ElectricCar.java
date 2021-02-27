package wsb.devices;

public class ElectricCar extends Car {
    public ElectricCar(String producer, String model, Integer yearOfProduction, Double sizeOfAnEngine, Double hoursePower, Double volume, Double milage) {
        super(producer, model, yearOfProduction, null, hoursePower, volume, milage);
    }

    @Override
    public void refuel() {
        System.out.println("Refueled with electric power");
    }

    public String toString(){
        return "That is an electric car " + super.toString();
    }

}
