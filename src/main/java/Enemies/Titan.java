package Enemies;

import Players.Player;

public class Titan extends Enemy {

    public Titan(){
        super(400);
    }

    @Override
    public void attack(Player player) {
        player.changeHP(-50);
    }
}
