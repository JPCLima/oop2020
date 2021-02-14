package wsb.creatures;

public enum FoodType {
    ALL (0.3),
    MEET (0.5),
    CROPS (0.7);

    private final double foodToBodyRatio;

    FoodType(double foodToBodyRatio) {
        this.foodToBodyRatio = foodToBodyRatio;
    }

    public double getFoodToBodyRatio() {
        return foodToBodyRatio;
    }
}
