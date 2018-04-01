package ru.job4j.game;

import ru.job4j.game.Character;
import ru.job4j.game.Human;
import ru.job4j.game.Wizard;

import java.util.StringJoiner;

public class HumanWizard extends Character implements Human, Wizard {

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
        this.reduceLivingLevel(4, character);
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
