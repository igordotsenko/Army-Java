package Units;

import Exceptions.*;
import Desk.*;
import Abilities.Ability;
import States.State;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.ListIterator;

public abstract class Unit implements Observer, Observable {

    public enum UnitType {
            SOLDIERT,
            ROGUET,
            BERSERKRT,
            VAMPIRET,
            WEREWOLFT,
            WIZARDT,
            HEALERT,
            PRIESTT,
            WARLOCKT,
            NECROMANCERT,
            DAEMONT
        }
    protected String name;
    protected String shortName;
    protected int hitPoints;
    protected int hitPointsLimit;
    protected int damage;
    protected int attackRadius;
    protected int speed;
    protected UnitType unitType;
    protected boolean undead;
    protected Ability ability;
    protected State currentState;
    protected State altState;
    protected HashSet<Unit> observers;
    protected HashSet<Unit> observables;
    protected Desk desk;
    protected Location position;

    public Unit(String name, int hitPoints, int damage, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException, OutOfTheDeskException, OutOfTheDeskException {
        this.name = name;
        this.hitPoints = hitPoints;
        this.hitPointsLimit = hitPoints;
        this.damage = damage;
        this.attackRadius = 1;
        this.undead = false;
        this.observers = new HashSet<>();
        this.observables = new HashSet<>();
        this.desk = desk;
        this.position = desk.placeUnit(this, positionX, positionY);
    }

    protected void ensureIsAlive() throws UnitIsDeadException {
            if ( hitPoints == 0 ) {
                throw new UnitIsDeadException();
            }
        }
    protected void ensureIsNotSelfAttack(Unit enemy) throws SelfAttackException {
            if ( this == enemy ) {
                throw new SelfAttackException();
            }
        }
//    protected void ensureFieldIsEmpty(int x, int y) throws FieldIsOccupiedException {
//        if ( !desk.isEmptyField(x, y)) {
//            throw new FieldIsOccupiedException();
//        }
//    }
    protected void ensureIsNotDiagonalMove(Point destination) throws DiagonalMoveException {
        int horizontalSteps = destination.getX() - position.getCoordinates().getX();
        int vericalSteps = destination.getY() - position.getCoordinates().getY();

        if ( horizontalSteps != 0 && vericalSteps != 0 ) {
            throw new DiagonalMoveException();
        }
    }
    protected void ensureDistanceIsAcceptable(Point destination, int chekcedParameter) throws ToFarException {
        if ( destination.distance(position.getCoordinates()) > chekcedParameter) {
            throw new ToFarException();
        }
    }

    public final String getName() {
            return this.name;
        }
    public String getShortName() {
        return shortName;
    }
    public final int getHitPoints() {
            return hitPoints;
        }
    public final int getHitPointsLimit() {
            return hitPointsLimit;
        }
    public final UnitType getUnitType() {
            return unitType;
        }
    public final int getDamage() {
            return damage;
        }
    public int getAttackRadius() {
        return attackRadius;
    }
    public final boolean isUndead() {
            return undead;
        }
    public final State getCurrentState() {
            return currentState;
        }
    public final State getAltState() {
            return altState;
        }
    public final HashSet<Unit> getObservers() {
            return observers;
        }
    public final HashSet<Unit> getObservables() {
            return observables;
        }
    public Location getPosition() {
            return position;
        }

    public void setName(String newName) {
            this.name = newName;
        }
    public void setHitPoints(int newHitPoints) {
            this.hitPoints = newHitPoints;
        }
    public void setHitPointsLimit(int newHitPointsLimit) {
            this.hitPointsLimit = newHitPointsLimit;
        }
    public void setDamage(int newDamage) {
            this.damage = newDamage;
        }
    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }

    public void setUnitType(UnitType newUnitType) {
            unitType = newUnitType;
        }
    public void setIsUndead() {
        this.undead = !undead;
    }
    public void setCurrentState(State newCurrentState) {
        currentState = newCurrentState;
    }
    public void setAltState(State newAltState) {
        altState = newAltState;
    }

