package Treasure;

import Interfaces.ITreasure;

public class Diamonds implements ITreasure {

    @Override
    public int getValue() {
        return 15;
    }
}
