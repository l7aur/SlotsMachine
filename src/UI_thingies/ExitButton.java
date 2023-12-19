package UI_thingies;
import io.qt.widgets.*;
public class ExitButton extends Button {
    public ExitButton(QWidget parent) { //create a push button that depends on a widget and has the text 'EXIT'
        super("EXIT", parent);
    }

    public void setExitAction(ExitButtonClickListener listener){ //create action - click - listener
        this.clicked.connect(listener, "onExitButtonClicked()");
    }
}
