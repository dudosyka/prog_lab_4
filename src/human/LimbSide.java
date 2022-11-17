package human;

public enum LimbSide {
    LEFT("Левая", "Левой"),
    RIGHT("Правая", "Правой");

    private final String name;
    private final String whichNotationName;

    private LimbSide(String name, String whichNotationName) {
        this.name = name;
        this.whichNotationName = whichNotationName;
    }

    public String toString() {
        return this.name;
    }

    public String toString(boolean whichNotation) {
        if (whichNotation)
            return this.whichNotationName;
        else
            return this.name;
    }
}
