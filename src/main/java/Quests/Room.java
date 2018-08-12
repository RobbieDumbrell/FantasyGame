package Quests;

import Interfaces.IQuest;
import Parties.Party;
import Players.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Room {

    protected List<Exit> doors;
    protected Exit exit;
    protected IQuest occupants;
    protected boolean isRoomComplete;

    public Room(){
        this.doors = Arrays.asList(Exit.values());
        this.exit = this.generateRandomExit();
        this.occupants = null;
        this.isRoomComplete = true;
    }

    public Exit generateRandomExit(){
        Random randomSelector = new Random();
        Exit randomExit = this.doors.get(randomSelector.nextInt(doors.size()));
        return randomExit;
    }

    public List<Exit> getDoors() {
        return doors;
    }

    public Exit getExit() {
        return exit;
    }

    public IQuest getOccupants() {
        return occupants;
    }

    public boolean isRoomComplete() {
        return isRoomComplete;
    }

    public void occupantsEnter(IQuest occupants){
        this.occupants = occupants;
    }

    public IQuest occupantsEscape(){
        IQuest escapers = this.occupants;
        this.occupants = null;
        return escapers;
    }

    public void fixExit(Exit exit){
        this.exit = exit;
    }

}
