package EnemiesTests;

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

    @Test
    public void startsOutAlive(){
        assertEquals(true, orc.getAliveStatus());
    }

    @Test
    public void diesIfHPGoesBelow0(){
        orc.changeHP(-10);
        assertEquals(false, orc.getAliveStatus());
    }

    @Test
    public void revivedIfHealed(){
        orc.changeHP(-45);
        assertEquals(false, orc.getAliveStatus());
        orc.changeHP(+1);
        assertEquals(true, orc.getAliveStatus());
    }
}
