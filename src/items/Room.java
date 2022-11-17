package items;

import java.util.ArrayList;

public class Room extends Place {
    ArrayList<Door> doors = new ArrayList<Door>();

    RoomType type;

    public Room(PlaceCondition placeCondition, String name, ArrayList<Door> doors) {
        super(placeCondition, name, doors);
    }

    public Room(PlaceCondition placeCondition, String name, RoomType type) {
        super(placeCondition, name);
        this.type = type;
    }

    public Room(PlaceCondition placeCondition, String name) {
        super(placeCondition, name);
    }

    @Override
    public String toString() {
        return "Комната " + this.getName();
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.doors.hashCode();
    }

    public boolean equals(Place obj) {
        return this.getName() == obj.getName() && this.doors == obj.doors;
    }
}
