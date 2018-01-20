package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Olesya Podgornaya
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
    /**
     * Test echo.
     */ @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Olesya Podgornaya";
        String expect = "Echo, echo, echo : Olesya Podgornaya";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }

}
