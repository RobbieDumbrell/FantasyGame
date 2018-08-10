package WeaponsTests;

import Enemies.Orc;
import Weapons.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {

    Orc orc;
    Axe axe;

    @Before
    public void before(){
        axe = new Axe();
        orc = new Orc();
    }

    @Test
    public void axeDoes20DamageToEnemy(){
        axe.attack(orc);
        assertEquals(0, orc.getHP());
    }
}
