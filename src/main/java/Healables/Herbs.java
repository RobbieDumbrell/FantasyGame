package Healables;

import Interfaces.IHeal;
import Players.Player;

public class Herbs implements IHeal {

    @Override
        public void heal(Player player) {
        player.changeHP(5);
    }
}
