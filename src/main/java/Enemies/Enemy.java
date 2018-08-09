package Enemies;

public abstract class Enemy {
    protected int HP;

    public Enemy(int HP){
        this.HP = HP;
    }
    public int getHP(){
        return this.HP;
    }
}
