package backendish;

import java.util.ArrayList;
import java.util.Random;
public class Wheel {
    private ArrayList<Integer> luckyNumbers= new ArrayList<>();
    private static final Integer startingImageNumber = 1; // has to be smaller than the size of the luckyNumberArray
    private static final Integer arraySize = 10;

    public Wheel(){
        //constructor
        for (int i = 0; i < arraySize; i++) {
            this.luckyNumbers.add(startingImageNumber);
        }
    }

    public void getNewWheel() {
        //delete the previous values
        this.luckyNumbers.clear();
        System.out.println("New wheel generation: ");
        //get new values inside the array
        for (int i = 0; i < arraySize; i++) {
            this.luckyNumbers.add(new Random().nextInt(arraySize));
            System.out.print(luckyNumbers.get(i) + " ");
        }
        System.out.println();
    }
    public ArrayList<Integer> getLuckyNumbers() {
        return luckyNumbers;
    }
}
