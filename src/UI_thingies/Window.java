package UI_thingies;
import io.qt.gui.*;
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
        //rollButton.setRollAction(rollListener);

        //add the exit button
        QBoxLayout layout = exitButton.buttonLeftCornerLayout();
        layout.setAlignment();

//        QGraphicsView view = new QGraphicsView(new QGraphicsScene());
//        QGraphicsLineItem line = new QGraphicsLineItem(0, 0, 1000, 700);
//        view.scene().addItem(line);
//        layout.addWidget(view);

        WheelUI wheel = new WheelUI(new QGraphicsScene());
        layout.addWidget(wheel);

        //add the roll button
        layout.addLayout(rollButton.buttonRightCornerLayout());

        setLayout(layout);
        //size the window to 1080x720 and show it
        this.resize(1000, 800);
        this.show();
    }
}
