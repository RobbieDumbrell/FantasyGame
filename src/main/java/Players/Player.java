package Players;

import Quests.Exit;
import Quests.Room;

public abstract class Player {
    protected String name;
    protected int HP;
    protected boolean aliveStatus;

    public Player(String name){
        this.name = name;
        this.HP = 100;
        this.aliveStatus = true;
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

    public void changeHP(int changingHPAmount) {
        this.HP += changingHPAmount;
        this.aliveStatus = true;

        if (this.HP <= 0) {
            this.HP = 0;
            this.aliveStatus = false;
        }
    }

//    returns true if the door can open (i.e. its the exit to the room).
    public boolean tryDoor(Room room, Exit door){
        if (room.getExit() == door){
            return true;
        } else {
            return false;
        }
    }

}
