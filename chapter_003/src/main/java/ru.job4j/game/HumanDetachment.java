package ru.job4j.game;
import ru.job4j.game.ElfArcher;
import ru.job4j.game.ElfFighter;
import ru.job4j.game.ElfWizard;

import java.util.StringJoiner;


public class HumanDetachment extends Detachment {

    public static final String RACA = "Human";

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public HumanDetachment() {
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new HumanWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new HumanArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new HumanFighter());
        }
    }

    public HumanDetachment(int kolWixard, int kolArcher, int kolFighter) {
        this.kolWixard = kolWixard;
        this.kolArcher = kolArcher;
        this.kolFighter = kolFighter;
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new HumanWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new HumanArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new HumanFighter());
        }
    }



}
