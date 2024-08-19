import java.awt.*;
import java.util.LinkedList;

public class Snake {
    public LinkedList<Position> snakePositions = new LinkedList<>();
    private Direction direction = Direction.RIGHT;
    private final int gridRowColumnSize;
    private int gridSize;
    private int gridOffsetX;
    private int gridOffsetY;

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    public Snake(int gridRowColumnSize, int gridSize, int gridOffsetX, int gridOffsetY) {
        this.gridRowColumnSize = gridRowColumnSize;
        this.gridSize = gridSize;
        this.gridOffsetX = gridOffsetX;
        this.gridOffsetY = gridOffsetY;
        reset();
    }

    public void reset() {
        snakePositions = new LinkedList<>();
        snakePositions.add(new Position(4, 7));
        snakePositions.add(new Position(4, 6));
        snakePositions.add(new Position(4, 5));
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

    public void draw(Graphics g) {
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
        if (head.column == gridRowColumnSize - 1) {
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
        if (head.row == gridRowColumnSize - 1) {
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
