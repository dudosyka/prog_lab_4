package human;

public enum Fatness {
    FAT("Толстые"), AVERAGE("Средние"), SKINNY("Худая");

    private final String name;

    Fatness(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
