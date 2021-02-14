package wsb;

import wsb.creatures.*;
import wsb.devices.*;

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





    }
}
