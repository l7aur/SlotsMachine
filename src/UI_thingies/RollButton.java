package UI_thingies;
import io.qt.widgets.*;
import backendish.Wheel;

public class RollButton extends Button {
    private Window window;
    private Wheel wheel;

    public RollButton(QWidget parent, Window window, Wheel wheel) {
        super("ROLL", parent);
        this.window = window;
        this.wheel = wheel;
    }

    void setRollAction(RollButtonClickListener listener){
        //idk lambda function
        this.clicked.connect(() -> listener.onRollButtonClicked(window, wheel));
    }
}
