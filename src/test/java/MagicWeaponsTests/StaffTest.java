package MagicWeaponsTests;

import Enemies.Troll;
import MagicWeapons.Staff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaffTest {

    Staff staff;
    Troll troll;

    @Before
    public void before(){
        staff = new Staff();
        troll = new Troll();
    }

    @Test
    public void castDecreasesEnemyHPBy10(){
        staff.cast(troll);
        assertEquals(5, troll.getHP());
    }

}
