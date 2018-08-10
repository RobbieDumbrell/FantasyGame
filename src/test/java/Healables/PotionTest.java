package Healables;

import Healables.Potion;
import Players.Fighters.Dwarf;
import Weapons.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotionTest {
    Potion potion;
    Dwarf dwarf;
    Axe axe;
    @Before
    public void before(){
        potion = new Potion();
        axe = new Axe();
        dwarf = new Dwarf("Ricardo", axe, 8.76, 110);

    }

    @Test
    public void cahincreasePlayerHp(){
        potion.heal(dwarf);
        assertEquals(80, dwarf.getHP());
    }
}
