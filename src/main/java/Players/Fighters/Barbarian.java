package Players.Fighters;

import Interfaces.IWeapon;
import Players.Fighters.Fighter;

public class Barbarian extends Fighter {
    private int numberOfTattoos;

    public Barbarian(String name, IWeapon weapon, int numberOfTattoos){
        super(name, weapon);
        this.numberOfTattoos = numberOfTattoos;
        this.HP = 40;
    }
    public int getNumberOfTattoos(){
        return this.numberOfTattoos;
    }

}
