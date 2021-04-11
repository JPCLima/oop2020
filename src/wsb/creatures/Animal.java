package wsb.creatures;

import wsb.Mapped;

import java.io.File;
import java.sql.SQLException;

public class Animal implements Feedable, Comparable<Animal> {

    public enum Species {
        OMNIVORES, CARNIVOROUS, HERBIVOROUS
    }

    @Mapped
    private Double weight;
    @Mapped
    public String name;
    File pic;


    private static Double OMNIVORES_WEIGHT = 4.0;

    private static Double CARNIVOROUS_WEIGHT = 39.2;

    private static Double HERBIVOROUS_WEIGHT = 5.3;

    private static Double DEFAULT_FEED_WEIGHT = 1.0;

    @Mapped
    private final FoodType foodType;
    @Mapped
    private final Species species;

    public Animal(Species species) {
        this.species = species;

        switch (species) {
            case OMNIVORES: {
                weight = OMNIVORES_WEIGHT;
                this.foodType = FoodType.ALL;
                break;
            }
            case CARNIVOROUS: {
                weight = CARNIVOROUS_WEIGHT;
                this.foodType = FoodType.MEET;
                break;
            }
            case HERBIVOROUS:{
                weight = HERBIVOROUS_WEIGHT;
                this.foodType = FoodType.CROPS;
                break;
            }
            default: {
                weight = 1.0;
                this.foodType = FoodType.ALL;
                break;
            }
        }
        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Animal(Species species, Double weight, FoodType foodType) {
        this.weight = weight;
        this.species = species;
        this.foodType = foodType;
        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void feed() {
        feed(DEFAULT_FEED_WEIGHT);
    }

    public void feed(Double foodWeight) {
        this.weight += this.foodType.getFoodToBodyRatio()*this.weight;
    }

    public void takeForAWalk() {
        if (weight == 0.0) {
            System.out.println("you can't walk the street with dead animal you freak");
        } else if (weight > 3.0) {
            --weight;
            System.out.println(name + " says thx for a walk");
        } else if (weight > 1.0) {
            --weight;
            System.out.println(name + " says thx for a walk but I'm hungry");
        } else {
            weight = 0.0;
            System.out.println(name + " died");
        }
    }

    public Double getWeight() {
        return weight;
    }

    protected void kill() {
        System.out.println("byeeeeeeeeeeeeee");
        this.weight = 0.0;
    }

    public String toString() {
        return "Hi I'm an Animal " + this.species;
    }

    @Override
    public int compareTo(Animal o) {
        return this.species.compareTo(o.species);
    }

    public void save() throws SQLException {
        String sql = "insert into animal values ('" + this.species + "','" + this.name + "'," + this.weight + ");";
        //System.out.println(sql);
        //Connector.executeSQL(sql);
    }
}
