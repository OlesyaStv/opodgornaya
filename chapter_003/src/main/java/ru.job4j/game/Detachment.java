package ru.job4j.game;


import ru.job4j.game.Character;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public abstract class Detachment {

    protected List<Character> characters = new LinkedList<>();

    protected static String Race;
    protected int KolWixard = 1;
    protected int KolArcher = 3;
    protected int KolFighter = 4;


    public int countAlivePersons(){
       int count = 0;
       for(Character character: characters){
           if (character.getAlive()){
               count++;
           }
       }
       return  count;
    }

    public boolean allDied(){
        boolean allDied = false;
        if(countAlivePersons() == 0) {
            allDied = true;
        };
        return allDied;
    }

    public static String getRace() {
        return Race;
    }

    public List<Character> getVipPersons(){
        List<Character> vipCharacters = new LinkedList<>();
        ListIterator<Character> listite = characters.listIterator();
        while (listite.hasNext()){
            Character nextPerson = listite.next();
            if (nextPerson.getAlive() && nextPerson.getVipStatus()){
                vipCharacters.add(nextPerson);
            }
        }
        return vipCharacters;
    }

    public List<Character> getAlivePersons(){
        List<Character> aliveCharacters = new LinkedList<>();
        ListIterator<Character> listite = characters.listIterator();
        while (listite.hasNext()){
            Character nextPerson = listite.next();
            if (nextPerson.getAlive() ){
                aliveCharacters.add(nextPerson);
            }
        }
        return aliveCharacters;
    }

    public Character getAnotherAlivePerson(Character character){
        Character anotherAlivePerson = null;
        List<Character> aliveCharacters = getAlivePersons();
        ListIterator<Character> listite = characters.listIterator();
        while (listite.hasNext()){
            Character nextPerson = listite.next();
            if (!nextPerson.equals(character)){
                anotherAlivePerson = nextPerson;
            }
        }
        return anotherAlivePerson;
    }

    public Character getRandomPerson(){
        return getAlivePersons().get((int) (Math.random() * (getAlivePersons().size() - 1)));
    }

    public Character getAttackPerson(){
        List<Character> listForChoice = new LinkedList<>();
        List<Character> vipCharacters = getVipPersons();
        if (vipCharacters.size() > 0){
            listForChoice = vipCharacters;
        } else {
            List<Character> aliveCharacters = getAlivePersons();
            if (aliveCharacters.size() > 0){
                listForChoice =  aliveCharacters;
            }
        }
       return listForChoice.get((int) (Math.random() * (listForChoice.size() - 1)));
    }
}
