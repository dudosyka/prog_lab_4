package items;

import human.Human;
import human.Memory;

public class Door implements Searchable, Openable {
    private Place direcion = null;

    private DoorType doorType;

    public Door(DoorType doorType, Place direcion) {
        this.doorType = doorType;
        this.direcion = direcion;
    }

    @Override
    public String search() {
        if (this.direcion != null)
            return " в поисках двери в " + this.direcion.toString();
        return " в поисках двери ";
    }

    @Override
    public String finallyFound() {
        if (this.direcion != null)
            return " наконец дверь в " + this.direcion.toString() + " найдена!";
        return " наконец дверь найдена";
    }

    @Override
    public String toString() {
        return this.doorType + " дверь в " + this.direcion.toString();
    }

    @Override
    public int hashCode() {
        return this.direcion.hashCode() + 100;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Door)) return false;
        Door door = (Door) obj;
        return this.direcion == door.direcion;
    }

    @Override
    public String open(Human human) {
        return human.toString() + " распахнула " + this.toString();
    }
}
