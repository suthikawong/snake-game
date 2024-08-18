import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Position> snakePositions = new LinkedList<>();
    private Direction direction = Direction.RIGHT;
    private int maxSize;

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    public Snake() {
        reset();
    }

    public void reset() {
        snakePositions = new LinkedList<>();
        snakePositions.add(new Position(4, 7));
        snakePositions.add(new Position(4, 6));
        snakePositions.add(new Position(4, 5));
    }

    public void setMaxSize(int size) {
        maxSize = size;
    }

    public void changeDirection(Direction dir) {
        if (dir == Direction.LEFT) {
            moveLeft(dir);
        } else if (dir == Direction.RIGHT) {
            moveRight(dir);
        } else if (dir == Direction.UP) {
            moveUp(dir);
        } else if (dir == Direction.DOWN) {
            moveDown(dir);
        }
    }

    private static class Position {
        public int row;
        public int column;
        public Position(int row,int column) {
            this.row = row;
            this.column = column;
        }
    }

    public void move() {
        if (direction == Direction.LEFT) {
            moveLeft(direction);
        } else if (direction == Direction.RIGHT) {
            moveRight(direction);
        } else if (direction == Direction.UP) {
            moveUp(direction);
        } else if (direction == Direction.DOWN) {
            moveDown(direction);
        }
    }

    public void draw(Graphics g, int gridSize, int gridOffsetX, int gridOffsetY) {
        g.setColor(Color.RED);
        for (Position pos: snakePositions) {
            int x = gridOffsetX + (gridSize * pos.column) + 1;
            int y = gridOffsetY + (gridSize * pos.row) + 1;
            g.fillRect(x, y, gridSize - 1, gridSize - 1);
        }
    }

    public void moveLeft(Direction dir) {
        Position head = snakePositions.getFirst();
        if (head.column == 0) {
            // Game Over
            return;
        }
        if (direction == Direction.RIGHT) {
            return;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row, head.column - 1));
        snakePositions.removeLast();
    }

    public void moveRight(Direction dir) {
        Position head = snakePositions.getFirst();
        if (head.column == maxSize - 1) {
            // Game Over
            return;
        }
        if (direction == Direction.LEFT) {
            return;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row, head.column + 1));
        snakePositions.removeLast();
    }

    public void moveUp(Direction dir) {
        Position head = snakePositions.getFirst();
        if (direction == Direction.DOWN) {
            return;
        }
        if (head.row == 0) {
            // Game Over
            return;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row - 1, head.column));
        snakePositions.removeLast();
    }

    public void moveDown(Direction dir) {
        Position head = snakePositions.getFirst();
        if (head.row == maxSize - 1) {
            // Game Over
            return;
        }
        if (direction == Direction.UP) {
            return;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row + 1, head.column));
        snakePositions.removeLast();
    }


}
