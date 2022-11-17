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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LegNotFoundException)) return false;
        LegNotFoundException legNotFoundException = (LegNotFoundException) obj;
        return (this.human == legNotFoundException.human && this.limbSide == legNotFoundException.limbSide);
    }

    @Override
    public int hashCode() {
        return this.human.hashCode() + this.limbSide.hashCode();
    }
}
