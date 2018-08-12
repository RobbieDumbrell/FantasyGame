package Quests;

import Interfaces.IQuest;

import java.util.ArrayList;

public class Quest {

    private ArrayList<Room> rooms;
    private IQuest questTeam;
    private Room currentRoom;
    private int currentRoomNumber;
    private boolean isQuestComplete;

    public Quest(){
        this.rooms = new ArrayList<>();
        this.questTeam = null;
        this.currentRoom = null;
        this.isQuestComplete = false;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int roomCount(){
       return this.rooms.size();
    }

    public IQuest getQuestTeam() {
        return questTeam;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean isRoomComplete(){
        return this.currentRoom.isRoomComplete();
    }

    public boolean isQuestComplete() {
        return isQuestComplete;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
        this.currentRoom = rooms.get(this.currentRoomNumber);
    }

    public void questTeamEnter(IQuest questTeam){
        this.questTeam = questTeam;
        this.currentRoom.occupantsEnter(questTeam);
    }

    public void moveToNextRoom(){
        this.currentRoomNumber += 1;
        this.currentRoom = rooms.get(this.currentRoomNumber);
        if (this.questTeam != null){
            this.currentRoom.occupantsEnter(this.questTeam);
        }
    }

    public void questTeamEscapesRoom(){
        this.currentRoom.occupantsEscape();
        if (this.roomCount() > (this.currentRoomNumber + 1)){
            this.moveToNextRoom();
        } else {
            this.isQuestComplete = true;
        }
    }

    public boolean questTeamTriesDoor(Exit door){
        if (this.isRoomComplete() == false){
            return false;
        }

        if (questTeam.tryDoor(this.currentRoom, door) == true) {
            this.questTeamEscapesRoom();
            return true;
        } else {
            return false;
        }
    }


}
