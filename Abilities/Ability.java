package Abilities;

import Units.Unit;
import Spells.Spell;
import Exceptions.UnitIsDeadException;

public abstract class Ability {
    Unit actionUnit;

    Ability(Unit actionUnit) {
        this.actionUnit = actionUnit;
    }
    public void attack(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(actionUnit.getDamage());
        enemy.counterAttack(actionUnit);
    }
    public void counterAttack(Unit enemy) throws UnitIsDeadException {
        actionUnit.takeDamage(enemy.getDamage() / 2);
    }
    public void takeMagicDamage(int dmg) {
        actionUnit.getCurrentState().takeMagicDamage(dmg);
    }
    public void castSpell(Unit target, Spell spell) throws UnitIsDeadException {}
    public void changeState() {}
}
