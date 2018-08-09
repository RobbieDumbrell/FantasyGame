package DefendingBeasts;

import Enemies.Enemy;
import Interfaces.IDefend;

public class Dragon implements IDefend {

    @Override
    public void defend(Enemy enemy) {
        enemy.changeHP(-30);
    }
}
