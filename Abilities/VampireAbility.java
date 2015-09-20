package Abilities;

import Units.Unit;
import Units.UnitIsDeadException;

import java.util.Random;

public class VampireAbility extends Ability{
    Random random;

    public VampireAbility(Unit actionUnit) {
        super(actionUnit);
        random = new Random();
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException {
        drain(enemy);
        enemy.takeDamage(actionUnit.getDamage());
        if ( random.nextInt() % 5 == 0 ) {
            infect(enemy);
            return;
        }
        enemy.counterAttack(actionUnit);
    }

    public void drain(Unit enemy) throws UnitIsDeadException {
        int newHitPoints = actionUnit.getHitPoints() + enemy.getHitPoints() / 10;

        enemy.takeDamage(enemy.getHitPoints() / 10);
        if ( newHitPoints > actionUnit.getHitPointsLimit() ) {
            int hitPointsLimit = actionUnit.getHitPointsLimit();
            actionUnit.setHitPoints(hitPointsLimit);
            return;
        }
        actionUnit.setHitPoints(newHitPoints);
    }
    public void infect(Unit victim) {
        if (victim.getUnitType() == Unit.UnitType.VAMPIRET || victim.getUnitType() == Unit.UnitType.WEREWOLFT ) {
            return;
        }
        victim.changeAbility(new VampireAbility(victim));
        victim.setUnitType(Unit.UnitType.VAMPIRET);
        victim.setIsUndead();
        System.out.println(victim.getName() + " is infected by " + actionUnit.getName());
    }
}
