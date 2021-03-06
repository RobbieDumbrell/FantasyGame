package Quests;

import Interfaces.ITreasure;

public class TreasureRoom extends Room {

    private ITreasure treasure;

    public TreasureRoom(ITreasure treasure){
        super();
        this.isRoomComplete = false;
        this.treasure = treasure;
    }

    public ITreasure getTreasure() {
        return treasure;
    }

    public void removeTreasure(){
        this.treasure = null;
        this.isRoomComplete = true;
    }
}
