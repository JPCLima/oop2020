package wsb.creatures;

public class FarmAnimal extends Animal implements Edible{



    public FarmAnimal(Species species) {
        super(species);
    }

    @Override
    public void beEaten() throws Exception {
        this.kill();
        System.out.println("that was yuammy");
    }
}
