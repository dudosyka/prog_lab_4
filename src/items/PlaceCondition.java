package items;

public enum PlaceCondition {
    DARK("Темно"), LIGHT("Светло");

    private final String name;

    PlaceCondition(String name) {
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
