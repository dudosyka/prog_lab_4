package human;

public enum LimbType {
    LEG("нога", "ногой", "ногу", "ноге"), ARM("рука", "рукой", "руку", "руке");

    private final String name;
    private final String howNotationName;
    private final String whichNotationName;
    private final String toNotationName;

    LimbType(String name, String howNotationName, String whichNotationName, String toNotationName) {
        this.name = name;
        this.howNotationName = howNotationName;
        this.whichNotationName = whichNotationName;
        this.toNotationName = toNotationName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String toString(boolean howNotation, boolean whichNotation, boolean toNotation) {
        if (howNotation)
            return this.howNotationName;
        else if (whichNotation)
            return this.whichNotationName;
        else if (toNotation)
            return this.toNotationName;
        else
            return this.name;
    }
}
