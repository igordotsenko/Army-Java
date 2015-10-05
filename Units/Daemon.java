package Units;

import Exceptions.LocationIsNotFreeException;
import Exceptions.MasterAttackException;
import Exceptions.SelfAttackException;
import Exceptions.UnitIsDeadException;
import SpellCasters.*;

public class Daemon extends Soldier {
    public Warlock master;

    public Daemon(Warlock master, int x, int y) throws LocationIsNotFreeException, Exceptions.OutOfTheDeskException {
        super("Daemon", 100, 10, master.desk, x, y); // Update position placement
        this.master = master;
        this.shortName = new String("Dmn");
        this.speed = 1;
        unitType = UnitType.DAEMONT;
    }

    public void ensureIsNotMaster(Unit enemy) throws MasterAttackException {
        if ( enemy == (Unit)master ) {
            throw new MasterAttackException();
        }
    }

    @Override
    public void attack(Unit enemy) throws UnitIsDeadException, SelfAttackException, MasterAttackException, Exceptions.ToFarException {
        ensureIsNotMaster(enemy);
        super.attack(enemy);
    }
}
