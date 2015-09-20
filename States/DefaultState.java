package States;

import Units.Unit;

/**
 * Created by Igor on 13.09.2015.
 */
public class DefaultState extends State {
    public DefaultState(Unit actionUnit) {
        super(actionUnit);
        this.name = "Default state";
    }
}
