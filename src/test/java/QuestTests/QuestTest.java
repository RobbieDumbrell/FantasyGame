package QuestTests;

import Enemies.Troll;
import Players.Fighters.Dwarf;
import Quests.BossRoom;
import Quests.Exit;
import Quests.Quest;
import Quests.Room;
import Weapons.Axe;
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

    @Before
    public void before(){
        room1 = new Room();
        room2 = new Room();
        room3 = new Room();
        troll = new Troll();
        bossRoom = new BossRoom(troll);
        axe = new Axe();
        dwarf = new Dwarf("Gimli", axe, 4.6, 95);
        quest = new Quest();
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
    public void questHasPlayer(){
        quest.addRoom(room1);
        quest.playerEnter(dwarf);
        assertEquals(dwarf, quest.getPlayer());
    }

    @Test public void playerCanEnterFirstRoom(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.playerEnter(dwarf);
        assertEquals(dwarf, room1.getOccupant());
    }

    @Test
    public void playerCanEscapeToNextRoom(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.playerEnter(dwarf);
        quest.playerEscapesRoom();
        assertEquals(room2, quest.getCurrentRoom());
        assertEquals(dwarf, room2.getOccupant());
        assertEquals(null, room1.getOccupant());
    }

    @Test
    public void playerCompletesQuestIfEscapeFinalRoom(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.playerEscapesRoom();
        assertEquals(false, quest.isQuestComplete());
        quest.playerEscapesRoom();
        assertEquals(true, quest.isQuestComplete());
    }

    @Test
    public void playerCanTryDoor_Successful_and_Fail(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.playerEnter(dwarf);
        room1.fixExit(Exit.EAST);
        room2.fixExit(Exit.NORTH);
        quest.playerTriesDoor(Exit.EAST);
        quest.playerTriesDoor(Exit.EAST);
        quest.playerTriesDoor(Exit.EAST);
        assertEquals(false, quest.isQuestComplete());
        quest.playerTriesDoor(Exit.NORTH);
        assertEquals(true, quest.isQuestComplete());
    }



}
