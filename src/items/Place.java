package items;

import human.Head;
import human.Limb;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Place {
    private final String name;
    private final PlaceCondition placeCondition;
    private final ArrayList<BodyPart> bodyParts;
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

    public Inspection inspect() {
        class PlaceInspection implements Inspection {
            public String getInfo() {
                return this.getCondition() + " " + this.getItems();
            }
            public String getCondition() {
                return "это помещенние " + Place.this.placeCondition.toString();
            }

            public String getItems() {
                String suffix = "";
                if (Place.this.bodyParts.size() > 5) {
                    suffix = "множество";
                }

                int haveHeads = -1;
                int haveLimbs = -1;
                int index = 0;
                for (BodyPart part : Place.this.bodyParts) {
                    if (part instanceof Head) {
                        haveHeads = index;
                    } else if (part instanceof Limb) {
                        haveLimbs = index;
                    }
                }

                String items = "";
                if (haveHeads != -1) {
                    Head head = (Head) Place.this.bodyParts.get(haveHeads);
                    items = head.toString() + " на " + head.neck.toString() + " шеях";
                    items += " все эти головы " + head.getRotation() + " ";
                }
                if (haveLimbs != -1) {
                    Limb limb = (Limb) Place.this.bodyParts.get(haveLimbs);
                    items += " " + limb.toString();
                }
                return "в помещении " + suffix + " " + items;
            }
        }

        return new PlaceInspection();
    }
}
