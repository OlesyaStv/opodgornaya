package ru.job4j.chess;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopTest {

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
    public void whenWayOk() {
        Board b = new Board();
        Bishop bishop = new Bishop(new Cell(1, 0));
        Bishop bishop2 = new Bishop(new Cell(3, 2));
        b.add(bishop);
        b.add(bishop2);
        b.move(new Cell(1, 0), new Cell(2, 2));
        assertThat(b.getPosition(), is(3));
    }

    @Test
    public void whenWayWrong() {
        Board b = new Board();
        Bishop bishop = new Bishop(new Cell(1, 0));
        Bishop bishop2 = new Bishop(new Cell(3, 2));
        b.add(bishop);
        b.add(bishop2);
        b.move(new Cell(1, 0), new Cell(4, 2));
        MatcherAssert.assertThat(
                this.mem.toString(),
                Matchers.is(
                        String.format("Imposible move exception!%n")
                )
        );
    }

}
