package ru.job4j.game;

import java.util.StringJoiner;

public class UndeadDetachment extends Detachment {

    public static final String RACA = "Undead";

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public UndeadDetachment(int kolWixard, int kolArcher, int kolFighter) {

        this.kolWixard = kolWixard;
        this.kolArcher = kolArcher;
        this.kolFighter = kolFighter;
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new UndeadWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new UndeadArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new UndeadFighter());
        }
    }

    public UndeadDetachment() {
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new UndeadWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new UndeadArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new UndeadFighter());
        }
    }
}
