package PlayersTests;

import Players.Fighters.Barbarian;
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

    @Test
    public void startsOutAlive(){
        assertEquals(true, barbarian.getAliveStatus());
    }

    @Test
    public void diesIfHPGoesBelow0(){
        barbarian.changeHP(-45);
        assertEquals(false, barbarian.getAliveStatus());
    }

    @Test
    public void revivedIfHealed(){
        barbarian.changeHP(-45);
        assertEquals(false, barbarian.getAliveStatus());
        barbarian.changeHP(+1);
        assertEquals(true, barbarian.getAliveStatus());
    }
}
