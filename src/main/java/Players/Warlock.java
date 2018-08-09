package Players;

import Interfaces.IDefend;
import Interfaces.ISpell;

public class Warlock extends Mage {

    private String hatType;

    public Warlock(String name, IDefend beast, ISpell magicWeapon, String hatType){
        super(name, beast, magicWeapon);
        this.HP = 80;
        this.hatType = hatType;
    }

    public String getHatType() {
        return hatType;
    }
}
