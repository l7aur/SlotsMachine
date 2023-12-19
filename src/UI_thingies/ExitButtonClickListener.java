package UI_thingies;

import io.qt.widgets.QApplication;

public class ExitButtonClickListener {
    public void onExitButtonClicked() {
        System.out.println("Stopping the program...");
        QApplication.quit();
    }
}
