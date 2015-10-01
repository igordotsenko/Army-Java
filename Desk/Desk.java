package Desk;

import Exceptions.LocationIsNotFreeException;
import Units.*;

public class Desk {
    public static final int deskSize = 8;
    public Location[][] deskFields;

    public Desk() {
        deskFields = new Location[deskSize][deskSize];

        for( int x = 0; x < deskSize; x++ ) {
            for( int y = 0; y < deskSize; y++ ) {
                deskFields[x][y] = new Location(new Point(x, y));
            }
        }
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
    public Location placeUnit(Unit unit, int x, int y) throws LocationIsNotFreeException {
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
        for ( int i = deskSize - 1; i >= 0; i--) {
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
        for ( int x = 0; x < deskSize; x++) {
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
    private String printVerticalAxis() {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        buffer.append("   "); // 3 spaces to move merge to the same space as vertical line
        for ( int verticalCoordinate = 0; verticalCoordinate < deskSize; verticalCoordinate++) {
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
        for ( int line = deskSize - 1; line >= 0; line--) {
            buffer.append(String.format("%3d ", line));
            buffer.append(printLine(line));
            buffer.append(printMerge());
        }
        buffer.append(printVerticalAxis());

        out = buffer.toString();
        return out;
    }
}
