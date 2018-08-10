package MagicWeapons;

import Enemies.Enemy;
import Interfaces.ISpell;

public class Wand implements ISpell {

    @Override
    public void cast(Enemy enemy) {
        enemy.changeHP(-5);
    }
}
