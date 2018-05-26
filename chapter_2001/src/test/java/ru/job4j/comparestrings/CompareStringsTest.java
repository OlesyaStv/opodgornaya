package ru.job4j.comparestrings;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompareStringsTest {

    @Test
    public void whenTheSame() {
        CompareStrings compareStrings = new CompareStrings("vava", "avav");
        assertThat(compareStrings.getIdentical(), is(true));
    }

    @Test
    public void whenDifferent() {
        CompareStrings compareStrings = new CompareStrings("vava", "avvv");
        assertThat(compareStrings.getIdentical(), is(false));
    }
}
