package ru.job4j.calculator;

import org.junit.Test;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtractTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivSixDivadeTwoThenThree() {
        Calculator calc = new Calculator();
        calc.div(6D, 0D);
        double result = calc.getResult();
        assertThat(result, is(POSITIVE_INFINITY));
    }

    @Test
    public void whenMultipleSixMultiplyTwoThenTwelve() {
        Calculator calc = new Calculator();
        calc.multiple(6D, 2D);
        double result = calc.getResult();
        double expected = 12D;
        assertThat(result, is(expected));
    }
}
