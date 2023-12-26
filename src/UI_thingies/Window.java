package UI_thingies;
import backendish.Account;
import backendish.Wheel;
import io.qt.core.Qt;
import io.qt.gui.*;
import io.qt.widgets.*;

public class Window extends QWidget {
    //parametrisation
    private static final QIcon icon = new QIcon("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\logo2.png");
    private static final String gameName = "KamchatkaGulagSlots";
    //private QLabel betLabel;
    public Window(Wheel theWheel, Account account) {
        //create a window, name it and set its icon
        super();
        setWindowTitle(gameName);
        setWindowIcon(icon);
        QLabel accountSoldDisplay = new QLabel("SOLD: " + account.getSold().toString());
        //betLabel = new QLabel("BET: ");
        QTextEdit betAmount = new QTextEdit("50");
        accountSoldDisplay.setAlignment(Qt.AlignmentFlag.AlignCenter);
        betAmount.setAlignment(Qt.AlignmentFlag.AlignCenter);

        //create the exit button, the roll button + the listeners, the display of the sold and the bet
        ExitButton exitButton = new ExitButton(this);
        RollButton rollButton = new RollButton(this, this, theWheel, account, betAmount);
        RollButtonClickListener rollButtonClickListener = new RollButtonClickListener();
        ExitButtonClickListener exitButtonClickListener = new ExitButtonClickListener();

        //on action do action
        exitButton.setExitAction(exitButtonClickListener);
        rollButton.setRollAction(rollButtonClickListener);

        //add the exit button
        QBoxLayout layout = exitButton.buttonLeftCornerLayout();
        layout.addWidget(accountSoldDisplay);
        layout.addWidget(betAmount);

        //layout.setAlignment();

        //add the initial wheel
        WheelUI wheel = new WheelUI(new QGraphicsScene(), theWheel);
        layout.addWidget(wheel);

        //add the roll button
        layout.addLayout(rollButton.buttonRightCornerLayout());

        //set the GUI in the display window
        setLayout(layout);

        //size the window to 1000x600 and show it
        this.resize(1000, 600);
        this.show();
    }

    public Window updateWindow(Wheel wheel, Account account){
        //get new values in the wheel roll
        wheel.getNewWheel();
        //update the display
        Window newWindow = new Window(wheel, account);
        newWindow.show();
        //return the current display for removal
        return this;
    }
}
