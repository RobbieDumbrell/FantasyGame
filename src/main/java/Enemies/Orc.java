package Enemies;

import Players.Player;

public class Orc extends Enemy{

    public Orc(){
        super(10);
    }

    @Override
    public void attack(Player player) {
        player.changeHP(-5);
    }
}
