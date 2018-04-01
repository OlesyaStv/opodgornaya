package ru.job4j.game;

import ru.job4j.game.Character;
import ru.job4j.game.Elf;
import ru.job4j.game.Fighter;

import java.util.StringJoiner;

public class ElfFighter extends Character implements Elf, Fighter {

    public void attack(Character character){
        this.reduceLivingLevel(15, character);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner= new StringJoiner("/");
        stringJoiner.add(this.Hero);
        stringJoiner.add(this.Raca);
        return stringJoiner.toString();
    }

}
