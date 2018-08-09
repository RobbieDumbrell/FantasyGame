import Enemies.Orc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrcTest {
    Orc orc;

    @Before
    public void before(){
        orc = new Orc();
    }

    @Test
    public void orcHas10Hp(){
        assertEquals(10, orc.getHP());
    }

    @Test
    public void orcCanDecreaseHP(){
        orc.changeHP(-5);
        assertEquals(5, orc.getHP());
    }

    @Test
    public void orcDoesNotGetMinusHP(){
        orc.changeHP(-20);
        assertEquals(0, orc.getHP());
    }
}
