package Quests;

import Enemies.Enemy;

public class BossRoom extends Room {

    private Enemy boss;

    public BossRoom(Enemy boss){
        super();
        this.isRoomComplete = false;
        this.boss = boss;
    }

    public Enemy getBoss() {
        return boss;
    }

    public boolean checkBossAlive(){
        if (this.boss.getAliveStatus() == true){
            return true;
        } else {
            this.isRoomComplete = true;
            return false;
        }
    }

}
