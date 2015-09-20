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

    private String printMerge() {
        String out = new String();
        StringBuffer buffer = new StringBuffer();

        for ( int i = 0; i < deskSize; i++ ) {
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
        for ( int vertical = 0; vertical < deskSize; vertical++ ) {
            if ( isEmptyField(horizontal, vertical)) {
                buffer.append("   ");
            } else {
                buffer.append("Aa");
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
        for ( int line = 0; line < deskSize; line++ ) {
            buffer.append(printLine(line));
            buffer.append(printMerge());
        }

        out = buffer.toString();
        return out;
    }
}
