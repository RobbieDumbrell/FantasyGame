import Healables.Herbs;
import Healables.Potion;
import Players.Cleric;
import Players.Dwarf;
import Weapons.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {
    Cleric cleric;
    Potion potion;
    Dwarf dwarf;
    Axe axe;
    Herbs herbs;

    @Before
    public void before(){
        potion = new Potion();
        herbs = new Herbs();
        cleric = new Cleric("Garry", potion);
        dwarf = new Dwarf("Stoo", axe, 6.3, 80);
    }

    @Test
    public void hasPotion(){
        assertEquals(potion, cleric.getMedicine());
    }

    @Test
    public void canHealPleyer(){
        cleric.heal(dwarf);
        assertEquals(80, dwarf.getHP());
    }

    @Test
    public void canChangeMedicine(){
        cleric.setMedicine(herbs);
        assertEquals(herbs, cleric.getMedicine());
    }
}
