package UI_thingies;
import io.qt.widgets.*;
public class ExitButton extends QPushButton {
    public ExitButton(QWidget parent) { //create a push button that depends on a widget and has the text 'EXIT'
        super("EXIT", parent);
    }

    void setExitAction(ExitButtonClickListener listener){ //create action - click - listener
        this.clicked.connect(listener, "onExitButtonClicked()");
    }
    void onExitButtonClicked() { //action on button click
        QApplication.shutdown();
    }
    public QLayout buttonRightCornerLayout(){ //dynamically place the button in the bottom right corner
        //horizontal centered layout
        QHBoxLayout exitButtonLayout1 = new QHBoxLayout();
        //vertical centered layout
        QVBoxLayout exitButtonLayout2 = new QVBoxLayout();
        //shift to right
        exitButtonLayout1.addStretch();
        //shift to left
        exitButtonLayout2.addStretch();
        //add the button
        exitButtonLayout1.addWidget(this);
        //create a superposition of the 2 layouts and return it (entangle the layouts)
        exitButtonLayout2.addLayout(exitButtonLayout1);

        return exitButtonLayout2;
    }
}
