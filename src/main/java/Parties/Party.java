package Parties;

import Enemies.Enemy;
import Interfaces.ITreasure;
import Players.Clerics.Cleric;
import Players.Fighters.Fighter;
import Players.Mages.Mage;
import Players.Player;
import Quests.Exit;
import Quests.Room;
import Quests.TreasureRoom;

import java.util.ArrayList;

public class Party {

    private ArrayList<Player> players;
    private ArrayList<Fighter> fighters;
    private ArrayList<Mage> mages;
    private ArrayList<Cleric> clerics;
    private int treasureValue;

    public Party(){
        players = new ArrayList<>();
        fighters = new ArrayList<>();
        mages = new ArrayList<>();
        clerics = new ArrayList<>();
        treasureValue = 0;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    public ArrayList<Mage> getMages() {
        return mages;
    }

    public ArrayList<Cleric> getClerics() {
        return clerics;
    }

    public int playerCount(){
        return this.players.size();
    }

    public int fighterCount(){
        return this.fighters.size();
    }

    public int mageCount(){
        return this.mages.size();
    }

    public int clericCount(){
        return this.clerics.size();
    }

    public int getTreasureValue() {
        return treasureValue;
    }

    public void addFighter(Fighter fighter){
        this.fighters.add(fighter);
        Player fighterAsPlayer = (Player) fighter;
        this.players.add(fighterAsPlayer);
    }

    public void addMage(Mage mage){
        this.mages.add(mage);
        Player mageAsPlayer = (Player) mage;
        this.players.add(mageAsPlayer);
    }

    public void addCleric(Cleric cleric){
        this.clerics.add(cleric);
        Player clericAsPlayer = (Player) cleric;
        this.players.add(clericAsPlayer);
    }

    public void addTreasure(ITreasure treasure){
        this.treasureValue += treasure.getValue();
    }

    public void allAttack(Enemy enemy){
        for (Fighter fighter : fighters){
            fighter.attack(enemy);
        }
        for (Mage mage : mages){
            mage.cast(enemy);
        }
    }

    public void collectTreasure(TreasureRoom treasureRoom){
        this.addTreasure(treasureRoom.getTreasure());
        treasureRoom.removeTreasure();
    }

    public boolean tryDoor(Room room, Exit door){
        if (room.getExit() == door){
            return true;
        } else {
            return false;
        }
    }


}
