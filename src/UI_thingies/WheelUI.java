package UI_thingies;

import io.qt.core.QSize;
import io.qt.core.Qt;
import io.qt.gui.QPixmap;
import io.qt.widgets.*;

import java.util.Objects;

public class WheelUI extends QGraphicsView {
    static final Integer width = 200;
    static final Integer height = 175;
    private final QPixmap[][] displayedGrid;

    public WheelUI(QGraphicsScene slotScene){
        super(slotScene);
        displayedGrid = new QPixmap[3][3];
        double[] posX = {0, width, 2 * width};
        double[] posY = {0, height, 2 * height};
        for (int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                this.setDisplayedGrid(i, j, new QPixmap(("C:\\Users\\L7aur\\IdeaProjects\\SlotsMachine\\src\\images\\bottles\\campari.png"))
                        .scaled(new QSize(width, height), Qt.AspectRatioMode.KeepAspectRatio, Qt.TransformationMode.SmoothTransformation));
                QGraphicsPixmapItem item = new QGraphicsPixmapItem(this.getDisplayedGrid(i, j));
                item.setPos(posX[j], posY[i]);
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
