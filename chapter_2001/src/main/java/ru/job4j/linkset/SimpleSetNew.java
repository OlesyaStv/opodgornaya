package ru.job4j.linkset;
import java.util.Iterator;

public class SimpleSetNew<E>  implements Iterable<E> {

    private LinkList linkList;

    public int size() {
        return linkList.size();
    }

    public void  add(E e) {
        if (!linkList.contains(e)) {
           linkList.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return linkList.iterator();
    }

    public SimpleSetNew() {
        linkList = new LinkList();
    }
}
