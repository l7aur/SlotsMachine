package UI_thingies;

import backendish.Account;
import backendish.Wheel;
import io.qt.widgets.QTextEdit;

public class RollButtonClickListener {
    public void onRollButtonClicked(Window window, Wheel wheel, Account account, QTextEdit text) {
        Double betAmount = 0.0;
        try {
            String kappa = text.toPlainText();
            betAmount = Double.parseDouble(kappa.trim());
        if(betAmount <= 0){
            System.out.println("Impossible to bet with negative amount!");
        }
        else if(account.getSold() >= betAmount){
            account.updateSold(-1.0 * betAmount);
            System.out.println("ROLLING...");

            Window window1 =  window.updateWindow(wheel,account, betAmount);
            window1.dispose(); //good enough optimization
        }
        else //not enough money
            System.out.println("Insufficient Funds!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }
}
