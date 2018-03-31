package ru.job4j.coffeeMachine;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeMachineTest {

    @Test
    public void whenChangesF() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] changes = machine.changes(50, 34);
        int[] shouldBe = {10, 5, 1};
        assertThat(changes, is(shouldBe));
    }

    @Test
    public void whenChangesS() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] changes = machine.changes(50, 60);
        int[] shouldBe = {};
        assertThat(changes, is(shouldBe));
    }

    @Test
    public void whenChangesT() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] changes = machine.changes(50, 11);
        int[] shouldBe = {10, 10, 10, 5, 2, 2};
        assertThat(changes, is(shouldBe));
    }
}
