package Players;

import Interfaces.IWeapon;

public class Dwarf extends Fighter {
    private double beardLength;
    public Dwarf(String name, IWeapon weapon, double beardLength){
        super(name, weapon);
        this.HP = 60;
        this.beardLength = beardLength;
    }
    public double getBeardLength(){
        return this.beardLength;
    }
}
