package task2;

public class MeowingCounter implements Meowing {
    private final Meowing meowing;
    private int count = 0;

    public MeowingCounter(Meowing meowing){
        this.meowing = meowing;
    }

    public void meow(){
        meowing.meow();
        count++;
    }

    public int getCount(){
        return count;
    }
}   