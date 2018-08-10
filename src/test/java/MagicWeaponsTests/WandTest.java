package MagicWeaponsTests;

import Enemies.Enemy;
import Enemies.Troll;
import MagicWeapons.Wand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WandTest {

    Wand wand;
    Troll troll;

    @Before
    public void before(){
        wand = new Wand();
        troll = new Troll();
    }

    @Test
    public void castDecreasesEnemyHPBy5(){
        wand.cast(troll);
        assertEquals(10, troll.getHP());
    }

}
