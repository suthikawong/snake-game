import java.awt.*;
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

    public boolean changeDirection(Direction dir) {
        if (dir == Direction.LEFT) {
            return moveLeft(dir);
        } else if (dir == Direction.RIGHT) {
            return moveRight(dir);
        } else if (dir == Direction.UP) {
            return moveUp(dir);
        } else if (dir == Direction.DOWN) {
            return moveDown(dir);
        }
        return false;
    }

    private static class Position {
        public int row;
        public int column;
        public Position(int row,int column) {
            this.row = row;
            this.column = column;
        }
    }

    public boolean move() {
        if (direction == Direction.LEFT) {
            return moveLeft(direction);
        } else if (direction == Direction.RIGHT) {
            return moveRight(direction);
        } else if (direction == Direction.UP) {
            return moveUp(direction);
        } else if (direction == Direction.DOWN) {
            return moveDown(direction);
        }
        return false;
    }

    public void draw(Graphics g, int gridSize, int gridOffsetX, int gridOffsetY) {
        g.setColor(Color.RED);
        for (Position pos: snakePositions) {
            int x = gridOffsetX + (gridSize * pos.column) + 1;
            int y = gridOffsetY + (gridSize * pos.row) + 1;
            g.fillRect(x, y, gridSize - 1, gridSize - 1);
        }
    }

    private boolean moveLeft(Direction dir) {
        Position head = snakePositions.getFirst();
        if (head.column == 0) {
            return false;
        }
        if (direction == Direction.RIGHT) {
            return true;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row, head.column - 1));
        snakePositions.removeLast();
        return true;
    }

    private boolean moveRight(Direction dir) {
        Position head = snakePositions.getFirst();
        if (head.column == maxSize - 1) {
            return false;
        }
        if (direction == Direction.LEFT) {
            return true;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row, head.column + 1));
        snakePositions.removeLast();
        return true;
    }

    private boolean moveUp(Direction dir) {
        Position head = snakePositions.getFirst();
        if (direction == Direction.DOWN) {
            return false;
        }
        if (head.row == 0) {
            return true;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row - 1, head.column));
        snakePositions.removeLast();
        return true;
    }

    private boolean moveDown(Direction dir) {
        Position head = snakePositions.getFirst();
        if (head.row == maxSize - 1) {
            return false;
        }
        if (direction == Direction.UP) {
            return true;
        }
        direction = dir;
        snakePositions.addFirst(new Position(head.row + 1, head.column));
        snakePositions.removeLast();
        return true;
    }


}
