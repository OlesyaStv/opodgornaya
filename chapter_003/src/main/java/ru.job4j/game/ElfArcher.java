package ru.job4j.game;

import java.util.StringJoiner;

public class ElfArcher extends Character implements Elf, Archer {


    public void attack(Character character){
        character.reduceLivingLevel(3, this);
    }

    public void archery(Character character){
        character.reduceLivingLevel(7, this);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner= new StringJoiner("/");
        stringJoiner.add(this.Hero);
        stringJoiner.add(this.Raca);
        return stringJoiner.toString();
    }
}
