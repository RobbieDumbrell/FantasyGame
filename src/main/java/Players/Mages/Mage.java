package Players.Mages;

import Enemies.Enemy;
import Interfaces.IDefend;
import Interfaces.ISpell;
import Players.Player;

public abstract class Mage extends Player {

    protected IDefend beast;
    protected ISpell magicWeapon;

    public Mage(String name, IDefend beast, ISpell magicWeapon){
        super(name);
        this.beast = beast;
        this.magicWeapon = magicWeapon;
    }

    public IDefend getBeast() {
        return beast;
    }

    public ISpell getMagicWeapon() {
        return magicWeapon;
    }

    public void setBeast(IDefend beast){
        this.beast = beast;
    }

    public void setMagicWeapon(ISpell magicWeapon){
        this.magicWeapon = magicWeapon;
    }

    public void defend(Enemy enemy){
        this.beast.defend(enemy);
    }

    public void cast(Enemy enemy){
        this.magicWeapon.cast(enemy);
    }
}
