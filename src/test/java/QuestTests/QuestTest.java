package QuestTests;

import DefendingBeasts.Dragon;
import Enemies.Troll;
import Healables.Potion;
import MagicWeapons.Staff;
import Parties.Party;
import Players.Clerics.Cleric;
import Players.Fighters.Dwarf;
import Players.Fighters.Knight;
import Players.Mages.Wizard;
import Quests.*;
import Treasure.Gold;
import Weapons.Axe;
import Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestTest {

    Quest quest;
    Room room1;
    Room room2;
    Room room3;
    BossRoom bossRoom;
    Troll troll;
    Dwarf dwarf;
    Axe axe;
    Knight knight;
    Sword sword;
    Wizard wizard;
    Staff staff;
    Dragon dragon;
    Cleric cleric;
    Potion potion;
    TreasureRoom treasureRoom;
    Gold gold;
    Party party;

    @Before
    public void before(){
        room1 = new Room();
        room2 = new Room();
        room3 = new Room();
        troll = new Troll();
        bossRoom = new BossRoom(troll);
        gold = new Gold();
        treasureRoom = new TreasureRoom(gold);
        axe = new Axe();
        dwarf = new Dwarf("Gimli", axe, 4.6, 95);
        sword = new Sword();
        knight = new Knight("Aragorn", sword, "Shadowfax");
        staff = new Staff();
        dragon = new Dragon();
        wizard = new Wizard("Gandalf", dragon, staff, "Floppy");
        potion = new Potion();
        cleric = new Cleric("Samwise", potion);
        party = new Party();
        quest = new Quest();

        party.addFighter(dwarf);
        party.addFighter(knight);
        party.addMage(wizard);
        party.addCleric(cleric);
    }

    @Test
    public void questStartsWithNoRooms(){
        assertEquals(0, quest.roomCount());
    }

    @Test
    public void questCanAddRooms(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        assertEquals(2, quest.roomCount());
        assertEquals(room1, quest.getCurrentRoom());
    }

    @Test
    public void questCanAddBossRoom(){
        quest.addRoom(bossRoom);
        assertEquals(1, quest.roomCount());
        assertEquals(bossRoom, quest.getCurrentRoom());
    }

    @Test
    public void questCanAddTreasureRoom(){
        quest.addRoom(treasureRoom);
        assertEquals(1, quest.roomCount());
    }

    @Test
    public void questCanHavePlayer(){
        quest.addRoom(room1);
        quest.questTeamEnter(dwarf);
        assertEquals(dwarf, quest.getQuestTeam());
    }

    @Test
    public void questCanHaveParty(){
        quest.addRoom(room1);
        quest.questTeamEnter(party);
        assertEquals(party, quest.getQuestTeam());
    }

    @Test public void playerEntersFirstRoomFirst(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.questTeamEnter(dwarf);
        assertEquals(dwarf, room1.getOccupants());
    }

    @Test
    public void playerCanEscapeToNextRoom(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.questTeamEnter(dwarf);
        quest.questTeamEscapesRoom();
        assertEquals(room2, quest.getCurrentRoom());
        assertEquals(dwarf, room2.getOccupants());
        assertEquals(null, room1.getOccupants());
    }


    @Test
    public void playerCompletesQuestIfEscapeFinalRoom(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.questTeamEscapesRoom();
        assertEquals(false, quest.isQuestComplete());
        quest.questTeamEscapesRoom();
        assertEquals(true, quest.isQuestComplete());
    }

    @Test
    public void playerCanTryDoor_Successful_and_Fail(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.questTeamEnter(dwarf);
        room1.fixExit(Exit.EAST);
        room2.fixExit(Exit.NORTH);
        quest.questTeamTriesDoor(Exit.EAST);
        quest.questTeamTriesDoor(Exit.EAST);
        quest.questTeamTriesDoor(Exit.EAST);
        assertEquals(false, quest.isQuestComplete());
        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(true, quest.isQuestComplete());
    }

    @Test
    public void playerCanNotTryDoorIfRoomNotComplete_BossRoom(){
        quest.addRoom(bossRoom);
        quest.questTeamEnter(party);
        bossRoom.fixExit(Exit.NORTH);
        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(false, quest.isQuestComplete());
    }

    @Test
    public void playerCanTryDoorIfRoomComplete_BossRoom(){
        quest.addRoom(bossRoom);
        quest.questTeamEnter(party);
        bossRoom.fixExit(Exit.NORTH);
        party.allAttack(troll);
        bossRoom.checkBossAlive();
        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(true, quest.isQuestComplete());
    }

    @Test
    public void playerCanNotTryDoorIfRoomNotComplete_TreasureRoom(){
        quest.addRoom(treasureRoom);
        quest.questTeamEnter(party);
        treasureRoom.fixExit(Exit.NORTH);
        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(false, quest.isQuestComplete());
    }

    @Test
    public void playerCanTryDoorIfRoomComplete_TreasureRoom(){
        quest.addRoom(treasureRoom);
        quest.questTeamEnter(party);
        treasureRoom.fixExit(Exit.NORTH);
        party.collectTreasure(treasureRoom);
        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(true, quest.isQuestComplete());
    }

    @Test
    public void questWorks(){
        quest.addRoom(room1);
        quest.addRoom(bossRoom);
        quest.addRoom(treasureRoom);
        room1.fixExit(Exit.NORTH);
        bossRoom.fixExit(Exit.NORTH);
        treasureRoom.fixExit(Exit.NORTH);

        assertEquals(false, quest.isQuestComplete());

        quest.questTeamEnter(party);
        assertEquals(party, quest.getQuestTeam());

        quest.questTeamTriesDoor(Exit.SOUTH);
        assertEquals(room1, quest.getCurrentRoom());

        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(bossRoom, quest.getCurrentRoom());

        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(bossRoom, quest.getCurrentRoom());

        party.allAttack(troll);
        bossRoom.checkBossAlive();
        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(treasureRoom, quest.getCurrentRoom());

        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(false, quest.isQuestComplete());

        party.collectTreasure(treasureRoom);
        quest.questTeamTriesDoor(Exit.EAST);
        assertEquals(false, quest.isQuestComplete());

        quest.questTeamTriesDoor(Exit.NORTH);
        assertEquals(true, quest.isQuestComplete());

        party.shareTreasure();
        assertEquals(2, cleric.getTreasureValue());
    }

}
