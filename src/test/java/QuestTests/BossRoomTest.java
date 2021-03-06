package QuestTests;

import DefendingBeasts.Dragon;
import Enemies.Troll;
import MagicWeapons.Staff;
import Players.Mages.Wizard;
import Quests.BossRoom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BossRoomTest {

    BossRoom bossRoom;
    Troll troll;
    Wizard wizard;
    Dragon dragon;
    Staff staff;

    @Before
    public void before(){
        troll = new Troll();
        bossRoom = new BossRoom(troll);
        dragon = new Dragon();
        staff = new Staff();
        wizard = new Wizard("Gandalf", dragon, staff, "Floppy");
    }

    @Test
    public void bossRoomHasEnemy(){
        assertEquals(troll, bossRoom.getBoss());
    }

    @Test
    public void bossRoomStartsNotComplete(){
        assertEquals(false, bossRoom.isRoomComplete());
    }

    @Test
    public void bossRoomCompletesWhenBossDeadAndChecked(){
        wizard.cast(troll);
        wizard.cast(troll);
        assertEquals(false, bossRoom.getBoss().getAliveStatus());
        assertEquals(false, bossRoom.isRoomComplete());
        bossRoom.checkBossAlive();
        assertEquals(true, bossRoom.isRoomComplete());
    }

}
