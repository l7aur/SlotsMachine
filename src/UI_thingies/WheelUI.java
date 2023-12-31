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
    //position on OX axis in the display
    private static final ArrayList<Integer> posX = new ArrayList<>();
    //position on OY axis in the display
    private static final ArrayList<Integer> posY = new ArrayList<>();
    //map of integer values in backend to nice corresponding, suggestive and appealing pictures
    private static final Map<Integer, QPixmap> numberToPic = new HashMap<>();

    //create the game grid as a dimension x dimension matrix of images

    //ar fi bine sa nu fie final in caz ca voi face sa mearga in acelasi
    //widget si nu in widgeturi diferite (dau refactor in loc de apelari de
    // constructori)
    private QPixmap[][] displayedGrid;

    public WheelUI(QGraphicsScene slotScene, Wheel wheel){
        super(slotScene);
        for (int i = 0; i < dimension; i++) {
            posX.add(i * width);
            posY.add(i * height);
        }
        numberToPic.put(wheel.getTier1Number().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\tuica.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier2Number1().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\jack.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier2Number2().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\vodka.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier3Number1().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\gin.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier3Number2().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\rum.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier3Number3().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\campari.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier4Number1().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\champagne.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier4Number2().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\wine.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier4Number3().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\strongbow.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
        numberToPic.put(wheel.getTier4Number4().getUniqueIdentifier(), new QPixmap("src\\images\\bottles\\beer.png")
                .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));

        //initialize the game grid and the image postion vectors
        this.displayedGrid = new QPixmap[dimension][dimension];
        //initialize each item in the matrix with a picture contained at string
        this.updateNewDisplayedGrid(wheel);
    }
    public void updateNewDisplayedGrid(Wheel wheel){
        for(int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                this.setDisplayedGrid(i, j, numberToPic.get(wheel.getLuckyNumbers().get(i * dimension + j)));
                QGraphicsPixmapItem item = new QGraphicsPixmapItem(this.getDisplayedGrid(i, j));
                //set the position of each image based on the position vectors
                item.setPos(posX.get(j), posY.get(i));
                //add the item to the scene
                Objects.requireNonNull(this.scene()).addItem(item);
            }
        }
    }

    private QPixmap getDisplayedGrid(int i, int j) {
        return displayedGrid[i][j];
    }

    private void setDisplayedGrid(int i, int j, QPixmap displayedGrid11) {
        this.displayedGrid[i][j] = displayedGrid11;
    }
}
