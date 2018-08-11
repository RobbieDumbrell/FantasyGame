package TreasureTests;

import Treasure.Silver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SilverTest {

    Silver silver;

    @Before
    public void before(){
        silver = new Silver();
    }

    @Test
    public void hasValueOf5(){
        assertEquals(5, silver.getValue());
    }

}
