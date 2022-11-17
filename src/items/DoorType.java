package items;

public enum DoorType {
    OAK("Дубовая"), BIRCH("Берёзовая"), MAPLE("Кленовая");

    private final String name;

    DoorType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String toString(boolean howNotation, boolean whichNotation) {
        return this.name;
    }
}
