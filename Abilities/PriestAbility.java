package Abilities;

import Units.Unit;
import Spells.*;
import Exceptions.UnitIsDeadException;

public class PriestAbility extends Ability {
    public PriestAbility(Unit actionUnit) {
        super(actionUnit);
    }

    @Override
    public void castSpell(Unit target, Spell spell) throws UnitIsDeadException {
        if ( spell.isBattleSpell() ) {
            if ( target.isUndead() ) {
                target.takeMagicDamage(spell.getActionPoints());
                return;
            }
            target.takeMagicDamage(spell.getActionPoints() / 2);
            return;
        }
        if ( target.isUndead() ) {
            return;
        }
        target.heal(spell.getActionPoints());
    }
}
