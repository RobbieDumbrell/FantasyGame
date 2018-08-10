package Enemies;

import Players.Player;

public abstract class Enemy {

    protected int HP;
    protected boolean aliveStatus;

    public Enemy(int HP){
        this.HP = HP;
        this.aliveStatus = true;
    }

    public int getHP(){
        return this.HP;
    }

    public boolean getAliveStatus() {
        return aliveStatus;
    }

    public void changeHP(int changingHPAmount){
        this.HP += changingHPAmount;
        this.aliveStatus = true;

        if (this.HP <= 0){
            this.HP = 0;
            this.aliveStatus = false;
        }
    }

    public abstract void attack(Player player);


}
