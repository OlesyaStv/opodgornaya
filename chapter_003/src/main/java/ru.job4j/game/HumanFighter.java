package ru.job4j.game;

public class HumanFighter extends Character implements Human, Fighter {

    public void attack(Character character){
        character.reduceLivingLevel(18, this);
    }

}
