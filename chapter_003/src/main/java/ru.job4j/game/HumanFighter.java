package ru.job4j.game;

import ru.job4j.game.Character;
import ru.job4j.game.Fighter;
import ru.job4j.game.Human;

import java.util.StringJoiner;

public class HumanFighter extends Character implements Human, Fighter {

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.HERO);
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public void attack(Character character) {
        this.reduceLivingLevel(18, character);
    }

}
