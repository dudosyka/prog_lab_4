package human;

public class LegNotFoundException extends Exception {
    Human human;
    LimbSide limbSide;

    LegNotFoundException(Human human, LimbSide limbSide) {
        this.human = human;
        this.limbSide = limbSide;
    }

    @Override
    public String toString() {
        return "У " + human.toString() + " не найдена " + limbSide.toString() + " нога";
    }

    public boolean equals(LegNotFoundException obj) {
        return (this.human == obj.human && this.limbSide == obj.limbSide);
    }

    @Override
    public int hashCode() {
        return this.human.hashCode() + this.limbSide.hashCode();
    }
}
