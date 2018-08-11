package Players.Mages;

import Interfaces.IDefend;
import Interfaces.ISpell;

public class Warlock extends Mage {

    private String cloakType;

    public Warlock(String name, IDefend beast, ISpell magicWeapon, String cloakType){
        super(name, beast, magicWeapon);
        this.HP = 80;
        this.cloakType = cloakType;
    }

    public String getHatType() {
        return cloakType;
    }
}
