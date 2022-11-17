package human;

public enum LimbType {
    LEG("нога", "ногой", "ногу"), ARM("рука", "рукой", "руку");

    private final String name;
    private final String howNotationName;
    private final String whichNotationName;

    LimbType(String name, String howNotationName, String whichNotationName) {
        this.name = name;
        this.howNotationName = howNotationName;
        this.whichNotationName = whichNotationName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String toString(boolean howNotation, boolean whichNotation) {
        if (howNotation)
            return this.howNotationName;
        else if (whichNotation)
            return this.whichNotationName;
        else
            return this.name;
    }
}
