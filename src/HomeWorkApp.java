import java.sql.SQLOutput;

public class HomeWorkApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Loyso");
        cat.swim(22);
        cat.run(70);
        Dog dog = new Dog("Rocky");
        dog.run(1200);
        dog.swim(23);
        Cat cat2 = new Cat("Wishka");

        System.out.println(Animal.getCount());
        System.out.println(Dog.getCount());
        System.out.println(Cat.getCount());

    }
}

abstract class Animal {
    protected final String name;
    public static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getCount() {
        return count;
    }
}

class Cat extends Animal {
    private final int runLimit = 200;
    public static int count = 0;

    public Cat(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " шустренько пробежал " + distance + " метров");
        } else {
            System.out.println(distance + " метров. Слишком много для того, чтобы " + name + " смог их пробежать");
        }
    }

    public void swim(int distance) {
        System.out.println(name + " гордо отказывается плавать! Он кот!");
    }
}

class Dog extends Animal {
    private final int runLimit = 500;
    private final int swimLimit = 10;
    public static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " мощно пробежал " + distance + " метров. Это все лапищи!");
        } else {
            System.out.println(distance + " метров. Слишком много для того, чтобы " + name + " смог их пробежать");
        }
    }

    public void swim(int distance) {
        if (distance > swimLimit) {
            System.out.println(name + " успешно осуществил заплыв на " + distance + " метров");
        } else {
            System.out.println(name + "не стал плыть " + distance + " метров. Слишком много для него!");
        }
    }
}
