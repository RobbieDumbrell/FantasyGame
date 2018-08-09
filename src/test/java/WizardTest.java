import DefendingBeasts.Dragon;
import DefendingBeasts.Ogre;
import MagicWeapons.Staff;
import MagicWeapons.Wand;
import Players.Wizard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Dragon dragon;
    Staff staff;
    Wizard wizard;
    Ogre ogre;
    Wand wand;

    @Before
    public void before(){
        dragon = new Dragon();
        staff = new Staff();
        ogre = new Ogre();
        wand = new Wand();
        wizard = new Wizard("Marcin", dragon, staff, "Floppy");
    }

    @Test
    public void has70HP(){
        assertEquals(70, wizard.getHP());
    }

    @Test
    public void canChangeBeast(){
        wizard.setBeast(ogre);
        assertEquals(ogre, wizard.getBeast());
    }

    @Test
    public void canChangeMagicWeapon(){
        wizard.setMagicWeapon(wand);
        assertEquals(wand, wizard.getMagicWeapon());
    }

}