    public void move(int newX, int newY) throws FieldIsOccupiedException, ToFarException, DiagonalMoveException, LocationIsNotFreeException, ToFarException {
        Point destination = new Point(newX, newY);
        ArrayList<Location> path;
        ListIterator<Location> it;

        if ( destination.equals(position.getCoordinates()) ) {
            return;
        }
        ensureIsNotDiagonalMove(destination);
        ensureDistanceIsAcceptable(destination, speed);
        path = specifyPath(destination);
        it = path.listIterator(path.size());
        Location checkedLocation = null;
        for ( ; it.hasPrevious(); checkedLocation = it.previous() ); // later here will be added checking for location's bonuses, extra damages etc.
        if (checkedLocation != null) {
            position.removeUnit();
            checkedLocation.setUnit(this);
            position = checkedLocation;
        }


//        ensureFieldIsEmpty(newX, newY);
//        desk.removeUnit(this);
//        position = newPosition;
//        desk.placeUnit(this);
    }
    public ArrayList<Location> specifyPath(Point destination) throws LocationIsNotFreeException{
        ArrayList<Location> path = new ArrayList<>();
        int horizontalSteps = destination.getX() - position.getCoordinates().getX();
        int verticalSteps = destination.getY() - position.getCoordinates().getY();

        for ( int step = Integer.signum(horizontalSteps); horizontalSteps != 0; horizontalSteps -= step ) {
            int checkedX = position.getCoordinates().getX() + horizontalSteps;
            int checkedY = position.getCoordinates().getY();
            Location checkedLocation = desk.deskFields[checkedX][checkedY];

            if ( checkedLocation.isFreeForUnit() ) {
                path.add(checkedLocation);
            } else {
                throw new LocationIsNotFreeException(checkedLocation.getCoordinates());
            }
        } // horizontal path
        for ( int step = Integer.signum(verticalSteps); verticalSteps != 0; verticalSteps -= step ) {
            int checkedX = position.getCoordinates().getX();
            int checkedY = position.getCoordinates().getY() + verticalSteps;
            Location checkedLocation = desk.deskFields[checkedX][checkedY];

            if ( checkedLocation.isFreeForUnit() ) {
                path.add(checkedLocation);
            } else {
                throw new LocationIsNotFreeException(checkedLocation.getCoordinates());
            }
        } // vertical path

        return path;
    } // this method is needed for future, when locations will be able to have additional features as bonuses, extra damages etc.
    public void changeAbility(Ability newAbility) {
            ability = newAbility;
        }
    public void attack(Unit enemy) throws UnitIsDeadException, SelfAttackException, MasterAttackException, ToFarException, ToFarException {
            ensureIsAlive();
            ensureIsNotSelfAttack(enemy);
            ensureDistanceIsAcceptable(enemy.getPosition().getCoordinates(), attackRadius);
            ability.attack(enemy);
        }
    public void counterAttack(Unit enemy) throws UnitIsDeadException {
            try {
                ensureIsAlive();
            } catch ( UnitIsDeadException e ) {
                return;
            }
            enemy.ability.counterAttack(this);
        }
    public void takeDamage(int dmg) throws UnitIsDeadException {
            if ( dmg > hitPoints) {
                hitPoints = 0;
                notifyObservers();
                notifyObservables();
                return;
            }
            hitPoints -= dmg;
        }
    public void takeMagicDamage(int dmg) {
            ability.takeMagicDamage(dmg);
        }
    public void heal(int healPoints) throws UnitIsDeadException {
            ensureIsAlive();

            int newHitPoints = hitPoints + healPoints;

            if ( newHitPoints > hitPointsLimit) {
                hitPoints = hitPointsLimit;
                return;
            }
            hitPoints = newHitPoints;
        }
    public void addHitPoints(int hitPoints) throws  UnitIsDeadException {
            ensureIsAlive();

            int newHitPoints = this.hitPoints + hitPoints;

            if ( newHitPoints > hitPointsLimit) {
                this.hitPoints = hitPointsLimit;
                return;
            }
            this.hitPoints = newHitPoints;
        }

    @Override
    public void addObserver(Unit observer){
            observers.add(observer);
        }
    @Override
    public void removeObserver(Unit observer){
            observers.remove(observer);
        }
    @Override
    public void addObservable(Unit observable){
            observables.add(observable);
            observable.addObserver(this);
        }
    @Override
    public void removeObservable(Unit observable){
            observables.remove(observable);
        }
    public void notifyObservers() throws UnitIsDeadException {
            Iterator<Unit> it = observers.iterator();
            Unit observer;

            for ( ; it.hasNext();) {
                observer = it.next();
                observer.addHitPoints(hitPointsLimit/10);
                observer.observables.remove(this);
            }
            observers.clear();
        }
    public void notifyObservables() {
            Iterator<Unit> it = observables.iterator();
            Unit observable;

            for ( ; it.hasNext(); ) {
                observable = it.next();
                observable.observers.remove(this);
            }
            observables.clear();
        }

    public void transform() {
            ability.changeState();
        }

    @Override
    public String toString() {
            String out;
            StringBuffer buffer = new StringBuffer();

            buffer.append(name + ": ");

            if ( unitType == UnitType.WEREWOLFT ) {
                buffer.append(currentState.getName() + " : ");
            }

            if ( hitPoints == 0 ) {
                buffer.append("is dead");
                out = buffer.toString();
                return out;
            }

            buffer.append("hp(" + hitPoints + "/" + hitPointsLimit + "), dmg(" + damage + ")");

            if ( !observers.isEmpty() ) {
                Iterator<Unit> it = observers.iterator();
                Unit observer;

                buffer.append(", observers [ ");
                for ( ; it.hasNext(); ) {
                    observer = it.next();
                    buffer.append(observer.getName() + " ");
                }
                buffer.append("]");
            }

            if ( !observables.isEmpty() ) {
                Iterator<Unit> it = observables.iterator();
                Unit observable;

                buffer.append(", observables [ ");
                for ( ; it.hasNext(); ) {
                    observable = it.next();
                    buffer.append(observable.getName() + " ");
                }
                buffer.append("]");
            }

            out = buffer.toString();
            return out;
        }
};