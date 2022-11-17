package human;

public enum Size {
    SMALL("Маленькая"), NORMAL("Обычная"), BIG("Большая");

    private final String name;

    private Size(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
