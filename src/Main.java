import UI_thingies.Window;
import io.qt.widgets.*;

public class Main {
    public static void main(String[] args) {
        MySlotsApp.initialize(args);
        try {
            Window window = new Window();
        }catch (Exception e){
          MySlotsApp.quit();
        }
        MySlotsApp.exec();
        MySlotsApp.shutdown();
    }
}