package QuestTests;

import Players.Fighters.Knight;
import Quests.Exit;
import Quests.Room;
import Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room1;
    Room room2;
    Room room3;
    Knight knight;
    Sword sword;

    @Before
    public void before(){
        room1 = new Room();
        room2 = new Room();
        room3 = new Room();
        sword = new Sword();
        knight = new Knight("Boris", sword, "Pegasus");
    }

    @Test
    public void roomAlwaysHas4Doors(){
        ArrayList<Exit> expected = new ArrayList<>();
        expected.add(Exit.NORTH);
        expected.add(Exit.EAST);
        expected.add(Exit.SOUTH);
        expected.add(Exit.WEST);
        assertEquals(expected, room1.getDoors());
        assertEquals(expected, room2.getDoors());
        assertEquals(expected, room3.getDoors());
    }

    @Test
    public void roomStartsEmpty(){
        assertEquals(null, room1.getOccupants());
    }

    @Test
    public void canAddPlayerToRoom(){
        room1.occupantsEnter(knight);
        assertEquals(knight, room1.getOccupants());
    }

    @Test
    public void playerCanEscape(){
        room1.occupantsEnter(knight);
        assertEquals(knight, room1.getOccupants());
        room1.occupantsEscape();
        assertEquals(null, room1.getOccupants());
    }

    @Test
    public void canFixExit(){
        room1.fixExit(Exit.EAST);
        assertEquals(Exit.EAST, room1.getExit());
    }

    @Test
    public void standardRoomStartsComplete(){
        assertEquals(true, room1.isRoomComplete());
    }

}
