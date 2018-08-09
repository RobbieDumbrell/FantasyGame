package Players;

public abstract class Player {
    protected String name;
    protected int HP;

    public Player(String name){
        this.name = name;
        this.HP = 100;
    }
    public String getName(){
        return this.name;
    }

    public int getHP(){
        return this.HP;
    }
}
