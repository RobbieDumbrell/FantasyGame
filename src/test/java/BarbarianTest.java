import Players.Barbarian;
import Weapons.Club;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {
    Barbarian barbarian;
    Club club;
    @Before
    public void before(){
        club = new Club();
        barbarian = new Barbarian("Digory", club, 50 );
    }

    @Test
    public void hasNumberOfTattoos(){
        assertEquals(50, barbarian.getNumberOfTattoos());
    }
}
