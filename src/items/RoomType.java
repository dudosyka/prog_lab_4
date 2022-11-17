package items;

public enum RoomType {
    LIVING_ROOM("Гостинная"), CANTEEN("Столовая"), BEDROOM("Спальня"), HALL("Зал");

    private final String name;

    RoomType(String name) {
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
