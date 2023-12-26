package UI_thingies;
import backendish.Account;
import io.qt.widgets.*;
import backendish.Wheel;

public class RollButton extends Button {
    private final Window window;
    private final Wheel wheel;
    private final Account account;
    private final QTextEdit text;

    public RollButton(QWidget parent, Window window, Wheel wheel, Account account, QTextEdit text) {
        super("ROLL", parent);
        this.window = window;
        this.wheel = wheel;
        this.account = account;
        this.text = text;
    }

    void setRollAction(RollButtonClickListener listener){
        //idk lambda function
        this.clicked.connect(() -> listener.onRollButtonClicked(window, wheel, account, text));
    }
}
