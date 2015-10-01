package Abilities;

import Exceptions.UnitIsDeadException;
import Spells.*;
import Units.*;

public class BattleCasterAbility extends Ability {
    public BattleCasterAbility(Unit actionUnit) {
        super(actionUnit);
    }

    @Override
    public void castSpell(Unit target, Spell spell) throws UnitIsDeadException {
        if ( spell.isBattleSpell() ) {
            target.takeMagicDamage(spell.getActionPoints());
            return;
        }
        if ( target.isUndead() ) {
            return;
        }
        target.heal(spell.getActionPoints() / 2);
    }
}
