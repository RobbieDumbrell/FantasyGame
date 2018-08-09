package Healables;

import Interfaces.IHeal;
import Players.Player;

public class Potion implements IHeal {

    @Override
    public void heal(Player player) {
        player.changeHP(20);
    }
}
