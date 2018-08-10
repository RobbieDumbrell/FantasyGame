package PlayersTests;

import Enemies.Troll;
import Players.Fighters.Dwarf;
import Weapons.Axe;
import Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {
    Dwarf dwarf;
    Axe axe;
    Sword sword;
    Troll troll;

    @Before
    public void before() {
        axe = new Axe();
        sword = new Sword();
        dwarf = new Dwarf("Duncan", axe, 5.2, 100);
        troll = new Troll();
    }
    @Test
    public void hasName(){
        assertEquals("Duncan", dwarf.getName());
    }

    @Test
    public void hassWeapon(){
        assertEquals(axe, dwarf.getWeapon());
    }

    @Test
    public void hasBeard(){
        assertEquals(5.2, dwarf.getBeardLength(),2);
    }

    @Test
    public void had60HP(){
        assertEquals(60, dwarf.getHP());
    }

    @Test
    public void  caChangeWeapon(){
        dwarf.setWeapon(sword);
        assertEquals(sword, dwarf.getWeapon());
    }

    @Test
    public void dwarfCanAttackEnemy(){
        dwarf.attack(troll);
        assertEquals(0, troll.getHP());
    }

    @Test
    public void hasHeight(){
        assertEquals(100, dwarf.getHeight());
    }
}
