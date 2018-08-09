import Enemies.Troll;
import Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwordTest {

    Troll troll;
    Sword sword;

    @Before
    public void before(){
        sword = new Sword();
        troll = new Troll();
    }

    @Test
    public void swordDoes25DamageToEnemy(){
        sword.attack(troll);
        assertEquals(0, troll.getHP());
    }
}
