package Abilities;

import Units.Unit;
import Units.UnitIsDeadException;

public class RogueAbility extends Ability{
    public RogueAbility(Unit actionUnit) {
        super(actionUnit);
    }
    @Override
    public void attack(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(actionUnit.getDamage());
    }
}
