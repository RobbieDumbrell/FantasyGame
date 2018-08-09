import Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwordTest {

    Sword sword;

    @Before
    public void before(){
        sword = new Sword();
    }

    @Test
    public void swordReturns25Damage(){
        assertEquals(25, sword.attack());
    }
}
