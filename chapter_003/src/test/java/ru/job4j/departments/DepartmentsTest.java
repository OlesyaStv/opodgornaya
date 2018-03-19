package ru.job4j.departments;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {

    @Test
    public void whenSortAscending() {
        Departments  departmentList = new Departments();
        Department d1 = new Department("K1\\SK1");
        Department d2 = new Department("K1\\SK2");
        Department d3 = new Department("K1\\SK1\\SSK1");
        Department d4 = new Department("K1\\SK1\\SSK2");
        Department d5 = new Department("K2");
        Department d6 = new Department("K2\\SK1\\SSK1");
        Department d7 = new Department("K2\\SK1\\SSK2");
        departmentList.add(d1);
        departmentList.add(d2);
        departmentList.add(d3);
        departmentList.add(d4);
        departmentList.add(d5);
        departmentList.add(d6);
        departmentList.add(d7);
        departmentList.sortAscending();
        Iterator<Department> iterator = departmentList.getDepartmentList().iterator();
        assertThat(iterator.next().getKey(), is("K1"));
    }

    @Test
    public void whenSortDecreasingly() {
        Departments  departmentList = new Departments();
        Department d1 = new Department("K1\\SK1");
        Department d2 = new Department("K1\\SK2");
        Department d3 = new Department("K1\\SK1\\SSK1");
        Department d4 = new Department("K1\\SK1\\SSK2");
        Department d5 = new Department("K2");
        Department d6 = new Department("K2\\SK1\\SSK1");
        Department d7 = new Department("K2\\SK1\\SSK2");
        departmentList.add(d1);
        departmentList.add(d2);
        departmentList.add(d3);
        departmentList.add(d4);
        departmentList.add(d5);
        departmentList.add(d6);
        departmentList.add(d7);
        departmentList.sortDecreasingly();
        Iterator<Department> iterator = departmentList.getDepartmentList().iterator();
        assertThat(iterator.next().getKey(), is("K2"));
    }
}
