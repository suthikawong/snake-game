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
    private Snake snake;
    private boolean play = false;
    private Timer timer;
    private final int delay = 150;


    public Gameplay() {
        setBackground(backgroundColor);
        addKeyListener(this);
        setFocusable(true);
        snake = new Snake();
        timer = new Timer(delay, this);
        timer.start();
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

        // draw snake
        snake.setMaxSize(boardData.gridRowColumn);
        snake.draw(g, boardData.gridSize, boardData.gridOffsetX, boardData.gridOffsetY);
        play = snake.move();

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (play) {
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            play = snake.changeDirection(Snake.Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            play = snake.changeDirection(Snake.Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            play = snake.changeDirection(Snake.Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            play = snake.changeDirection(Snake.Direction.DOWN);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
