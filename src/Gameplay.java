import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    // board
    public final static int gridRowColumnSize = 20;
    private final Color backgroundColor = new Color(40, 40, 40);
    private final int borderSize = 10;
    private Board board;
    private Snake snake;
    private Food food;
    private boolean play = false;
    private Timer timer;
    private final int delay = 150;
    private int score = 0;


    public Gameplay() {
        setBackground(backgroundColor);
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        // draw board
        super.paintComponent(g);
        if (board == null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            board = new Board(panelWidth, panelHeight, borderSize, gridRowColumnSize);
            snake = new Snake(gridRowColumnSize, board.gridSize, board.gridOffsetX, board.gridOffsetY);
            food = new Food(randomPosition(), board.gridSize, board.gridOffsetX, board.gridOffsetY);
        }
        board.draw(g);

        // draw snake
        snake.draw(g);
        if (play) {
            play = snake.move();
        }

        // draw food
        food.draw(g);

        if (!play) {
            g.setColor(Color.WHITE);
            Position head = snake.snakePositions.getFirst();
            if (score == 0 && head.row == 4 && head.column == 7) {
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("Press Space Bar to Start", 150, 300);
            } else {
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("Game Over, Scores:" + score, 165, 275);

                g.setFont(new Font("serif", Font.BOLD, 20));
                g.drawString("Press Space Bar to Restart", 185, 325);
            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (play) {
            boolean isEatenSelf = checkIsEatenSelf();
            if (isEatenSelf) {
                play = false;
            }
            boolean isEatenFood = checkIsEatenFood();
            if (isEatenFood) {
                food = new Food(randomPosition(), board.gridSize, board.gridOffsetX, board.gridOffsetY);
                Position secondLast = snake.snakePositions.get(snake.snakePositions.size() - 2);
                Position last = snake.snakePositions.getLast();
                int xDir = last.column - secondLast.column;
                int yDir = last.row - secondLast.row;
                snake.snakePositions.addLast(new Position(last.row + yDir, last.column + xDir));
                score += 1;
            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (play) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                play = snake.changeDirection(Snake.Direction.LEFT);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                play = snake.changeDirection(Snake.Direction.RIGHT);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                play = snake.changeDirection(Snake.Direction.UP);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                play = snake.changeDirection(Snake.Direction.DOWN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            reset();
        }
    }

    public void reset() {
        play = true;
        score = 0;
        board = null;
    }

    public boolean checkIsEatenFood() {
        Position snakeHead = snake.snakePositions.getFirst();
        Position foodPos = food.foodPosition;
        return snakeHead.row == foodPos.row && snakeHead.column == foodPos.column;
    }

    public boolean checkIsEatenSelf() {
        Position head = snake.snakePositions.getFirst();
        for (int i = 0; i < snake.snakePositions.size(); i++) {
            if (i == 0) {
                continue;
            }
            Position curr = snake.snakePositions.get(i);
            if (curr.row == head.row && curr.column == head.column) {
                return true;
            }
        }
        return false;
    }

    public Position randomPosition() {
        Random random = new Random();
        int row = random.nextInt(gridRowColumnSize);
        int column = random.nextInt(gridRowColumnSize);
        return new Position(row, column);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
