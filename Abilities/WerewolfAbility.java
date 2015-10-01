package Abilities;

import java.util.Random;
import Units.Unit;
import States.WolfState;
import States.State;
import Exceptions.UnitIsDeadException;

public class WerewolfAbility extends Ability {
    Random random = new Random();

    public WerewolfAbility(Unit actionUnit) {
        super(actionUnit);
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException {
        enemy.takeDamage(actionUnit.getDamage());
        if ( random.nextInt() % 5 == 0 ) {
            infect(enemy);
            return;
        }
        enemy.counterAttack(actionUnit);
    }

    @Override
    public void takeMagicDamage(int dmg) {
        actionUnit.getCurrentState().takeMagicDamage(dmg);
    }

    public void infect(Unit victim) {
        if (victim.getUnitType() == Unit.UnitType.VAMPIRET || victim.getUnitType() == Unit.UnitType.WEREWOLFT ) {
            return;
        }
        System.out.println(victim.getName() + " is infected by " + actionUnit.getName());
        victim.changeAbility(new WerewolfAbility(victim));
        victim.setAltState(new WolfState(victim));
        victim.setUnitType(Unit.UnitType.WEREWOLFT);
    }

    @Override
    public void changeState() {
        State currentState = actionUnit.getCurrentState();
        State altState = actionUnit.getAltState();
        State temp = currentState;
        int newHitPoints;
        double coef = (double)actionUnit.getHitPoints() / (double)currentState.getHitPointsLimit();

        actionUnit.setCurrentState(altState);
        actionUnit.setAltState(temp);
        currentState = altState;

        newHitPoints = (int)(coef * (double)currentState.getHitPointsLimit());

        actionUnit.setHitPoints(newHitPoints);
        actionUnit.setHitPointsLimit(currentState.getHitPointsLimit());
        actionUnit.setDamage(currentState.getDamage());
    }
}
