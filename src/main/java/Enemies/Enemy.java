package Enemies;

public abstract class Enemy {
    protected int HP;

    public Enemy(int HP){
        this.HP = HP;
    }
    public int getHP(){
        return this.HP;
    }

    public void changeHP(int changingHPAmount){
        this.HP += changingHPAmount;

        if (this.HP < 0){
            this.HP = 0;
        }
    }
}
