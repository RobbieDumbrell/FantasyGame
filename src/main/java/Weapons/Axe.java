package Weapons;

import Interfaces.IWeapon;

public class Axe implements IWeapon {

    @Override
    public int attack() {
        return 20;
    }
}
