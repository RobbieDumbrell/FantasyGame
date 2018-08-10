package DefendingBeastsTests;

import DefendingBeasts.Dragon;
import Enemies.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DragonTest {

    Dragon dragon;
    Troll troll;

    @Before
    public void before(){
        dragon = new Dragon();
        troll = new Troll();
    }

    @Test
    public void defendDecreasesEnemyHPBy30(){
        dragon.defend(troll);
        assertEquals(0, troll.getHP());
    }

}
