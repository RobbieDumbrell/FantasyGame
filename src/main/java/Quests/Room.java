package Quests;

import Players.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Room {

    private List<Exit> doors;
    private Exit exit;
    private Player occupant;

    public Room(){
        this.doors = Arrays.asList(Exit.values());
        this.exit = this.generateRandomExit();
        this.occupant = null;
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

    public Player getOccupant() {
        return occupant;
    }

    public void playerEnters(Player player){
        this.occupant = player;
    }

    public Player playerEscapes(){
        Player escapedPlayer = this.occupant;
        this.occupant = null;
        return escapedPlayer;
    }
}
