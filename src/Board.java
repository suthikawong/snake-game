import java.awt.*;

public class Board {
    private final int gridRowColumnSize;
    private final Color gridColor = Color.GRAY;
    public int boardSize;
    public int gridSize;
    public int gridOffsetX;
    public int gridOffsetY;


    public Board(int panelWidth, int panelHeight, int borderSize, int gridRowColumnSize) {
        this.gridRowColumnSize = gridRowColumnSize;
        boardSize = Math.min(panelWidth, panelHeight) - borderSize * 2;
        gridSize = boardSize / gridRowColumnSize;
        gridOffsetX = (panelWidth - gridRowColumnSize * gridSize) / 2;
        gridOffsetY = (panelHeight - gridRowColumnSize * gridSize) / 2;
    }

    public void draw(Graphics g) {
        g.setColor(gridColor);
        for (int i = 0; i <= gridRowColumnSize; i++) {
            int yPos = gridOffsetY + i * gridSize;
            g.drawLine(gridOffsetX, yPos, gridOffsetX + boardSize - 1, yPos);
        }

        for (int j = 0; j <= gridRowColumnSize; j++) {
            int xPos = gridOffsetX + j * gridSize;
            g.drawLine(xPos, gridOffsetY, xPos, gridOffsetY + boardSize - 1);
        }
    }
}
