package ru.job4j.game;


import java.util.LinkedList;
import java.util.List;


public class Detachment {

    private List<Character> characters = new LinkedList<>();

    private String Race;
    private int KolWixard = 1;
    private int KolArcher = 3;
    private int KolFighter = 4;


    public Detachment(String Race){
        if (Race.equals("Elf")) {
            for (int j = 0; j < KolWixard; j++) {
                characters.add(new ElfWizard());
            }
            for (int i = 0; i < KolArcher; i++) {
                characters.add(new ElfArcher());
            }
            for (int i = 0; i < KolFighter; i++) {
                characters.add(new ElfFighter());
            }
        } else if (Race.equals("Human")) {
            for (int j = 0; j < KolWixard; j++) {
                characters.add(new HumanWizard());
            }
            for (int i = 0; i < KolArcher; i++) {
                characters.add(new HumanArcher());
            }
            for (int i = 0; i < KolFighter; i++) {
                characters.add(new HumanFighter());
            }
        }
    }

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
}
