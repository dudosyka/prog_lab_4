package items;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Place {
    private final String name;
    private final PlaceCondition placeCondition;
    ArrayList<Door> doors = new ArrayList<Door>();

    Place(PlaceCondition placeCondition, String name) {
        this.placeCondition = placeCondition;
        this.name = name;
    }

    Place(PlaceCondition placeCondition, String name, ArrayList<Door> doors) {
        this(placeCondition, name);
        this.doors = doors;
    }

    public PlaceCondition getPlaceCondition() {
        return placeCondition;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Place)) return false;
        Place place = (Place) obj;
        return this.name == place.name && this.placeCondition == place.placeCondition && this.doors.size() == place.doors.size();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.placeCondition.hashCode() + this.doors.hashCode();
    }
}
