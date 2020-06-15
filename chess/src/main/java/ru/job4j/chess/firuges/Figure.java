package ru.job4j.chess.firuges;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default boolean checkPosition(Cell cell) {
        boolean result = false;
        if (this.position().equals(cell)) {
            result = true;
        }
        return result;
    }

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    Figure copy(Cell dest);
}
