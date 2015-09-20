package Units;

import Abilities.Ability;
import States.State;
import java.util.HashSet;
import java.util.Iterator;

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
        protected int hitPoints;
        protected int hitPointsLimit;
        protected int damage;
        protected UnitType unitType;
        protected boolean undead;
        protected Ability ability;
        protected State currentState;
        protected State altState;
        protected HashSet<Unit> observers;
        protected HashSet<Unit> observables;

        public Unit(String name, int hitPoints, int damage) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.hitPointsLimit = hitPoints;
            this.damage = damage;
            this.undead = false;
            this.observers = new HashSet<>();
            this.observables = new HashSet<>();
        }

        protected void ensureIsAlive() throws UnitIsDeadException {
            if ( hitPoints == 0 ) {
                throw new Units.UnitIsDeadException();
            }
        }
        private void ensureIsNotSelfAttack(Unit enemy) throws SelfAttackException {
            if ( this == enemy ) {
                throw new SelfAttackException();
            }
        }


        public final String getName() {
            return this.name;
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
//
        public void changeAbility(Ability newAbility) {
            ability = newAbility;
        }
//
        public void attack(Unit enemy) throws UnitIsDeadException, SelfAttackException, MasterAttackException {
            ensureIsAlive();
            ensureIsNotSelfAttack(enemy);
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
//
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
//
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