package Players.Clerics;

import Interfaces.IHeal;
import Parties.Party;
import Players.Player;

import java.util.ArrayList;

public class Cleric extends Player {
    private IHeal medicine;

    public Cleric(String name, IHeal medicine){
        super(name);
        this.medicine = medicine;
        this.HP = 150;
    }

    public IHeal getMedicine(){
        return medicine;
    }

    public void setMedicine(IHeal medicine){
        this.medicine = medicine;
    }

    public void heal(Player player) {
        this.medicine.heal(player);
    }

    public void healParty(Party party){
        ArrayList<Player> partyPlayers = party.getPlayers();
        for (Player player: partyPlayers){
            this.medicine.heal(player);
        }
    }
}
