package Weapons;

import Enemies.Enemy;
import Interfaces.IWeapon;

public class Axe implements IWeapon {

    @Override
    public void attack(Enemy enemy) {
        enemy.changeHP(-20);
    }
}
