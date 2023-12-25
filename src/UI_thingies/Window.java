package UI_thingies;
import backendish.Wheel;
import io.qt.gui.*;
import io.qt.widgets.*;

public class Window extends QWidget {
    //parametrisation
    private static final QIcon icon = new QIcon("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\logo2.png");
    private static final String gameName = "KamchatkaGulagSlots";
    private static QBoxLayout layout;
    private QGraphicsScene graphicsScene = new QGraphicsScene();
    //private RollButtonClickListener rollButtonClickListener;
    //private ExitButtonClickListener exitButtonClickListener;
    public Window(Wheel theWheel) {
        //create a window, name it and set its icon
        super();
        setWindowTitle(gameName);
        setWindowIcon(icon);

        //add the exit button in the bottom left corner
        //add the roll button in the bottom right corner
        ExitButton exitButton = new ExitButton(this);
        RollButton rollButton = new RollButton(this, this, theWheel);

        //add the event listeners
        RollButtonClickListener rollButtonClickListener = new RollButtonClickListener();
        ExitButtonClickListener exitButtonClickListener = new ExitButtonClickListener();

        //on action do action
        exitButton.setExitAction(exitButtonClickListener);
        rollButton.setRollAction(rollButtonClickListener);

        //add the exit button
        layout = exitButton.buttonLeftCornerLayout();
        layout.setAlignment();

        //add the initial wheel
        WheelUI wheel;
        if(theWheel != null)
            wheel = new WheelUI(new QGraphicsScene(), theWheel);
        else
            wheel = new WheelUI(new QGraphicsScene());
        layout.addWidget(wheel);

        //add the roll button
        layout.addLayout(rollButton.buttonRightCornerLayout());

        //set the GUI in the display window
        setLayout(layout);

        //size the window to 1000x600 and show it
        this.resize(1000, 600);
        this.show();
    }

    public Window updateWindow(Wheel wheel){
        System.out.println("nu");
        if(wheel == null)
            wheel = new Wheel();
        wheel.getNewWheel();
        System.out.println("updateWindow: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(wheel.getLuckyNumbers().get(i) + " ");
        }
        System.out.println();
        //this.hide(); //TBD
        return new Window(wheel);
    }

//    public RollButtonClickListener getRollButtonClickListener() {
//        return rollButtonClickListener;
//    }
}
