package UI_thingies;

import io.qt.widgets.*;

public class Button extends QPushButton {
    Button(String string, QWidget parent){
        super(string, parent);
    }
    public QBoxLayout buttonRightCornerLayout(){ //dynamically place the button in the bottom right corner
        //create alignment from bottom right to top left and place the button
        QBoxLayout layout1 = new QBoxLayout(QBoxLayout.Direction.BottomToTop);
        QBoxLayout layout = new QBoxLayout(QBoxLayout.Direction.RightToLeft);
        layout1.addWidget(this);
        layout1.addStretch();
        layout.addLayout(layout1);
        layout.addStretch();
        return layout;
    }
    public QBoxLayout buttonLeftCornerLayout(){ //dynamically place the button in the bottom right corner
        //create alignment from bottom left to top right and place the button
        QBoxLayout layout1 = new QBoxLayout(QBoxLayout.Direction.BottomToTop);
        QBoxLayout layout = new QBoxLayout(QBoxLayout.Direction.LeftToRight);
        layout1.addWidget(this);
        layout1.addStretch();
        layout.addLayout(layout1);
        layout.addStretch();
        return layout;
    }

}
