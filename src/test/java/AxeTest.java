import Weapons.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {

    Axe axe;

    @Before
    public void before(){
        axe = new Axe();
    }

    @Test
    public void axeReturns20Damage(){
        assertEquals(20, axe.attack());
    }
}
