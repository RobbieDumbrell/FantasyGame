package DefendingBeastsTests;

import DefendingBeasts.Ogre;
import Enemies.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OgreTest {

    Ogre ogre;
    Troll troll;

    @Before
    public void before(){
        ogre = new Ogre();
        troll = new Troll();
    }

    @Test
    public void defendDecreasesEnemyHPBy12(){
        ogre.defend(troll);
        assertEquals(3, troll.getHP());
    }

}
