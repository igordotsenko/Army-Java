package Abilities;

import Units.*;
import Spells.*;

public class HealerAbility extends Ability {
    public HealerAbility(Unit actionUnit) {
        super(actionUnit);
    }

    @Override
    public void castSpell(Unit target, Spell spell) throws UnitIsDeadException {
        if ( spell.isBattleSpell() ) {
            target.takeMagicDamage(spell.getActionPoints() / 2);
            return;
        }
        if ( target.isUndead() ) {
            return;
        }
        target.heal(spell.getActionPoints());
    }
}
