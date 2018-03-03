package ru.job4j.chess;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoardTest {

    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }


    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenFigureNotFound() {
        Board b = new Board();
        b.move(new Cell(1, 0), new Cell(2, 2));
        MatcherAssert.assertThat(
                this.mem.toString(),
                Matchers.is(
                        String.format("Figure not found exception!%n")
                )
        );
    }

    @Test
    public void whenImpossibleMove() {
        Board b = new Board();
        Bishop bishop = new Bishop(new Cell(1, 0));
        b.add(bishop);
        b.move(new Cell(1, 0), new Cell(10, 2));
        MatcherAssert.assertThat(
                this.mem.toString(),
                Matchers.is(
                        String.format("Imposible move exception!%n")
                )
        );
    }

    @Test
    public void whenOccupiedWayException() {
        Board b = new Board();
        Bishop bishop = new Bishop(new Cell(1, 0));
        Bishop bishop2 = new Bishop(new Cell(2, 2));
        b.add(bishop);
        b.add(bishop2);
        b.move(new Cell(1, 0), new Cell(2, 2));
        MatcherAssert.assertThat(
                this.mem.toString(),
                Matchers.is(
                        String.format("Imposible move exception!%n")
                )
        );
    }
}
