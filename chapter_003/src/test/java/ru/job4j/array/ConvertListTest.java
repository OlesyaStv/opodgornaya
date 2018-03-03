package ru.job4j.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ConvertListTest {

    @Test
    public void fromArraYToList() {

        ConvertList cl = new ConvertList();
        int[][] array = new int[][]{{0, 1}, {1, 2}};
        List<Integer> list =  cl.toList(array);

        List<Integer> listSecond = new ArrayList<>();
        listSecond.add(0);
        listSecond.add(1);
        listSecond.add(1);
        listSecond.add(2);

        assertThat(listSecond.containsAll(list), is(true));

    }

    @Test
    public void whenConvert() {
        ConvertList cl = new ConvertList();
        int[][] array = new int[][]{{4, 7}, {1, 2}};
        List<Integer> list =  cl.toList(array);
        int[][] massive = cl.toArray(list, 3);
        int[][]  massiveShouldBe = {{4, 7}, {1, 2}, {0, 0}};
        assertThat(massive, is(massiveShouldBe));
    }

    @Test
    public void whenConvertSecond() {
        ConvertList cl = new ConvertList();
        int[][] array = new int[][]{{4, 7}};
        List<Integer> list =  cl.toList(array);
        int[][] massive = cl.toArray(list, 4);
        int[][]  massiveShouldBe = {{4}, {7}, {0}, {0}};
        assertThat(massive, is(massiveShouldBe));
    }

    @Test
    public void whenConvertThird() {
        ConvertList cl = new ConvertList();
        int[][] array = new int[][]{{4}};
        List<Integer> list =  cl.toList(array);
        int[][] massive = cl.toArray(list, 4);
        int[][]  massiveShouldBe = {{4}, {0}, {0}, {0}};
        assertThat(massive, is(massiveShouldBe));
    }

    @Test
    public void whenConvertFourth() {
        ConvertList cl = new ConvertList();
        int[][] array = new int[][]{{4}, {1}, {2}, {3}, {4}, {1}, {2}, {3}};
        List<Integer> list =  cl.toList(array);
        int[][] massive = cl.toArray(list, 3);
        int[][]  massiveShouldBe = {{4, 1, 2}, {3, 4, 1}, {2, 3, 0}};
        assertThat(massive, is(massiveShouldBe));
    }
}
