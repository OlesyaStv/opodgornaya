package ru.job4j.game;

import ru.job4j.game.Character;
import ru.job4j.game.Elf;
import ru.job4j.game.Wizard;

import java.util.StringJoiner;

public class ElfWizard extends Character implements Elf, Wizard {

    public void way(Character character,  Character theSameRaceCharacter) {
        if(coin() == 0){
            attack(character);
        } else {
            if (theSameRaceCharacter == null){
                attack(character);
            } else {
                improve(theSameRaceCharacter);
            }
        }
    }

    public void attack(Character character){
        this.reduceLivingLevel(10, character);
    }

    public void improve(Character character){
        character.setVipStatus(true);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner= new StringJoiner("/");
        stringJoiner.add(this.Hero);
        stringJoiner.add(this.Raca);
        return stringJoiner.toString();
    }
}
