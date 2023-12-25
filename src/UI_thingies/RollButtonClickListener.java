package UI_thingies;

import backendish.Wheel;

public class RollButtonClickListener {
    public void onRollButtonClicked(Window window, Wheel wheel) {
        System.out.println("ROLLING...");
        Window window1 =  window.updateWindow(wheel);
        window1.dispose(); //good enough optimization
    }
}
