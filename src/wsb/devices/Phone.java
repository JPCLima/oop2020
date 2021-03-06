package wsb.devices;

import wsb.App;
import wsb.Mapped;
import wsb.creatures.Human;

import java.util.*;

public class Phone extends Device {
    @Mapped
    final Double screenSize;

    public List<App> applications;
    @Mapped
    public final OperatingSystem operatingSystem;

    public Phone(String producer, String model, Double screenSize, OperatingSystem operatingSystem) {
        super(producer, model);
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        applications = new LinkedList<>();
    }


    public void turnOn() {
        switch (this.operatingSystem){
            case IOS:
                System.out.println("Apple ON");
                break;
            case ANDROID:
                System.out.println("Android ON");
                break;
            case WINDOWS_MOBILE:
                System.out.println("Windows Mobile ON");
                break;
        }
    }


    public void sell() {
        System.out.println("already sold");
    }

    public void installAnApp(App app, Human owner) throws Exception {
        if (app.getPrice() > 0) {
            if (owner.cash < app.getPrice()) {
                throw new Exception("not enough money");
            }
            owner.cash -= app.getPrice();
        }
        applications.add(app);
        System.out.println("Application " + app.getName() + " installed");
    }

    public void installAnApp(String name) {
        installAnApp(name, 0.0);
    }


    public void installAnApp(String[] apps) {
        for (String app : apps) {
            installAnApp(app);
        }
    }

    public void installAnApp(String name, Double version) {
        System.out.println("The app " + name + " was installed in version " + version);
    }

    public boolean isInstalled(App app) {
        return applications.contains(app);
    }

    public boolean isInstalled(String appName) {
        for (App application : applications) {
            if (application.getName().equals(appName)) {
                return true;
            }
        }
        return false;
    }

}
