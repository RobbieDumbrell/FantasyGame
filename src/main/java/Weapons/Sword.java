package Weapons;

import Interfaces.IWeapon;

public class Sword implements IWeapon {

    @Override
    public int attack() {
        return 25;
    }
}
