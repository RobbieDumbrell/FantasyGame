import DefendingBeasts.Dragon;
import MagicWeapons.Staff;
import Players.Wizard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Dragon dragon;
    Staff staff;
    Wizard wizard;

    @Before
    public void before(){
        dragon = new Dragon();
        staff = new Staff();
        wizard = new Wizard("Marcin", dragon, staff, "Floppy");
    }

    @Test
    public void has70HP(){
        assertEquals(70, wizard.getHP());
    }

}
