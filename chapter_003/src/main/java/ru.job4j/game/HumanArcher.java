package ru.job4j.game;

import java.util.StringJoiner;

public class HumanArcher extends Character implements Human, Archer {


    public void attack(Character character){
        character.reduceLivingLevel(3, this);
    }

    public void archery(Character character){
        character.reduceLivingLevel(5, this);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner= new StringJoiner("/");
        stringJoiner.add(this.Hero);
        stringJoiner.add(this.Raca);
        return stringJoiner.toString();
    }
}
