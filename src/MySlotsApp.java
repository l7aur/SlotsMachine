import UI_thingies.Window;
import backendish.Account;
import backendish.Wheel;
import io.qt.widgets.QApplication;

public class MySlotsApp extends QApplication {
    public MySlotsApp(String[] args){
        super(args);
    }
    public static void start(){
        Wheel wheel = new Wheel();
        Account account = new Account(1000.0);
        Window window = new Window(wheel, account);
        MySlotsApp.exec();
    }
}
