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
        int deltaX = dest.x > source.x ? 1 : -1;
        int deltaY = dest.y > source.y ? 1 : -1;
        int x = source.x + deltaX;
        int y = source.y + deltaY;
        for (int index = 0; index < size; index++) {
                steps[index] = Cell.findBy(x, y);
                x += deltaX;
                y += deltaY;
            }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean checkDiagonal = false;
        if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            checkDiagonal = true;
        }
        return checkDiagonal;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
