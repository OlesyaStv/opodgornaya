package ru.job4j.game;

import ru.job4j.game.Archer;
import ru.job4j.game.Character;
import ru.job4j.game.Human;

import java.util.StringJoiner;

public class UndeadArcher extends Character implements Undead, Archer {

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.HERO);
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public void way(Character character, Character theSameRaceCharacter) {
        if (coin() == 0) {
            attack(character);
        } else {
            archery(character);
        }
    }

    public void attack(Character character) {
        this.reduceLivingLevel(2, character);
    }

    public void archery(Character character) {
        character.reduceLivingLevel(4, character);
    }


}
