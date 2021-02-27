package wsb;

import wsb.creatures.Animal;
import wsb.creatures.Gender;
import wsb.creatures.Human;
import wsb.devices.*;

import java.util.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        // Enum: is a list of properties
        Human eu = new Human(3, Gender.MAN);
        eu.sayInFirst();
        System.out.println(Gender.UNSPECIFIED);

        // Create new phone
        Phone phone = new Phone("Huawei", "P20",  5.2, OperatingSystem.ANDROID);
        System.out.println(phone.operatingSystem);

        // Turn on the phone
        phone.turnOn();

        // Create Animal
        Animal lion = new Animal(Animal.Species.CARNIVOROUS);
        Animal cow = new Animal(Animal.Species.HERBIVOROUS);

        // Feed the cow
        System.out.println("Weight cow before: " + cow.getWeight());
        Double crops = 10.0;
        System.out.println("Feed the cow with: " + crops + "kg crops");
        cow.feed(10.0);
        System.out.println("Weight cow after: " + cow.getWeight());

        // Get the GDP from Argentina in PLN
        System.out.printf("%.0f",Country.ARGENTINA.getGdpInPLN());
        System.out.println("\nCountry Language: " + Country.PORTUGAL.getLanguage());

        // HashMap
        //Car(String producer, String model, Integer yearOfProduction, Double sizeOfAnEngine)
        DieselCar car1 = new DieselCar("Kia", "Niro", 2009, 2.0);
        DieselCar car2 = new DieselCar("Mazda", "CX-9", 2009, 2.0);
        ElectricCar car3 = new ElectricCar("Ford", "model Y", 2009);
        ElectricCar car4 = new ElectricCar("Ford", "model P", 2009);

        Map<String, Double> garageUnsort = new HashMap<>();
        garageUnsort.put(car1.model, 30000.0);
        garageUnsort.put(car2.model, 10000.0);
        garageUnsort.put(car3.model, 20000.0);
        garageUnsort.put(car4.model, 140000.0);

        System.out.println("Before sorting......");
        System.out.println(garageUnsort);

        // Get all the cars from garage
        for (Map.Entry<String, Double> en : garageUnsort.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }

        for(String car: garageUnsort.keySet()){
            System.out.println("Model: " + car + " | Producer: " + garageUnsort.get(car));
        }

        //  Task 5
        //  Create new map with the areas
        Map<Country, Double> countryAreaMap = new HashMap<>();
        countryAreaMap.put(Country.ARGENTINA, 2780400.0);
        countryAreaMap.put(Country.POLAND, 312696.0);
        countryAreaMap.put(Country.PORTUGAL, 92226.0);
        countryAreaMap.put(Country.SPAIN, 505992.0);

        System.out.println("Largest Country: " +
                Collections.max(countryAreaMap.entrySet(), Map.Entry.comparingByValue()).getKey()
        );
        System.out.println("Smallest Country: " +
                Collections.min(countryAreaMap.entrySet(), Map.Entry.comparingByValue()).getKey()
        );



        // Task 6
        HashMap<String, List<Device>> producers = new HashMap<>();
        List<Device> producedBySiemens = new ArrayList<Device>() {{
            add(new Phone("Siemens", "model X", 5.1, OperatingSystem.ANDROID));
        }};
        producers.put("Siemens", producedBySiemens);

        List<Device> producedByHuawei = new ArrayList<Device>() {{
            add(new Phone("Huawei", "model Y", 5.2, OperatingSystem.ANDROID));
        }};
        producers.put("Huawei", producedBySiemens);

        List<Device> producedByFord = new ArrayList<Device>() {{
            add(car3);
            add(car2);
        }};
        producers.put("Ford", producedByFord);

        // Find all devices produced by Ford and Siemens
        producers.get("Siemens").forEach(System.out::println);
        producers.get("Ford").forEach(System.out::println);

    }
}
