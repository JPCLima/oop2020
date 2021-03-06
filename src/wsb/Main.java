package wsb;

import wsb.creatures.Animal;
import wsb.creatures.Gender;
import wsb.creatures.Human;
import wsb.creatures.Pet;
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
        Animal tiger = new Animal(Animal.Species.CARNIVOROUS);

        // Feed the cow
        System.out.println("Weight cow before: " + cow.getWeight());
        Double crops = 10.0;
        System.out.println("Feed the cow with: " + crops + "kg crops");
        cow.feed(10.0);
        System.out.println("Weight cow after: " + cow.getWeight());

        // Get the GDP from Argentina in PLN
        System.out.printf("%.0f",Country.ARGENTINA.getGdpInPLN());
        System.out.println("\nCountry Language: " + Country.PORTUGAL.getLanguage());

        // Task 4
        DieselCar car1 = new DieselCar("Kia", "Niro", 2009, 2.0, 1000.0, 150.0, 0.0);
        DieselCar car2 = new DieselCar("Mazda", "CX-9", 2009, 2.0, 1000.0, 150.0, 0.0);
        ElectricCar car3 = new ElectricCar("Ford", "Y-500", 2009, null, 1000.0, 105.0, 0.0);
        ElectricCar car4 = new ElectricCar("Ford", "P-20", 2009, null, 1000.0, 105.0, 0.0 );

        Map<String, Car> garage = new HashMap<>();
        garage.put(car1.model, car1);
        garage.put(car2.model, car2);
        garage.put(car3.model, car3);
        garage.put(car4.model, car4);

        List<String> sortedKeys = new ArrayList<String>(garage.size());
        sortedKeys.addAll(garage.keySet());
        Collections.sort(sortedKeys);
        for(String model: sortedKeys) {
            System.out.println(garage.get(model));
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
        producers.put("Huawei", producedByHuawei);

        List<Device> producedByFord = new ArrayList<Device>() {{
            add(car3);
            add(car2);
        }};
        producers.put("Ford", producedByFord);

        // Find all devices produced by Ford and Siemens
        producers.get("Siemens").forEach(System.out::println);
        producers.get("Ford").forEach(System.out::println);

        // Task 8
        Animal cat1 = new Pet(Animal.Species.OMNIVORES);
        Animal cat2 = new Pet(Animal.Species.OMNIVORES);
        Animal dog1 = new Pet(Animal.Species.OMNIVORES);
        Animal dog2 = new Pet(Animal.Species.OMNIVORES);

        List<Animal> animalsAnonymous = new ArrayList<Animal>() {{
            add(lion);
            add(cow);
            add(cat1);
            add(cat2);
            add(dog1);
            add(dog2);
        }};

        Comparator<Animal> weightComparator =  new Comparator<Animal>() {
            @Override
            public int compare(Animal a1, Animal a2) {
                return (int) (a1.getWeight() - a2.getWeight());
            }
            @Override
            public boolean equals(Object obs){
                return false;
            }
        };

        animalsAnonymous.sort(weightComparator);
        for(Animal animal: animalsAnonymous){
            System.out.println(animal.getWeight());
        }

        // Task 9
        Counter counter = new Counter(10);
        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);
        Thread thread3 = new Thread(counter);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
