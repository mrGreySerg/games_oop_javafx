package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenFigureOnWay() {
        Logic logic = new Logic();
        Cell firstPosition = Cell.C1;
        Cell secondPosition = Cell.E3;
        Cell positionOfAnotherFigure = Cell.D2;
        logic.add(new BishopBlack(firstPosition));
        logic.add(new PawnBlack(positionOfAnotherFigure));
        boolean result = logic.move(firstPosition, secondPosition);
        boolean expected = false;
        assertThat(result, is(expected));
    }

}