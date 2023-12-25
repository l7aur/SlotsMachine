import UI_thingies.Window;
import backendish.Wheel;
import io.qt.widgets.QApplication;

public class MySlotsApp extends QApplication {
    public MySlotsApp(String[] args){
        super(args);
    }
    public static void start(){
        Wheel wheel = new Wheel();
        Window window = new Window(null);
        MySlotsApp.exec();
    }
}
