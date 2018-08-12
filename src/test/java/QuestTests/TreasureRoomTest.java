package QuestTests;

import Healables.Potion;
import Parties.Party;
import Players.Clerics.Cleric;
import Quests.TreasureRoom;
import Treasure.Gold;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreasureRoomTest {

    Gold gold;
    TreasureRoom treasureRoom;
    Cleric cleric;
    Potion potion;
    Party party;
    Cleric cleric2;

    @Before
    public void before(){
        gold = new Gold();
        treasureRoom = new TreasureRoom(gold);
        potion = new Potion();
        cleric = new Cleric("Robbie", potion);
        cleric2 = new Cleric("Ellie", potion);
        party = new Party();

        party.addCleric(cleric);
        party.addCleric(cleric2);
    }

    @Test
    public void canAddPartyToRoom(){
        treasureRoom.occupantsEnter(party);
        assertEquals(party, treasureRoom.getOccupants());
    }

    @Test
    public void partyCanCollectTreasureFromRoom(){
        treasureRoom.occupantsEnter(party);
        party.collectTreasure(treasureRoom);
        assertEquals(10, party.getTreasureValue());
        assertEquals(null, treasureRoom.getTreasure());
    }

    @Test
    public void singlePlayerCanCollectTreasureFromRoom(){
        treasureRoom.occupantsEnter(cleric);
        cleric.collectTreasure(treasureRoom);
        assertEquals(10, cleric.getTreasureValue());
        assertEquals(null, treasureRoom.getTreasure());
    }

    @Test
    public void partyCanSplitTreasureBetweenMembers(){
        party.collectTreasure(treasureRoom);
        party.shareTreasure();
        assertEquals(null, treasureRoom.getTreasure());
        assertEquals(0, party.getTreasureValue());
        assertEquals(5, cleric.getTreasureValue());
        assertEquals(5, cleric2.getTreasureValue());
    }

    @Test
    public void treasureRoomStartsNotComplete(){
        assertEquals(false, treasureRoom.isRoomComplete());
    }

    @Test
    public void treasureRoomCompletesWhenTreasureRemoved(){
        treasureRoom.removeTreasure();
        assertEquals(true, treasureRoom.isRoomComplete());
    }
}
