package PlayersTests;

import Players.Fighters.Knight;
import Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Sword sword;

    @Before
    public void before(){
        sword = new Sword();
        knight = new Knight("JarJar", sword, "Black Arrow" );
    }
    @Test
    public void getHorseName(){
        assertEquals("Black Arrow", knight.getHorseName());
    }
}
