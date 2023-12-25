package backendish;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Wheel {
    private final ArrayList<Integer> luckyNumbers= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
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
