package ru.job4j.game;

import ru.job4j.game.Character;
import ru.job4j.game.Elf;
import ru.job4j.game.Wizard;

import java.util.StringJoiner;

public class UndeadWizard extends Character implements Undead, Wizard {

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
            setIllness(character);
        }
    }

    public void attack(Character character) {
        this.reduceLivingLevel(5, character);
    }

    public void setIllness(Character character) {
        character.setIllness(true);
    }


}
