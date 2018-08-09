import Enemies.Orc;
import Weapons.Club;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClubTest {

    Orc orc;
    Club club;

    @Before
    public void before(){
        club = new Club();
        orc = new Orc();
    }

    @Test
    public void clubDoes5DamageToEnemy(){
        club.attack(orc);
        assertEquals(5, orc.getHP());
    }
}
