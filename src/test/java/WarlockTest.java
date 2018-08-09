import DefendingBeasts.Ogre;
import Enemies.Troll;
import MagicWeapons.Wand;
import Players.Warlock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarlockTest {

    Warlock warlock;
    Ogre ogre;
    Wand wand;
    Troll troll;

    @Before
    public void before(){
        ogre = new Ogre();
        wand = new Wand();
        warlock = new Warlock("Euan", ogre, wand, "Pointy");
        troll = new Troll();
    }

    @Test
    public void hasBeast(){
        assertEquals(ogre, warlock.getBeast());
    }

    @Test
    public void hasMagicWeapon(){
        assertEquals(wand, warlock.getMagicWeapon());
    }

    @Test
    public void hasHatType(){
        assertEquals("Pointy", warlock.getHatType());
    }

    @Test
    public void canDefendWithBeast(){
        warlock.defend(troll);
        assertEquals(3, troll.getHP());
    }

    @Test
    public void canCastWithMagicWeapon(){
        warlock.cast(troll);
        assertEquals(10, troll.getHP());
    }

    @Test
    public void has80HP(){
        assertEquals(80, warlock.getHP());
    }


}
