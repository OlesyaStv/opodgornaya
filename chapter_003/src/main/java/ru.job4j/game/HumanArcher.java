package ru.job4j.game;

import ru.job4j.game.Archer;
import ru.job4j.game.Character;
import ru.job4j.game.Human;

import java.util.StringJoiner;

public class HumanArcher extends Character implements Human, Archer {

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
        this.reduceLivingLevel(3, character);
    }

    public void archery(Character character) {
        character.reduceLivingLevel(5, character);
    }


}
