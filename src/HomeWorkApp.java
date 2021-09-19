public class HomeWorkApp {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Loyso", 65), new Cat("Wishka", 45), new Cat("Tessa", 30)};
        Plate plate = new Plate(100);
        plate.addFood(5);
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.getName() + " is well fed? " + cat.satiety);
        }
    }
}
