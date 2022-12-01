package items;

import java.util.ArrayList;

public class House extends Place {
    ArrayList<Room> rooms = new ArrayList<Room>();

    public House(PlaceCondition placeCondition, String name) {
        super(placeCondition, name, new ArrayList<BodyPart>());
    }

    public House(PlaceCondition placeCondition, String name, ArrayList<Room> rooms) throws EmptyHouseException {
        this(placeCondition, name);
        if (rooms.size() == 0)
            throw new EmptyHouseException();
        this.rooms = rooms;
    }

    public House(PlaceCondition placeCondition, String name, ArrayList<Room> rooms, ArrayList<Door> doors) throws EmptyHouseException {
        super(placeCondition, name, new ArrayList<BodyPart>(), doors);
        if (rooms.size() == 0)
            throw new EmptyHouseException();
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof House)) return false;
        House house = (House) obj;
        return this.rooms.size() == house.rooms.size();
    }

    @Override
    public int hashCode() {
        return this.rooms.hashCode() + 100;
    }
}
