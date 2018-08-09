import Enemies.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrollTest {
    Troll troll;

    @Before
    public void before(){
        troll = new Troll();
    }
    @Test
    public void trollHas15Hp(){
        assertEquals(15, troll.getHP());
    }
}