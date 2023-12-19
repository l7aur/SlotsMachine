import UI_thingies.Window;
import io.qt.widgets.QApplication;

public class MySlotsApp extends QApplication {
    public MySlotsApp(String[] args){
        super(args);
    }
    public static void start(){
        Window window = new Window();
        MySlotsApp.exec();
    }
}
