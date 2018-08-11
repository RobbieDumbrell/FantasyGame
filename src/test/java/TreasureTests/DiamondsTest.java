package TreasureTests;

import Treasure.Diamonds;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiamondsTest {

    Diamonds diamonds;

    @Before
    public void before(){
        diamonds = new Diamonds();
    }

    @Test
    public void hasValueOf15(){
        assertEquals(15, diamonds.getValue());
    }

}
