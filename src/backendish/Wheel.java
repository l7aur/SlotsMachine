package backendish;

import java.util.ArrayList;
import java.util.Random;
public class Wheel {
    private final ArrayList<Integer> luckyNumbers= new ArrayList<>();
    private static final Integer arraySize = 10;
    private final Tier1Number tier1Number;
    private final Tier2Number tier2Number1, tier2Number2;
    private final Tier3Number tier3Number1, tier3Number2, tier3Number3;
    private final Tier4Number tier4Number1, tier4Number2, tier4Number3, tier4Number4;
    public Wheel(){
        //0 lowest chance to drop, 9 highest
        this.tier1Number = new Tier1Number(0); //tuica
        this.tier2Number1 = new Tier2Number(1); //jack
        this.tier2Number2 = new Tier2Number(2); //vodka
        this.tier3Number1 = new Tier3Number(3); //gin
        this.tier3Number2 = new Tier3Number(4); //rum
        this.tier3Number3 = new Tier3Number(5); //campari
        this.tier4Number1 = new Tier4Number(6); //champagne
        this.tier4Number2 = new Tier4Number(7); //wine
        this.tier4Number3 = new Tier4Number(8); //strongbow
        this.tier4Number4 = new Tier4Number(9); //beer
        //constructor
        for (int i = 0; i < arraySize; i++) {
            this.luckyNumbers.add(this.tier1Number.getUniqueIdentifier());
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

    public Tier1Number getTier1Number() {
        return tier1Number;
    }

    public Tier2Number getTier2Number1() {
        return tier2Number1;
    }

    public Tier2Number getTier2Number2() {
        return tier2Number2;
    }

    public Tier3Number getTier3Number1() {
        return tier3Number1;
    }

    public Tier3Number getTier3Number2() {
        return tier3Number2;
    }

    public Tier3Number getTier3Number3() {
        return tier3Number3;
    }

    public Tier4Number getTier4Number1() {
        return tier4Number1;
    }

    public Tier4Number getTier4Number2() {
        return tier4Number2;
    }

    public Tier4Number getTier4Number3() {
        return tier4Number3;
    }

    public Tier4Number getTier4Number4() {
        return tier4Number4;
    }
}
