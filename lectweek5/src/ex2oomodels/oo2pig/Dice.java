package ex2oomodels.oo2pig;

import java.util.Random;


/*
    Class representing a Pig dice
    (dice has a memory, will remember last result)

 */
public class Dice {

    private final Random rand = new Random();

    private int lastResult;

    public int roll() {
        lastResult = rand.nextInt(6) + 1;
        return lastResult;
    }

    public int getLastResult() {
        return lastResult;
    }
}
