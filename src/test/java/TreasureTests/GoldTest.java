package TreasureTests;

import Treasure.Gold;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoldTest {

    Gold gold;

    @Before
    public void before(){
        gold = new Gold();
    }

    @Test
    public void hasValueOf10(){
        assertEquals(10, gold.getValue());
    }

}
