package ru.job4j.game;
import ru.job4j.game.ElfArcher;
import ru.job4j.game.ElfFighter;
import ru.job4j.game.ElfWizard;

import java.util.StringJoiner;


public class ElfDetachment extends Detachment {

    public static final String RACA = "Elf";

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public ElfDetachment() {
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new ElfWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new ElfArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new ElfFighter());
        }
    }

    public ElfDetachment(int kolWixard, int kolArcher, int kolFighter) {

        this.kolWixard = kolWixard;
        this.kolArcher = kolArcher;
        this.kolFighter = kolFighter;
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new ElfWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new ElfArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new ElfFighter());
        }
    }


}
