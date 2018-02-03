package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EngineerTest {

    @Test
    public void whenEngineerConstruct() {
        Engineer engineer = new Engineer("Николай", "Сидоров", "Диплом политеха №7878", 50);
        House house = new House(4, 16, "село Донское, улица Солнечная 14");
        String expect = "Николай Сидоров конструирует дом -село Донское, улица Солнечная 14 этажей - 4 , квартир - 16";
        String result = engineer.construct(house);
        assertThat(result, is(expect));
    }
}
