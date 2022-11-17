package items;

import human.Human;

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

    public boolean equals(Door obj) {
        return this.direcion == obj.direcion;
    }

    @Override
    public String open(Human human) {
        return human.toString() + " распахнула " + this.toString();
    }
}
