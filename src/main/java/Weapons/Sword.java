package Weapons;

import Enemies.Enemy;
import Interfaces.IWeapon;

public class Sword implements IWeapon {

    @Override
    public void attack(Enemy enemy) {
        enemy.changeHP(-25);
    }
}
