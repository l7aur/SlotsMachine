package UI_thingies;

import io.qt.core.QSize;
import io.qt.core.Qt;
import io.qt.gui.QPixmap;
import io.qt.widgets.*;

import java.util.Objects;

public class WheelUI extends QGraphicsView {
    //create 2 constants for easier maintanance of the image sizes and position in the window
    static final Integer width = 200;
    static final Integer height = 175;
    //create the game grid as a 3x3 matrix of images
    private final QPixmap[][] displayedGrid;

    public WheelUI(QGraphicsScene slotScene){
        super(slotScene);
        //initialize the game grid and the image postion vectors
        displayedGrid = new QPixmap[3][3];
        double[] posX = {0, width, 2 * width};
        double[] posY = {0, height, 2 * height};

        //initialize each item in the matrix with a picture contained at string
        for (int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                //convert the image to a qt object and resize it so that all images have the same resolution
                this.setDisplayedGrid(i, j, new QPixmap(("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\campari.png"))
                        .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
                //convert the pixmap to an item so that I can add it to the scene (and display it)
                QGraphicsPixmapItem item = new QGraphicsPixmapItem(this.getDisplayedGrid(i, j));
                //set the position of each image based on the position vectors
                item.setPos(posX[j], posY[i]);
                //add the item to the scene
                Objects.requireNonNull(this.scene()).addItem(item);
            }
    }

    public QPixmap getDisplayedGrid(int i, int j) {
        return displayedGrid[i][j];
    }

    public void setDisplayedGrid(int i, int j, QPixmap displayedGrid11) {
        this.displayedGrid[i][j] = displayedGrid11;
    }
}
