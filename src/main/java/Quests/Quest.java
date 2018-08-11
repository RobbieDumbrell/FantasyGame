package Quests;

import Parties.Party;
import Players.Player;

import java.util.ArrayList;

public class Quest {

    private ArrayList<Room> rooms;
    private Player player;
    private Party party;
    private Room currentRoom;
    private int currentRoomNumber;
    private boolean isQuestComplete;

    public Quest(){
        this.rooms = new ArrayList<>();
        this.player = null;
        this.party = null;
        this.currentRoom = null;
        this.isQuestComplete = false;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int roomCount(){
       return this.rooms.size();
    }

    public Player getPlayer() {
        return player;
    }

    public Party getParty() {
        return party;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean isQuestComplete() {
        return isQuestComplete;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
        this.currentRoom = rooms.get(this.currentRoomNumber);
    }

    public void playerEnter(Player player){
        this.player = player;
        this.currentRoom.playerEnters(player);
    }

    public void partyEnter(Party party){
        this.party = party;
        this.currentRoom.partyEnters(party);
    }

    public void moveToNextRoom(){
        this.currentRoomNumber += 1;
        this.currentRoom = rooms.get(this.currentRoomNumber);
        if (this.player != null){
            this.currentRoom.playerEnters(this.player);
        }
        if (this.party != null){
            this.currentRoom.partyEnters(this.party);
        }

    }

    public void playerEscapesRoom(){
        this.currentRoom.playerEscapes();
        if (this.roomCount() > (this.currentRoomNumber + 1)){
            this.moveToNextRoom();
        } else {
            this.isQuestComplete = true;
        }
    }

    public void partyEscapesRoom(){
        this.currentRoom.partyEscapes();
        if (this.roomCount() > (this.currentRoomNumber + 1)){
            this.moveToNextRoom();
        } else {
            this.isQuestComplete = true;
        }
    }

    public boolean playerTriesDoor(Exit door) {
        if (player.tryDoor(this.currentRoom, door) == true) {
            this.playerEscapesRoom();
            return true;
        } else {
            return false;
        }
    }

    public boolean partyTriesDoor(Exit door) {
        if (party.tryDoor(this.currentRoom, door) == true) {
            this.partyEscapesRoom();
            return true;
        } else {
            return false;
        }
    }

}
