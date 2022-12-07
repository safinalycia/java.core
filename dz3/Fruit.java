package dz3;

public abstract class Fruit {

    private String nameFruit;

    private Integer weightFruit;

    public Fruit(String nameFruit, Integer weightFruit) {
        this.nameFruit = nameFruit;
        this.weightFruit = weightFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public Integer getWeightFruit() {
        return weightFruit;
    }
}
