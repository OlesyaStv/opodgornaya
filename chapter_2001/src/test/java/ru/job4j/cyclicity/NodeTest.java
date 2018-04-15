package ru.job4j.cyclicity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeTest {

    @Test
    public void whenHasLoop() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenNoLoop() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(first.hasCycle(first), is(false));
    }

    @Test
    public void whenHasCycleHareTurtle() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(first.hasCycleHareTurtle(first), is(true));
    }

    @Test
    public void whenNoCycleHareTurtle() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(first.hasCycleHareTurtle(first), is(false));
    }
}
