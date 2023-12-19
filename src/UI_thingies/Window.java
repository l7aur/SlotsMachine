package UI_thingies;
import io.qt.gui.QIcon;
import io.qt.widgets.*;

public class Window extends QWidget {
    public Window() {
        //create a window and set its icon
        super();
        setWindowTitle("KamchatkaGulagSlots");
        QIcon icon = new QIcon("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\logo2.png");
        setWindowIcon(icon);

        //add the exit button in the bottom left corner
        //add the roll button in the bottom right corner
        ExitButton exitButton = new ExitButton(this);
        RollButton rollButton = new RollButton(this);

        //add the event listeners
        ExitButtonClickListener exitListener = new ExitButtonClickListener();
        RollButtonClickListener rollListener = new RollButtonClickListener();

        //on action do action
        exitButton.setExitAction(exitListener);
        rollButton.setRollAction(rollListener);

        //set the layout
        QBoxLayout layout = exitButton.buttonLeftCornerLayout();
        layout.addLayout(rollButton.buttonRightCornerLayout());
        setLayout(layout);

        //size the window to 1080x720 and show it
        this.resize(1080, 720);
        this.show();
    }
}
