package ru.job4j.game;

import ru.job4j.game.Archer;
import ru.job4j.game.Character;
import ru.job4j.game.Elf;

import java.util.StringJoiner;

public class OrcsArcher extends Character implements Orcs, Archer {

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.HERO);
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public void attack(Character character) {
        this.reduceLivingLevel(2, character);
    }

    public void archery(Character character) {
        character.reduceLivingLevel(3, character);
    }


}
