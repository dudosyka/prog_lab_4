package items;

import human.Head;
import human.Limb;

import java.util.ArrayList;

public class Room extends Place {
    ArrayList<Door> doors = new ArrayList<Door>();

    RoomType type;

    public Room(PlaceCondition placeCondition, String name, ArrayList<Door> doors, ArrayList<BodyPart> bodyParts) {
        super(placeCondition, name, bodyParts, doors);
    }
    public Room(PlaceCondition placeCondition, String name, RoomType type, ArrayList<BodyPart> bodyParts) {
        super(placeCondition, name, bodyParts);
        this.type = type;
    }
    public Room(PlaceCondition placeCondition, String name, ArrayList<BodyPart> bodyParts) {
        super(placeCondition, name, bodyParts);
    }
    public Room(PlaceCondition placeCondition, String name) {
        super(placeCondition, name, new ArrayList<BodyPart>());
    }

    @Override
    public String toString() {
        return "Комната " + this.getName();
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.doors.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Room)) return false;
        Room room = (Room) obj;
        return this.getName() == room.getName() && this.doors == room.doors;
    }

    public Inspection inspect() {
        class RoomInspection implements Inspection {
            public String getInfo() {
                return this.getCondition() + " " + this.getItems();
            }
            public String getCondition() {
                return "это помещенние " + Room.this.placeCondition.toString();
            }

            public String getItems() {
                String suffix = "";
                if (Room.this.bodyParts.size() > 5) {
                    suffix = "множество";
                }

                int haveHeads = -1;
                int haveLimbs = -1;
                int index = 0;
                for (BodyPart part : Room.this.bodyParts) {
                    if (part instanceof Head) {
                        haveHeads = index;
                    } else if (part instanceof Limb) {
                        haveLimbs = index;
                    }
                }

                String items = "";
                if (haveHeads != -1) {
                    Head head = (Head) Room.this.bodyParts.get(haveHeads);
                    items = head.toString() + " на " + head.neck.toString() + " шеях";
                    items += " все эти головы " + head.getRotation() + " ";
                }
                if (haveLimbs != -1) {
                    Limb limb = (Limb) Room.this.bodyParts.get(haveLimbs);
                    items += " " + limb.toString();
                }
                return "в помещении " + suffix + " " + items;
            }
        }

        return new RoomInspection();
    }
}
