package Players.Mages;

import Interfaces.IDefend;
import Interfaces.ISpell;

public class Wizard extends Mage {

    private String hatType;

    public Wizard(String name, IDefend beast, ISpell magicWeapon, String hatType){
        super(name, beast, magicWeapon);
        this.HP = 70;
        this.hatType = hatType;
    }

    public String getHatType() {
        return hatType;
    }
}