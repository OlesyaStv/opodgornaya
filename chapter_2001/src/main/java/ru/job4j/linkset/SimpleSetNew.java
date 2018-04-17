package ru.job4j.linkset;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
        int expectedModCount = linkList.getModCount();
        return new Iterator<E>() {
            @Override
            public boolean hasNext() throws ConcurrentModificationException {
                if (expectedModCount != linkList.getModCount()) {
                    throw new ConcurrentModificationException();
                }
                return linkList.iterator().hasNext();
            }
            @Override
            public E next()  throws ConcurrentModificationException {
                if (expectedModCount != linkList.getModCount()) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) linkList.iterator().next();
            }
        };
    }

    public SimpleSetNew() {
        linkList = new LinkList();
    }
}
