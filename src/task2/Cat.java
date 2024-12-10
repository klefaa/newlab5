package task2;

public class Cat implements Meowing {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public String toString() {
        return "кот: " + name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }
}