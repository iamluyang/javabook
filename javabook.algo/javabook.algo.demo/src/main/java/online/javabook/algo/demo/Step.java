package online.javabook.algo.demo;

import java.util.Arrays;
import java.util.Objects;

public class Step {

    private char[][] board;
    private int x;
    private int y;

    public Step(char[][] board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return x == step.x && y == step.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return board[getX()][getY()] +"";
    }
}
