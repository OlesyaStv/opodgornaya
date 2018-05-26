package ru.job4j.search;

import java.util.LinkedList;
import java.util.Queue;

public class ParallelSearchTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(".txt");
        ParallelSearch parallelSearch = new ParallelSearch("C:\\projects\\filesSearch", "qqqq", list);
        parallelSearch.init();
        Queue result = parallelSearch.result();
        if (result.size() > 0) {
            System.out.println("The following files were found");
        } else {
            System.out.println("Didn't find anything!");
        }
        for (Object element : result) {
            System.out.println(element.toString());
        }
    }
}
