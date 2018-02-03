package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DoctotTest {

    @Test
    public void whenDoctorTreat() {
        Doctor doctor = new Doctor("Иван", "Иванов", "Диплом мед. вуза №173", "Диссертация №1", 30);
        SickPerson sickPerson = new SickPerson("Габко", "№1781aa", 38);
        String expect = "Иван Иванов лечит Габко полис -  №1781aa температура 38";
        String result = doctor.treat(sickPerson);
        assertThat(result, is(expect));
    }
}
