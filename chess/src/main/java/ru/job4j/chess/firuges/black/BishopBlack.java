package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws IllegalStateException  {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s",
                            source, dest)
            );
        }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int[] deltaXY = check(source, dest);
        int deltaX = deltaXY[0];
        int deltaY = deltaXY[1];
        for (int index = 0; index < size; index++) {
                int x = source.x + deltaX;
                int y = source.y + deltaY;
                steps[index] = Cell.findBy(x, y);
                deltaX += deltaXY[0];
                deltaY += deltaXY[1];
            }
        return steps;
    }

    private int[] check(Cell source, Cell dest) {
        int[] deltaXY = new int[2];
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        boolean wayUpRight = deltaX < 0 && deltaY < 0 ? true : false;
        boolean wayDownLeft = deltaX > 0 && deltaY > 0 ? true : false;
        boolean wayDownRight = deltaX > 0 && deltaY < 0 ? true : false;
        boolean wayUpLeft = deltaX < 0 && deltaY > 0 ? true : false;
        if (wayUpRight) {
            deltaXY[0] = 1;
            deltaXY[1] = 1;
        } else if (wayDownLeft) {
            deltaXY[0] = -1;
            deltaXY[1] = -1;
        } else if (wayDownRight) {
            deltaXY[0] = -1;
            deltaXY[1] = 1;
        } else if (wayUpLeft) {
            deltaXY[0] = 1;
            deltaXY[1] = -1;
        }
        return deltaXY;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean checkDiagonal = false;
        if (source.x - dest.x == source.y - dest.y
                || Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)
                && source.x + source.y == dest.x + dest.y) {
            checkDiagonal = true;
        }
        return checkDiagonal;

    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
