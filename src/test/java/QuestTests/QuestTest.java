package QuestTests;

import Players.Fighters.Dwarf;
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
    Dwarf dwarf;
    Axe axe;

    @Before
    public void before(){
        room1 = new Room();
        room2 = new Room();
        room3 = new Room();
        axe = new Axe();
        dwarf = new Dwarf("Gimli", axe, 4.6, 95);
        quest = new Quest(dwarf);
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
    public void questHasPlayer(){
        assertEquals(dwarf, quest.getPlayer());
    }

    @Test
    public void playerCanEscapeToNextRoom(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.playerEscapesRoom();
        assertEquals(room2, quest.getCurrentRoom());
    }

    @Test
    public void playerCanTryDoor_Successful(){
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.playerTriesDoor(Exit.EAST);
        assertEquals();
    }


}
