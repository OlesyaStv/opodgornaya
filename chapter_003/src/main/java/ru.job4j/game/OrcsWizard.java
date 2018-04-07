package ru.job4j.game;

import ru.job4j.game.Character;
import ru.job4j.game.Elf;
import ru.job4j.game.Wizard;

import java.util.StringJoiner;

public class OrcsWizard extends Character implements Orcs, Wizard {

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.HERO);
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public void way(Character character,  Character theSameRaceCharacter) {
        if (coin() == 0) {
            attack(character);
        } else {
            if (theSameRaceCharacter == null) {
                attack(character);
            } else {
                improve(theSameRaceCharacter);
            }
        }
    }

    public void attack(Character character) {
        character.setVipStatus(false);
    }

    public void improve(Character character) {
        character.setVipStatus(true);
    }

}
