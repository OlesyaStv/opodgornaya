package ru.job4j.game;

public abstract class Character {

    private boolean vipStatus = false;
    private boolean alive = true;
    private double livingLevel = 100;


    public void setVipStatus(boolean vipStatus) {
        this.vipStatus = vipStatus;
    }


    public boolean getVipStatus(){
        return this.vipStatus;
    }

    public void setLivingLevel(int livingLevel){
        this.livingLevel = livingLevel;
        checkAlive();
    }

    public double getLivingLevel(){
        return this.livingLevel;
    }

    public void reduceLivingLevel(int count, Character attacking){
        if (attacking.vipStatus){
            this.livingLevel = this.livingLevel - count*1.5;
            attacking.setVipStatus(false);
        } else {
            this.livingLevel = this.livingLevel - count;
        }
        checkAlive();
    }

    private void checkAlive(){
        if (livingLevel <= 0) {
            this.alive = false;
        }
    }
    public boolean getAlive(){
        return this.alive;
    }

    public abstract void attack(Character character);

}
