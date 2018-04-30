package ru.job4j.exchange;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;

public class SystemTest {
    private System system = new System();

    @Test
    public void whenAddRequsetComeAndSort() {
        Integer book = 1;
        Request request1 = new Request(1, book, "ADD",  "BID", 11.0, 10);
        Request request3 = new Request(3, book, "ADD",  "BID", 1.0, 2);
        Request request5 = new Request(3, book, "ADD",  "BID", 100.0, 2);
        Request request2 = new Request(2, book, "ADD",  "ASK", 10.0, 9);
        Request request4 = new Request(4, book, "ADD",  "ASK", 100.0, 1);
        system.requestCome(request1);
        system.requestCome(request2);
        system.requestCome(request3);
        system.requestCome(request4);
        system.requestCome(request5);
        Glass findGlass = system.getGlass(book.hashCode());
        LinkedList<Request> bidLinkedList =  findGlass.getBidLinkedList();
        Assert.assertThat(bidLinkedList.get(0).getPrice(), is(100.0));
    }

    @Test
    public void whenDeleteRequsetCome() {
        Integer book = 1;
        Request request1 = new Request(1, book, "ADD",  "BID", 11.0, 10);
        Request request2 = new Request(2, book, "ADD",  "ASK", 10.0, 9);
        Request request3 = new Request(3, book, "ADD",  "BID", 1.0, 2);
        Request request4 = new Request(4, book, "ADD",  "ASK", 100.0, 1);
        Request request5 = new Request(3, book, "ADD",  "BID", 100.0, 2);
        system.requestCome(request1);
        system.requestCome(request2);
        system.requestCome(request3);
        system.requestCome(request4);
        system.requestCome(request5);
        Request delRequest = new Request(1, book, "DELETE",  "BID", 11.0, 10);
        system.requestCome(delRequest);
        Glass findGlass = system.getGlass(book.hashCode());
        LinkedList<Request> bidLinkedList =  findGlass.getBidLinkedList();
        Assert.assertThat(bidLinkedList.get(1), is(request3));
    }

    @Test
    public void whenCombine() {
        Integer book = 1;
        Request request1 = new Request(1, book, "ADD",  "BID", 11.0, 10);
        Request request3 = new Request(3, book, "ADD",  "BID", 1.0, 2);
        Request request5 = new Request(3, book, "ADD",  "BID", 100.0, 2);
        Request request2 = new Request(2, book, "ADD",  "ASK", 10.0, 9);
        Request request4 = new Request(4, book, "ADD",  "ASK", 100.0, 1);
        system.requestCome(request1);
        system.requestCome(request2);
        system.requestCome(request3);
        system.requestCome(request4);
        system.requestCome(request5);
        system.combine();
        Glass findGlass = system.getGlass(book.hashCode());
        LinkedList<Request> bidLinkedList =  findGlass.getBidLinkedList();
        Assert.assertThat(bidLinkedList.get(0).getPrice(), is(11.0));

    }

    @Test
    public void whenAddRequsetComeAndPrint() {
        Integer book = 1;
        Request request1 = new Request(1, book, "ADD",  "BID", 11.0, 10);
        Request request3 = new Request(3, book, "ADD",  "BID", 11.0, 2);
        Request request5 = new Request(3, book, "ADD",  "BID", 100.0, 2);
        Request request2 = new Request(2, book, "ADD",  "ASK", 11.0, 9);
        Request request4 = new Request(4, book, "ADD",  "ASK", 100.0, 1);
        system.requestCome(request1);
        system.requestCome(request2);
        system.requestCome(request3);
        system.requestCome(request4);
        system.requestCome(request5);
        system.print();
        Glass findGlass = system.getGlass(book.hashCode());
        Assert.assertThat(findGlass.getPrintListSize(), is(2));
    }
}
