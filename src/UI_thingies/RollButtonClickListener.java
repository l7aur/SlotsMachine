package UI_thingies;

import backendish.Wheel;

public class RollButtonClickListener {
    public void onRollButtonClicked(Window window, Wheel wheel) {
        System.out.println("ROLLING...");
        window.updateWindow(wheel);
    }
}
