package Quests;

import Parties.Party;
import Players.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Room {

    protected List<Exit> doors;
    protected Exit exit;
    protected Player occupant;
    protected Party party;

    public Room(){
        this.doors = Arrays.asList(Exit.values());
        this.exit = this.generateRandomExit();
        this.occupant = null;
        this.party = null;
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

    public Party getParty() {
        return party;
    }

    public void playerEnters(Player player){
        this.occupant = player;
    }

    public void partyEnters(Party party){
        this.party = party;
    }

    public Player playerEscapes(){
        Player escapedPlayer = this.occupant;
        this.occupant = null;
        return escapedPlayer;
    }

    public Party partyEscapes(){
        Party escapedParty = this.party;
        this.party = null;
        return escapedParty;
    }

    public void fixExit(Exit exit){
        this.exit = exit;
    }
}
