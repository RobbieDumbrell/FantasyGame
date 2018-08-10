package EnemiesTests;

import Enemies.Troll;
import Healables.Potion;
import Players.Clerics.Cleric;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrollTest {
    Troll troll;
    Cleric cleric;
    Potion potion;

    @Before
    public void before(){
        troll = new Troll();
        potion = new Potion();
        cleric = new Cleric("Kevin", potion);
    }

    @Test
    public void trollHas15Hp(){
        assertEquals(15, troll.getHP());
    }

    @Test
    public void enemyCanAttackPlayer(){
        troll.attack(cleric);
        assertEquals(140, cleric.getHP());
    }
}