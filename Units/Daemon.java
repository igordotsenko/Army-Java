package Units;

import SpellCasters.*;

public class Daemon extends Soldier {
    public Warlock master;

    public Daemon(Warlock master) {
        super("Daemon", 100, 10);
        this.master = master;
        unitType = UnitType.DAEMONT;
    }

    public void ensureIsNotMaster(Unit enemy) throws MasterAttackException {
        if ( enemy == (Unit)master ) {
            throw new MasterAttackException();
        }
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, SelfAttackException, MasterAttackException {
        ensureIsNotMaster(enemy);
        super.attack(enemy);
    }
}
