package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TeacherTest {

    @Test
    public void whenTeacherTeach() {
        Teacher teacher = new Teacher("Иван", "Иванов", "Диплом педагогического вуза №78873", "геометрия", 35);
        Student student = new Student("Федоренко", "МГУ", "Математический", "Первый");
        String expect = "Иван Иванов учит Федоренко факультет -  Математический";
        String result = teacher.teach(student);
        assertThat(result, is(expect));
    }
}
