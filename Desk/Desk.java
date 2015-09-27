package Desk;

import Units.*;

public class Desk {
    public static final int deskSize = 8;
    public Unit[][] deskFields;

    public Desk() {
        deskFields = new Unit[deskSize][deskSize];
    }

    public boolean isEmptyField(int x, int y) {
        if ( deskFields[x][y] == null ) {
            return true;
        }
        return false;
    }
    public void placeUnit(Unit unit) {
        deskFields[unit.getPosition().getX()][unit.getPosition().getY()] = unit;
    }
    public void removeUnit(Unit unit) {
        deskFields[unit.getPosition().getX()][unit.getPosition().getY()] = null;
    }
    private String printMerge() {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        for ( int i = deskSize - 1; i >= 0; i--) {
            buffer.append("+---");
        }
        buffer.append("+\n");

        out = buffer.toString();
        return out;
    }
    // desk.printLine(int horizontal) - prints horizontal line
    private String printLine(int horizontal) {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        buffer.append("|");
        for ( int vertical = 0; vertical < deskSize; vertical++) {
            if ( isEmptyField(horizontal, vertical)) {
                buffer.append("   ");
            } else {
                Unit placedUnit = deskFields[horizontal][vertical];
                buffer.append(placedUnit.getShortName());
            }
            buffer.append("|");
        }
        buffer.append("\n");

        out = buffer.toString();
        return out;
    }
    @Override
    public String toString() {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        buffer.append(printMerge());
        for ( int line = deskSize - 1; line >= 0; line--) {
            buffer.append(printLine(line));
            buffer.append(printMerge());
        }

        out = buffer.toString();
        return out;
    }
}
