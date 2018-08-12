package Players;

import Interfaces.IQuest;
import Interfaces.ITreasure;
import Quests.Exit;
import Quests.Room;
import Quests.TreasureRoom;

public abstract class Player implements IQuest {

    protected String name;
    protected int HP;
    protected boolean aliveStatus;
    protected int treasureValue;

    public Player(String name){
        this.name = name;
        this.HP = 100;
        this.aliveStatus = true;
        this.treasureValue = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getHP(){
        return this.HP;
    }

    public boolean getAliveStatus() {
        return aliveStatus;
    }

    public int getTreasureValue() {
        return treasureValue;
    }

    public void changeHP(int changingHPAmount) {
        this.HP += changingHPAmount;
        this.aliveStatus = true;

        if (this.HP <= 0) {
            this.HP = 0;
            this.aliveStatus = false;
        }
    }

    @Override
    public void addTreasure(ITreasure treasure){
        this.treasureValue += treasure.getValue();
    }

    @Override
    public void collectTreasure(TreasureRoom treasureRoom){
        this.addTreasure(treasureRoom.getTreasure());
        treasureRoom.removeTreasure();
    }

    public void changeTreasureValue(int changingValue){
        this.treasureValue += changingValue;
    }

    @Override
    public boolean tryDoor(Room room, Exit door){
        if (room.getExit() == door){
            return true;
        } else {
            return false;
        }
    }

}
