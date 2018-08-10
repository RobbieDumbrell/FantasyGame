package Healables;

import Healables.Herbs;
import Players.Fighters.Dwarf;
import Weapons.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HerbsTest {
    Herbs herbs;
    Dwarf dwarf;
    Axe axe;
    @Before
    public void before(){
        herbs = new Herbs();
        axe = new Axe();
        dwarf = new Dwarf("Ricardo", axe, 8.76, 110);

    }

    @Test
    public void cahincreasePlayerHp(){
        herbs.heal(dwarf);
        assertEquals(65, dwarf.getHP());
    }
}
