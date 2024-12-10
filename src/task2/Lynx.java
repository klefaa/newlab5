package task2;

public class Lynx implements Meowing {
    private final String name;

    public Lynx(String name) {
        this.name = name;
    }

    public String toString() {
        return "рысь: " + name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }
}