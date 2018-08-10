package Quests;

import Players.Player;

import java.util.ArrayList;

public class Quest {

    private ArrayList<Room> rooms;
    private Player player;
    private Room currentRoom;
    private int currentRoomNumber;

    public Quest(Player player){
        this.rooms = new ArrayList<>();
        this.player = player;
        this.currentRoom = null;
        this.currentRoomNumber = 0;
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
        this.currentRoom = rooms.get(this.currentRoomNumber);
        this.currentRoomNumber = 0;
    }

    public void moveToNextRoom(){
        this.currentRoomNumber += 1;
        this.currentRoom = rooms.get(this.currentRoomNumber);
    }

    public void playerEscapesRoom(){
        this.currentRoom.playerEscapes();
        this.moveToNextRoom();
    }

    public void playerTriesDoor(Exit door) {
        if (player.tryDoor(this.currentRoom, door) == true){
            this.playerEscapesRoom();
        }
    }

}
