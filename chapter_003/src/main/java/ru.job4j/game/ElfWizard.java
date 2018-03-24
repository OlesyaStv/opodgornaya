package ru.job4j.game;

import java.util.StringJoiner;

public class ElfWizard extends Character implements Elf, Wizard {


    public void attack(Character character){
        character.reduceLivingLevel(10, this);
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
