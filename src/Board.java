import java.awt.*;

public class Board {
    private final int gridRowColumn = 20;
    private final Color gridColor = Color.GRAY;
    private int boardSize;
    private int gridSize;
    private int gridOffsetX;
    private int gridOffsetY;


    public Board(int panelWidth, int panelHeight, int borderSize) {
        boardSize = Math.min(panelWidth, panelHeight) - borderSize * 2;
        gridSize = boardSize / gridRowColumn;
        gridOffsetX = (panelWidth - gridRowColumn * gridSize) / 2;
        gridOffsetY = (panelHeight - gridRowColumn * gridSize) / 2;
    }

    static class BoardData {
        public final int gridRowColumn;
        public final int boardSize;
        public final int gridSize;
        public final int gridOffsetX;
        public final int gridOffsetY;

        public BoardData(int gridRowColumn, int boardSize, int gridSize, int gridOffsetX, int gridOffsetY) {
            this.gridRowColumn = gridRowColumn;
            this.boardSize = boardSize;
            this.gridSize = gridSize;
            this.gridOffsetX = gridOffsetX;
            this.gridOffsetY = gridOffsetY;
        }
    }

    public BoardData getBoard() {
        return new BoardData(gridRowColumn, boardSize, gridSize, gridOffsetX, gridOffsetY);
    }

    public void draw(Graphics g) {
        g.setColor(gridColor);
        for (int i = 0; i <= gridRowColumn; i++) {
            int yPos = gridOffsetY + i * gridSize;
            g.drawLine(gridOffsetX, yPos, gridOffsetX + boardSize - 1, yPos);
        }

        for (int j = 0; j <= gridRowColumn; j++) {
            int xPos = gridOffsetX + j * gridSize;
            g.drawLine(xPos, gridOffsetY, xPos, gridOffsetY + boardSize - 1);
        }
    }
}
