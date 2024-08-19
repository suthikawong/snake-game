import java.awt.*;
import java.util.Random;

public class Food {
    private int gridSize;
    private int gridOffsetX;
    private int gridOffsetY;
    public final Position foodPosition;

    public Food(Position position, int gridSize, int gridOffsetX, int gridOffsetY) {
        foodPosition = position;
        this.gridSize = gridSize;
        this.gridOffsetX = gridOffsetX;
        this.gridOffsetY = gridOffsetY;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        int x = gridOffsetX + (gridSize * foodPosition.column) + 1;
        int y = gridOffsetY + (gridSize * foodPosition.row) + 1;
        g.fillRect(x, y, gridSize - 1, gridSize - 1);
    }

}
