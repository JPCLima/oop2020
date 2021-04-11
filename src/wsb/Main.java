package wsb;

import wsb.threads.CallableCounter;
import wsb.threads.Finisher;
import wsb.threads.RunnableCounter;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws Exception {

//        // Enum: is a list of properties
//        Human eu = new Human(3, Gender.MAN);
//        eu.sayInFirst();
//        System.out.println(Gender.UNSPECIFIED);
//
//        // Create new phone
//        Phone phone = new Phone("Huawei", "P20",  5.2, OperatingSystem.ANDROID);
//        System.out.println(phone.operatingSystem);
//
//        // Turn on the phone
//        phone.turnOn();
//
//        // Create Animal
//        Animal lion = new Animal(Animal.Species.CARNIVOROUS, 120.0, FoodType.MEET);
//        Animal cow = new Animal(Animal.Species.HERBIVOROUS, 80.0, FoodType.MEET);
//        Animal tiger = new Animal(Animal.Species.CARNIVOROUS, 100.0, FoodType.MEET);
//
//        // Feed the cow
//        System.out.println("Weight cow before: " + cow.getWeight());
//        Double crops = 10.0;
//        System.out.println("Feed the cow with: " + crops + "kg crops");
//        cow.feed(10.0);
//        System.out.println("Weight cow after: " + cow.getWeight());
//
//        // Get the GDP from Argentina in PLN
//        System.out.printf("%.0f",Country.ARGENTINA.getGdpInPLN());
//        System.out.println("\nCountry Language: " + Country.PORTUGAL.getLanguage());
//
//        // Task 4
//        DieselCar car1 = new DieselCar("Kia", "Niro", 2009, 2.0, 1000.0, 150.0, 0.0);
//        DieselCar car2 = new DieselCar("Mazda", "CX-9", 2009, 2.0, 1000.0, 150.0, 0.0);
//        ElectricCar car3 = new ElectricCar("Ford", "Y-500", 2009, null, 1000.0, 105.0, 0.0);
//        ElectricCar car4 = new ElectricCar("Ford", "P-20", 2009, null, 1000.0, 105.0, 0.0 );
//
//        Map<String, Car> garage = new HashMap<>();
//        garage.put(car1.model, car1);
//        garage.put(car2.model, car2);
//        garage.put(car3.model, car3);
//        garage.put(car4.model, car4);
//
//        List<String> sortedKeys = new ArrayList<String>(garage.size());
//        sortedKeys.addAll(garage.keySet());
//        Collections.sort(sortedKeys);
//        for(String model: sortedKeys) {
//            System.out.println(garage.get(model));
//        }
//
//        //  Task 5
//        //  Create new map with the areas
//        Map<Country, Double> countryAreaMap = new HashMap<>();
//        countryAreaMap.put(Country.ARGENTINA, 2780400.0);
//        countryAreaMap.put(Country.POLAND, 312696.0);
//        countryAreaMap.put(Country.PORTUGAL, 92226.0);
//        countryAreaMap.put(Country.SPAIN, 505992.0);
//
//        System.out.println("Largest Country: " +
//                Collections.max(countryAreaMap.entrySet(), Map.Entry.comparingByValue()).getKey()
//        );
//        System.out.println("Smallest Country: " +
//                Collections.min(countryAreaMap.entrySet(), Map.Entry.comparingByValue()).getKey()
//        );
//
//        // Task 6
//        HashMap<String, List<Device>> producers = new HashMap<>();
//        List<Device> producedBySiemens = new ArrayList<Device>() {{
//            add(new Phone("Siemens", "model X", 5.1, OperatingSystem.ANDROID));
//        }};
//        producers.put("Siemens", producedBySiemens);
//
//        List<Device> producedByHuawei = new ArrayList<Device>() {{
//            add(new Phone("Huawei", "model Y", 5.2, OperatingSystem.ANDROID));
//        }};
//        producers.put("Huawei", producedByHuawei);
//
//        List<Device> producedByFord = new ArrayList<Device>() {{
//            add(car3);
//            add(car2);
//        }};
//        producers.put("Ford", producedByFord);
//
//        // Find all devices produced by Ford and Siemens
//        producers.get("Siemens").forEach(System.out::println);
//        producers.get("Ford").forEach(System.out::println);
//
//        // Task 8
//        Animal cat1 = new Pet(Animal.Species.OMNIVORES);
//        Animal cat2 = new Pet(Animal.Species.OMNIVORES);
//        Animal dog1 = new Pet(Animal.Species.OMNIVORES);
//        Animal dog2 = new Pet(Animal.Species.OMNIVORES);
//
//        List<Animal> animalsAnonymous = new ArrayList<Animal>() {{
//            add(lion);
//            add(cow);
//            add(cat1);
//            add(cat2);
//            add(dog1);
//            add(dog2);
//        }};
//
//        Comparator<Animal> weightComparator =  new Comparator<Animal>() {
//            @Override
//            public int compare(Animal a1, Animal a2) {
//                return (int) (a1.getWeight() - a2.getWeight());
//            }
//            @Override
//            public boolean equals(Object obs){
//                return false;
//            }
//        };
//
//        animalsAnonymous.sort(weightComparator);
//        for(Animal animal: animalsAnonymous){
//            System.out.println(animal.getWeight());
//        }
//
//        // Task 9
//        Counter counter = new Counter(10);
//        Thread thread1 = new Thread(counter);
//        Thread thread2 = new Thread(counter);
//        Thread thread3 = new Thread(counter);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//
//        // Task 10
//        // One thread
//        List<Integer> l1 = generateNewList(10);
//        List<Integer> l2 = generateNewList(50);
//        List<Integer> l3 = generateNewList(100);
//        List<Integer> l4 = generateNewList(150);
//
//        CallableSorter sorter1 = new CallableSorter(l1);
//        CallableSorter sorter2 = new CallableSorter(l2);
//        CallableSorter sorter3 = new CallableSorter(l3);
//        CallableSorter sorter4 = new CallableSorter(l4);
//
//        long startTime1 = System.currentTimeMillis();
//        sorter1.call();
//        sorter2.call();
//        sorter3.call();
//        sorter4.call();
//        long endTime1 = System.currentTimeMillis();
//        long duration1 = (endTime1 - startTime1);
//        System.out.println("1 Thread: " + duration1);
//
//        // Four thread
//        long startTime2 = System.currentTimeMillis();
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService4 = Executors.newSingleThreadExecutor();
//
//        Future<List<Integer>> future1 = executorService1.submit(sorter1);
//        Future<List<Integer>> future2 = executorService2.submit(sorter2);
//        Future<List<Integer>> future3 = executorService3.submit(sorter3);
//        Future<List<Integer>> future4 = executorService4.submit(sorter4);
//
//        List<Integer> r1 = future1.get();
//        List<Integer> r2 = future2.get();
//        List<Integer> r3 = future3.get();
//        List<Integer> r4 = future4.get();
//
//        long endTime2 = System.currentTimeMillis();
//        long duration2 = (endTime2 - startTime2);
//        System.out.println("4 Thread: " + duration2);
//        executorService1.shutdown();
//        executorService2.shutdown();
//        executorService3.shutdown();
//        executorService4.shutdown();
//
//        // Task 11
//        List<Animal> animalsLambda = new ArrayList<Animal>() {{
//            add(tiger);
//            add(lion);
//            add(cow);
//            add(dog1);
//            add(dog2);
//        }};
//        animalsLambda.sort((Animal a, Animal b) -> (int)(a.getWeight() - b.getWeight()));
//
//        System.out.println("Sort Animals weight:");
//        for(Animal a: animalsLambda) {
//            System.out.println(a.getWeight());
//        }

//        // Task 9 - a)
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
//        executor.submit(new RunnableCounter());
//        executor.submit(new RunnableCounter());
//        executor.submit(new RunnableCounter());
//
//        // Finish the Thread
//        executor.shutdown();

        // Task 9 - b)
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        executor.submit(new SubZero());
//        executor.submit(new Scorpion());
//        executor.submit(new SubZero());
//        executor.submit(new Scorpion());
//
//
//        // Finish the Thread
//        executor.shutdown();

        // Task 9 - c) and d)
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        RunnableCounter subZero = new RunnableCounter();
//        subZero.finisher = () -> System.out.println("YOU ARE FROZEN");
//
//
//        RunnableCounter scorpion = new RunnableCounter();
//        subZero.finisher = () -> System.out.println("YOU ARE POISONED");
//
//        executor.submit(subZero);
//        executor.submit(scorpion);
//
//        executor.shutdown();
    // Task 9 - e)
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//
//        CallableCounter callCounter1 = new CallableCounter();
//        CallableCounter callCounter2 = new CallableCounter();
//
//        Future<Double> future1 = executor.submit(callCounter1);
//        Future<Double> future2  = executor.submit(callCounter2);
//
//        System.out.println(future1.get());
//        System.out.println(future2.get());
//
//        executor.shutdown();
        // Task 9 - f)
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        CallableCounter callCounter1 = new CallableCounter();
        CallableCounter callCounter2 = new CallableCounter();

        callCounter1.finisher = () -> System.out.println("Finisher 1");
        callCounter2.finisher = () -> System.out.println("Finisher 2");

        Future<Double> future1 = executor.submit(callCounter1);
        Future<Double> future2  = executor.submit(callCounter2);

        System.out.println(future1.get());
        System.out.println(future2.get());

        executor.shutdown();


    }

    static List<Integer> generateNewList(int size) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i += 1) {
            Integer randomNumber = (int)(Math.random() * size + 1);
            list.add(randomNumber);
        }
        return list;
    }
}
