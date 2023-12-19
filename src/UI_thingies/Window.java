package UI_thingies;
import io.qt.gui.QIcon;
import io.qt.widgets.QHBoxLayout;
import io.qt.widgets.QVBoxLayout;
import io.qt.widgets.QWidget;

public class Window extends QWidget {
    public Window() throws Exception {
        //create a window and set its icon
        super();
        setWindowTitle("KamchatkaGulagSlots");
        QIcon icon = new QIcon("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\logo2.png");
        setWindowIcon(icon);

        //add the exit button in the bottom right corner
        ExitButton exitButton = new ExitButton(this);
        setLayout(exitButton.buttonRightCornerLayout());

        //size the window to 1080x720 and show it
        this.resize(1080, 720);
        this.show();
    }
}