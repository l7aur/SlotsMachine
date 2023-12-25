package backendish;


import UI_thingies.WheelUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Wheel {
    private ArrayList<Integer> luckyNumbers= new ArrayList<>();
    private static final Integer startingImageNumber = 1; // has to be smaller than the size of the luckyNumberArray
    private static final Integer arraySize = 10;

    public Wheel(){
        for (int i = 0; i < arraySize; i++) {
            this.luckyNumbers.add(startingImageNumber);
        }
    }

    public void getNewWheel() {
        this.luckyNumbers.clear();
        System.out.println("New wheel generation: ");
        for (int i = 0; i < 10; i++) {
            this.luckyNumbers.add(new Random().nextInt(10));
            System.out.print(luckyNumbers.get(i) + " ");
        }
        System.out.println();
    }
    public ArrayList<Integer> getLuckyNumbers() {
        return luckyNumbers;
    }
}
