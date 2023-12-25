package UI_thingies;

import backendish.Wheel;
import io.qt.core.QSize;
import io.qt.core.Qt;
import io.qt.gui.QPixmap;
import io.qt.widgets.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WheelUI extends QGraphicsView {
    //parametrisation
    private static final Integer width = 200;
    private static final Integer height = 175;
    private static final Integer dimension = 3;
    private static final ArrayList<Integer> posX = new ArrayList<>();
    private static final ArrayList<Integer> posY = new ArrayList<>();
    static {
            for(int i = 0; i < dimension; i++){
            posX.add(i * width);
            posY.add(i * height);
        }
    }
    private static final Map<Integer, QPixmap> numberToPic = new HashMap<>();
    static {
        //Initializing the static map within a static block
        numberToPic.put(0, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\beer.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(1, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\campari.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(2, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\champagne.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(3, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\gin.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(4, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\jack.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(5, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\rum.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(6, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\strongbow.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(7, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\tuica.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(8, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\vodka.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(9, new QPixmap("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\wine.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
    }
    //create the game grid as a dimension x dimension matrix of images
    private QPixmap[][] displayedGrid;

    public WheelUI(QGraphicsScene slotScene, Wheel wheel){
        super(slotScene);
        //initialize the game grid and the image postion vectors
        displayedGrid = new QPixmap[dimension][dimension];
        //initialize each item in the matrix with a picture contained at string
        this.updateNewDisplayedGrid(wheel);
    }
    public void updateNewDisplayedGrid(Wheel wheel){
//        System.out.println("update: ");
//        for (int i = 0; i < 10; i++)
//            System.out.print(wheel.getLuckyNumbers().get(i) + " ");
//        System.out.println();
        for(int i = 0; i < dimension; i++)
            for(int j = 0; j < dimension; j++) {
                this.setDisplayedGrid(i,j, numberToPic.get(wheel.getLuckyNumbers().get(i * dimension + j)));
                QGraphicsPixmapItem item = new QGraphicsPixmapItem(this.getDisplayedGrid(i, j));
                //set the position of each image based on the position vectors
                item.setPos(posX.get(j), posY.get(i));
                //add the item to the scene
                Objects.requireNonNull(this.scene()).addItem(item);
            }
    }
    public void clearDisplayedGrid(){
        Objects.requireNonNull(this.scene()).clear();
    }
    private QPixmap getDisplayedGrid(int i, int j) {
        return displayedGrid[i][j];
    }

    private void setDisplayedGrid(int i, int j, QPixmap displayedGrid11) {
        this.displayedGrid[i][j] = displayedGrid11;
    }
}
