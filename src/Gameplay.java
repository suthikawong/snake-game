import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private Color borderColor;
    private int borderSize;

    // board
    private Color backgroundColor;
    private int boardSize;
    private int gridRowColumn;
    private int gridSize;
    private int gridThickness;
    private Color gridColor;

    public Gameplay() {
        backgroundColor = new Color(40, 40, 40);
        borderColor = Color.BLACK;
        borderSize = 10;
        gridRowColumn = 20;
        gridThickness = 2;
        gridColor = Color.GRAY;

        // board
        setBackground(backgroundColor);
//        setBorder(BorderFactory.createLineBorder(borderColor, borderSize));


    }

    @Override
    public void paint(Graphics g) {
        // draw board
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        boardSize = Math.min(panelWidth, panelHeight) - borderSize * 2;
        gridSize = boardSize / gridRowColumn;

        int gridOffsetX = (panelWidth - gridRowColumn * gridSize) / 2;
        int gridOffsetY = (panelHeight - gridRowColumn * gridSize) / 2;

        g.setColor(gridColor);
        for (int i = 0; i <= gridRowColumn; i++) {
            int yPos = gridOffsetY + i * gridSize;
            g.drawLine(gridOffsetX, yPos, gridOffsetX + boardSize - 1, yPos);
        }

        for (int j = 0; j <= gridRowColumn; j++) {
            int xPos = gridOffsetX + j * gridSize;
            g.drawLine(xPos, gridOffsetY, xPos, gridOffsetY + boardSize - 1);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
