package Exceptions;

import Desk.*;

public class LocationIsNotFreeException extends Exception {
    public LocationIsNotFreeException() {}

    public LocationIsNotFreeException(Point coordinates) {
        System.out.println("Coordinate " + coordinates.toString() + " is not free!");
    }
}
