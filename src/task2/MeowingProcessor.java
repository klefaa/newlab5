package task2;

public class MeowingProcessor {
    public static void processMeowing(Meowing... meowers){
        for (Meowing meower : meowers) meower.meow();
    }
}