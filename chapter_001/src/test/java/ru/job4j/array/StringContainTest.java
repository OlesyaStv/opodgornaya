package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringContainTest {

    @Test
    public void whenContains() {
        StringContain stringContain = new StringContain();
        boolean rst = stringContain.contains("Привет", "иве");
        assertThat(rst, is(true));

    }

    @Test
    public void whenNoContains() {
        StringContain stringContain = new StringContain();
        boolean rst = stringContain.contains("Привет", "111");
        assertThat(rst, is(false));

    }

    @Test
    public void whenNoContainsLong() {
        StringContain stringContain = new StringContain();
        boolean rst = stringContain.contains("Привет", "ивее");
        assertThat(rst, is(false));

    }


    @Test
    public void whenContainsAndHaveRepeat() {
        StringContain stringContain = new StringContain();
        boolean rst = stringContain.contains("Приветив", "иве");
        assertThat(rst, is(true));

    }

    @Test
    public void whenContainsWhenSubLonger() {
        StringContain stringContain = new StringContain();
        boolean rst = stringContain.contains("Привет", "ПриветМир");
        assertThat(rst, is(false));

    }
}
