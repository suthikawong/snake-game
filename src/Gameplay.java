import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    // board
    private final Color backgroundColor = new Color(40, 40, 40);
    private int borderSize = 10;
    private Board board;

    public Gameplay() {
        setBackground(backgroundColor);
    }

    @Override
    public void paint(Graphics g) {
        // draw board
        super.paintComponent(g);
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        board = new Board(panelWidth, panelHeight, borderSize);
        board.draw(g);
        Board.BoardData boardData = board.getBoard();

        // snake
        g.setColor(Color.RED);
        g.fillRect(boardData.gridOffsetX + 1, boardData.gridOffsetY + 1, boardData.gridSize - 1, boardData.gridSize - 1);

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
