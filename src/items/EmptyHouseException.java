package items;

public class EmptyHouseException extends Exception {
    public EmptyHouseException() {
        super("Нельзя создать дом без комнат!");
    }
}
