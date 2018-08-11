package Treasure;

import Interfaces.ITreasure;

public class Gold implements ITreasure {

    @Override
    public int getValue() {
        return 10;
    }
}
