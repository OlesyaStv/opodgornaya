package ru.job4j.game;

import java.util.StringJoiner;

public class HumanWizard extends Character implements Human, Wizard {

    public void attack(Character character){
        character.reduceLivingLevel(4, this);
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
