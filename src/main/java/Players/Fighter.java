package Players;

import Enemies.Enemy;
import Interfaces.IWeapon;

public abstract class Fighter extends Player{
    protected IWeapon weapon;
    public Fighter(String name, IWeapon weapon){
        super(name);
        this.weapon = weapon;
    }
    public IWeapon getWeapon(){
        return this.weapon;
    }
    public void setWeapon(IWeapon weapon){
        this.weapon = weapon;
    }
    public void attack(Enemy enemy){
        this.weapon.attack(enemy);
    }

}
