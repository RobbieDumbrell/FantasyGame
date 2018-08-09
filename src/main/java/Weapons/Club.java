package Weapons;

import Interfaces.IWeapon;

public class Club implements IWeapon {

    @Override
    public int attack() {
        return 5;
    }

}
