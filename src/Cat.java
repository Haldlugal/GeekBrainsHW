public class Cat {


    private final String name;
    private final int appetite;
    boolean satiety = false;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        if (p.decreaseFood(appetite))
        {
            this.satiety = true;
        }
    }

    public String getName() {
        return name;
    }
}