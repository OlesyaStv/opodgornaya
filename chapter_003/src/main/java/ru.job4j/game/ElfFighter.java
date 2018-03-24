package ru.job4j.game;

public class ElfFighter extends Character implements Elf, Fighter {

    public void attack(Character character){
        character.reduceLivingLevel(15, this);
    }

}
