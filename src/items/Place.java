package items;

import human.Head;
import human.Limb;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Place {
    protected final String name;
    protected final PlaceCondition placeCondition;
    protected final ArrayList<BodyPart> bodyParts;
    ArrayList<Door> doors = new ArrayList<Door>();

    Place(PlaceCondition placeCondition, String name, ArrayList<BodyPart> bodyParts) {
        this.placeCondition = placeCondition;
        this.name = name;
        this.bodyParts = bodyParts;
    }

    Place(PlaceCondition placeCondition, String name, ArrayList<BodyPart> bodyParts, ArrayList<Door> doors) {
        this(placeCondition, name, bodyParts);
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

    public interface Inspection {
        public String getInfo();
        public String getCondition();

        public String getItems();
    }

    public abstract Inspection inspect();
}
