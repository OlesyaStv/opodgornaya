package ru.job4j.game;

import javafx.beans.binding.When;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class War {

    public static final Random RANDOM = new Random();
    public Detachment oneSide;
    public Detachment secondSide;
    public Detachment winner;

    public int coin() {
        return RANDOM.nextInt(2);
    }

    public void fight() {
        do {
            if (coin() == 1) {
                Character attackPersonFirst = oneSide.getAttackPerson();
                Character personForFight = secondSide.getRandomPerson();
                attackPersonFirst.way(personForFight, oneSide.getAnotherAlivePerson(attackPersonFirst));
            } else {
                Character attackPersonFirst = secondSide.getAttackPerson();
                Character personForFight = oneSide.getRandomPerson();
                attackPersonFirst.way(personForFight, secondSide.getAnotherAlivePerson(attackPersonFirst));
            }
        } while ((oneSide.countAlivePersons() > 0 && secondSide.countAlivePersons() > 0));

        if (oneSide.allDied()) {
            winner = secondSide;
        } else {
            winner = oneSide;
        }
        if (winner != null) {
            StringJoiner stringJoiner = new StringJoiner(" ");
            stringJoiner.add(winner.toString());
            stringJoiner.add("Winner!!!!!!!!!!!!! ");
            System.out.println(stringJoiner.toString());
        }
    }

    public War() {
        if (coin() == 1) {
            oneSide = new ElfDetachment();
        } else {
            oneSide = new HumanDetachment();
        }
        if (coin() == 1) {
            secondSide = new OrcsDetachment();
        } else {
            secondSide = new UndeadDetachment();
        }
        fight();
    }

    public static void main(String[] args) {
        War war1 = new War();
    }
}
