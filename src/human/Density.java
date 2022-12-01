package human;

public enum Density {
    SUPER_THICK("нкобыкновенно густые"), THICK("густые"), THIN("редкие");

    private final String name;

    Density(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
