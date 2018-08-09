package Weapons;

import Enemies.Enemy;
import Interfaces.IWeapon;

public class Club implements IWeapon {

    @Override
    public void attack(Enemy enemy) {
        enemy.changeHP(-5);
    }

}
