package ru.job4j.game;

import java.util.StringJoiner;

public class OrcsDetachment extends Detachment {

    public static final String RACA = "Orcs";

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/");
        stringJoiner.add(this.RACA);
        return stringJoiner.toString();
    }

    public OrcsDetachment() {
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new OrcsWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new OrcsArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new OrcsFighter());
        }
    }

    public OrcsDetachment(int kolWixard, int kolArcher, int kolFighter) {

        this.kolWixard = kolWixard;
        this.kolArcher = kolArcher;
        this.kolFighter = kolFighter;
        for (int j = 0; j < kolWixard; j++) {
            characters.add(new OrcsWizard());
        }
        for (int i = 0; i < kolArcher; i++) {
            characters.add(new OrcsArcher());
        }
        for (int i = 0; i < kolFighter; i++) {
            characters.add(new OrcsFighter());
        }
    }

}
