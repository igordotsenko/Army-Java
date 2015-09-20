package Abilities;

import Units.Unit;

public class BerserkerAbility extends Ability {
    public BerserkerAbility(Unit actionUnit) {
        super(actionUnit);
    }

    @Override
    public void takeMagicDamage(int dmg) {}
}
