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

    @Before
    public void before(){
        gold = new Gold();
        treasureRoom = new TreasureRoom(gold);
        potion = new Potion();
        cleric = new Cleric("Robbie", potion);
        party = new Party();

        party.addCleric(cleric);
    }

    @Test
    public void canAddPartyToRoom(){
        treasureRoom.partyEnters(party);
        assertEquals(party, treasureRoom.getParty());
        assertEquals(1, treasureRoom.getParty().playerCount());
    }

    @Test
    public void partyCanCollectTreasureFromRoom(){
        treasureRoom.partyEnters(party);
        party.collectTreasure(treasureRoom);
        assertEquals(10, party.getTreasureValue());
        assertEquals(null, treasureRoom.getTreasure());
    }

}
