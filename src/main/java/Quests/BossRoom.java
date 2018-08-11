package Quests;

import Enemies.Enemy;

public class BossRoom extends Room {

    private Enemy boss;

    public BossRoom(Enemy boss){
        super();
        this.boss = boss;
    }

    public Enemy getBoss() {
        return boss;
    }

    public void bossAttackPlayer(){
        this.boss.attack(this.occupant);
    }

}
