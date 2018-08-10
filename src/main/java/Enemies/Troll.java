package Enemies;

import Players.Player;

public class Troll extends Enemy{

    public Troll(){
        super(15);
    }

    @Override
    public void attack(Player player) {
        player.changeHP(-10);
    }

}
