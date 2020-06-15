package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionIsB3() {
        Cell position = Cell.B3;
        BishopBlack bishopBlack = new BishopBlack(position);
        Cell getPosition = bishopBlack.position();
        Cell expected = position;
        assertThat(getPosition, is(expected));
    }

    @Test
    public void whenCopyToPositionE5() {
        Cell position = Cell.D4;
        BishopBlack bishopBlack = new BishopBlack(position);
        Cell newPosition = Cell.E5;
        Figure newBishopBlack = bishopBlack.copy(newPosition);
        Cell getPosition = newBishopBlack.position();
        Cell expected = newPosition;
        assertThat(getPosition, is(expected));
    }

    @Test
    public void whenWayFromC1ToG5() {
        Cell initialPosition = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(initialPosition);
        Cell endPosition = Cell.G5;
        Cell[] positionsOfWay = bishopBlack.way(initialPosition, endPosition);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(positionsOfWay, is(expected));
    }

    @Test
    public void whenWayFromG5ToC1() {
        Cell initialPosition = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(initialPosition);
        Cell endPosition = Cell.C1;
        Cell[] positionsOfWay = bishopBlack.way(initialPosition, endPosition);
        Cell[] expected = new Cell[] {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(positionsOfWay, is(expected));
    }

    @Test
    public void whenWayFromC5ToG1() {
        Cell initialPosition = Cell.C5;
        BishopBlack bishopBlack = new BishopBlack(initialPosition);
        Cell endPosition = Cell.G1;
        Cell[] positionsOfWay = bishopBlack.way(initialPosition, endPosition);
        Cell[] expected = new Cell[] {Cell.D4, Cell.E3, Cell.F2, Cell.G1};
        assertThat(positionsOfWay, is(expected));
    }

    @Test
    public void whenFromG1ToC5() {
        Cell initialPosition = Cell.G1;
        BishopBlack bishopBlack = new BishopBlack(initialPosition);
        Cell endPosition = Cell.C5;
        Cell[] positionsOfWay = bishopBlack.way(initialPosition, endPosition);
        Cell[] expected = new Cell[] {Cell.F2, Cell.E3, Cell.D4, Cell.C5};
        assertThat(positionsOfWay, is(expected));
    }

    @Test
    public void isDiagonalTrue() {
        Cell firstPosition = Cell.G1;
        Cell secondPosition = Cell.C5;
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        boolean result = bishopBlack.isDiagonal(firstPosition, secondPosition);
        assertThat(result, is(true));
    }

    @Test (expected = IllegalStateException.class)
    public void whenNotDiagonal() {
        Cell startPosition = Cell.C1;
        Cell finishPosition = Cell.C5;
        BishopBlack bishopBlack = new BishopBlack(startPosition);
        bishopBlack.way(startPosition, finishPosition);
    }

}