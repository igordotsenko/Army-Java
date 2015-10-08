package Desk;

import Exceptions.*;
import Units.*;

public class Desk {
    public int deskSize;
    public Location[][] deskFields;
    private static Desk instance;

    private Desk() {
        deskSize = 9; // 8 available point in one line
        deskFields = new Location[deskSize][deskSize];

        for( int x = 1; x < deskSize; x++ ) {
            for( int y = 1; y < deskSize; y++ ) {
                deskFields[x][y] = new Location(new Point(x, y));
            }
        }
    }
    private Desk(int deskSize) {
        this.deskSize = deskSize + 1; // deskSize available point in one line
        deskFields = new Location[this.deskSize][this.deskSize];

        for( int x = 1; x < this.deskSize; x++ ) {
            for( int y = 1; y < this.deskSize; y++ ) {
                deskFields[x][y] = new Location(new Point(x, y));
            }
        }
    }
    public static Desk getInstance() {
        if ( instance == null ) {
            instance = new Desk();
        }
        return instance;
    }
    public static Desk getInstance(int deskSize) {
        if ( instance == null ) {
            instance = new Desk(deskSize);
        }
        return instance;
    }

    public Location getLocation(int x, int y) {
        return deskFields[x][y];
    }

//    public boolean isEmptyField(int x, int y) {
//        if ( deskFields[x][y] == null ) {
//            return true;
//        }
//        return false;
//    }
    protected void ensurePointIsOnTheDesk(int x, int y) throws OutOfTheDeskException {
        if ( x == 0 || y == 0 || x >= deskSize || y >= deskSize) {
            throw new OutOfTheDeskException();
        }
    }
    public Location placeUnit(Unit unit, int x, int y) throws LocationIsNotFreeException, OutOfTheDeskException, OutOfTheDeskException {
        ensurePointIsOnTheDesk(x, y);
        deskFields[x][y].setUnit(unit);
        return deskFields[x][y];
    }
//    public void removeUnit(Unit unit) {
//        deskFields[unit.getPosition().getX()][unit.getPosition().getY()] = null;
//    }
    private String printMerge() {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        buffer.append("    "); // 4 spaces to move merge to the same space as vertical line
        for ( int i = deskSize - 1; i > 0; i--) {
            buffer.append("+---");
        }
        buffer.append("+\n");

        out = buffer.toString();
        return out;
    }
    // desk.printLine(int horizontal) - prints horizontal line
    private String printLine(int y) {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        buffer.append("|");
        for ( int x = 1; x < deskSize; x++) {
            if ( deskFields[x][y].isFreeForUnit() ) {
                buffer.append("   ");
            } else {
                Unit placedUnit = deskFields[x][y].getUnit();
                buffer.append(placedUnit.getShortName());
            }
            buffer.append("|");
        }
        buffer.append("\n");

        out = buffer.toString();
        return out;
    }
    private String printHorizontalAxis() {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        buffer.append("   "); // 3 spaces to move merge to the same space as vertical line
        for ( int verticalCoordinate = 1; verticalCoordinate < deskSize; verticalCoordinate++) {
            buffer.append(String.format("%4d", verticalCoordinate));
        }

        out = buffer.toString();
        return out;
    }
    @Override
    public String toString() {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        buffer.append(printMerge());
        for ( int line = deskSize - 1; line > 0; line--) {
            buffer.append(String.format("%3d ", line));
            buffer.append(printLine(line));
            buffer.append(printMerge());
        }
        buffer.append(printHorizontalAxis());

        out = buffer.toString();
        return out;
    }
}
