package Units;

public interface Observable {
    public void addObserver(Unit observer);
    public void removeObserver(Unit observer);
}
