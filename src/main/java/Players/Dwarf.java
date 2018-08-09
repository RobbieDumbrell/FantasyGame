package Players;

import Interfaces.IWeapon;

public class Dwarf extends Fighter {
    private double beardLength;
    private int height;
    public Dwarf(String name, IWeapon weapon, double beardLength, int height){
        super(name, weapon);
        this.HP = 60;
        this.beardLength = beardLength;
        this.height = height;
    }
    public double getBeardLength(){
        return this.beardLength;
    }
    public int getHeight(){
        return this.height;
    }
}
