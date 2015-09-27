package Desk;

import Exceptions.*;
import Units.*;

public class Location {
    protected Point coordinates;
    protected Unit unit;

    public Location(Point coordinates) {
        this.coordinates = coordinates;
        this.unit = null;
    }
    public Location(Point coordinates, Unit unit) {
        this.coordinates = coordinates;
        this.unit = unit;
    }

    public Point getCoordinates() {
        return coordinates;
    }
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) throws LocationIsNotFreeException {
        if ( !isFreeForUnit() ) {
            throw new LocationIsNotFreeException();
        }
        this.unit = unit;
    }
    public void removeUnit() {
        unit = null;
    }

    public boolean isFreeForUnit() {
        if ( unit != null ) {
            return false;
        }
        return true;
    }
}
