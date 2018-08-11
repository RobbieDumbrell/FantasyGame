package PartyTests;

import DefendingBeasts.Dragon;
import DefendingBeasts.Ogre;
import Enemies.Titan;
import Healables.Potion;
import MagicWeapons.Staff;
import MagicWeapons.Wand;
import Parties.Party;
import Players.Clerics.Cleric;
import Players.Fighters.Dwarf;
import Players.Fighters.Knight;
import Players.Mages.Warlock;
import Players.Mages.Wizard;
import Treasure.Diamonds;
import Treasure.Gold;
import Weapons.Axe;
import Weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartyTest {

    Party party;
    Dwarf dwarf;
    Knight knight;
    Axe axe;
    Sword sword;
    Gold gold;
    Diamonds diamonds;
    Staff staff;
    Wand wand;
    Wizard wizard;
    Warlock warlock;
    Dragon dragon;
    Ogre ogre;
    Cleric cleric;
    Potion potion;
    Titan titan;


    @Before
    public void before(){
        axe = new Axe();
        sword = new Sword();
        staff = new Staff();
        wand = new Wand();
        ogre = new Ogre();
        dragon = new Dragon();
        potion = new Potion();
        knight = new Knight("Aragorn", sword, "Horsey");
        dwarf = new Dwarf("Gimli", axe, 4.89, 90);
        wizard = new Wizard("Gandalf", dragon, staff, "Floppy" );
        warlock = new Warlock("Harry", ogre, wand, "Shiny");
        cleric = new Cleric("John", potion);
        party = new Party();
        gold = new Gold();
        diamonds = new Diamonds();
        titan = new Titan();
    }

    @Test
    public void canAddPlayersToParty(){
        party.addFighter(dwarf);
        party.addFighter(knight);
        party.addMage(wizard);
        party.addMage(warlock);
        party.addCleric(cleric);
        assertEquals(5, party.playerCount());
        assertEquals(2, party.fighterCount());
        assertEquals(2, party.mageCount());
        assertEquals(1, party.clericCount());
    }

    @Test
    public void partyStartsWith0Treasure(){
        assertEquals(0, party.getTreasureValue());
    }

    @Test
    public void canAddDifferentTreasureValue(){
        party.addTreasure(gold);
        party.addTreasure(diamonds);
        assertEquals(25, party.getTreasureValue());
    }

    @Test
    public void wholePartyCanAttackAndCast(){
        party.addFighter(dwarf);
        party.addFighter(knight);
        party.addMage(wizard);
        party.addMage(warlock);
        party.addCleric(cleric);
        party.allAttack(titan);
        assertEquals(340, titan.getHP());
    }

    @Test
    public void clericCanHealAllInParty(){
        party.addFighter(dwarf);
        party.addFighter(knight);
        party.addMage(wizard);
        party.addMage(warlock);
        party.addCleric(cleric);
        cleric.healParty(party);
        assertEquals(80, dwarf.getHP());
        assertEquals(170, knight.getHP());
        assertEquals(90, wizard.getHP());
        assertEquals(100, warlock.getHP());
        assertEquals(170, cleric.getHP());
    }

}
