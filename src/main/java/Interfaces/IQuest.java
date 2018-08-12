package Interfaces;

import Quests.Exit;
import Quests.Room;
import Quests.TreasureRoom;

public interface IQuest {

    boolean tryDoor(Room room, Exit door);

    void addTreasure(ITreasure treasure);

    void collectTreasure(TreasureRoom treasureRoom);

}
