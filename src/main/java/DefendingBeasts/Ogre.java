package DefendingBeasts;

import Enemies.Enemy;
import Interfaces.IDefend;

public class Ogre implements IDefend {

    @Override
    public void defend(Enemy enemy) {
        enemy.changeHP(-12);
    }
}
