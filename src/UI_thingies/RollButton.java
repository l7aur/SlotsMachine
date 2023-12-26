package UI_thingies;
import backendish.Account;
import io.qt.core.Qt;
import io.qt.widgets.*;
import backendish.Wheel;

public class RollButton extends Button {
    private Window window;
    private Wheel wheel;
    private Account account;
    private QTextEdit text;

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
