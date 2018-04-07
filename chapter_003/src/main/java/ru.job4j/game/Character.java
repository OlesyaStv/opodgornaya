package ru.job4j.game;

import java.util.Random;
import java.util.StringJoiner;

public abstract class Character {

    public static final Random RANDOM = new Random();
    private boolean vipStatus = false;
    private boolean alive = true;
    private double livingLevel = 100;
    private boolean illness = false;

    protected int coin() {
        return RANDOM.nextInt(2);
    }

    public void setVipStatus(boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    public boolean getVipStatus() {
        return this.vipStatus;
    }

    public void setLivingLevel(int livingLevel) {
        this.livingLevel = livingLevel;
        checkAlive();
    }

    public void setIllness(boolean illness) {
        this.illness = illness;
    }

    public double getLivingLevel() {
        return this.livingLevel;
    }

    public void reduceLivingLevel(int count, Character attacking) {
        double livingLevelBefore = this.livingLevel;
        if (illness) {
            count = count / 2;
            illness = false;
        }
        if (attacking.vipStatus) {
            this.livingLevel = this.livingLevel - count * 1.5;
            attacking.setVipStatus(false);
        } else {
            this.livingLevel = this.livingLevel - count;
        }

        StringJoiner stringJoiner = new StringJoiner("  ");
        stringJoiner.add(attacking.toString());
        stringJoiner.add("attack");
        stringJoiner.add(this.toString());
        stringJoiner.add("with livingLevel = ");
        stringJoiner.add(Double.toString(livingLevelBefore));
        stringJoiner.add("count ");
        stringJoiner.add(Integer.toString(count));
        System.out.println(stringJoiner.toString());
        checkAlive();
    }

    private void checkAlive() {
        if (livingLevel <= 0) {
            this.alive = false;
            StringJoiner stringJoiner = new StringJoiner("<----  ");
            stringJoiner.add(this.toString());
            stringJoiner.add("has died!");
            System.out.println(stringJoiner.toString());
        }
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void way(Character character, Character theSameRaceCharacter) {
        attack(character);
    }

    public abstract void attack(Character character);

}
