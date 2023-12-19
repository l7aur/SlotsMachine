package UI_thingies;
import io.qt.widgets.*;
public class RollButton extends Button {
    public RollButton(QWidget parent) { //create a push button that depends on a widget and has the text 'ROLL'
        super("ROLL", parent);
    }

    void setRollAction(RollButtonClickListener listener){ //create action - click - listener
        this.clicked.connect(listener, "onRollButtonClicked()");
    }
}
