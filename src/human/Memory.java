package human;

public class Memory {
    private String text;

    public Memory(String text) {
        this.text = text;
    }

    String memorize() {
        return this.text;
    }

    String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return text;
    }

    public boolean equals(Memory obj) {
        return this.text == obj.text;
    }

    @Override
    public int hashCode() {
        return this.text.hashCode() + 100;
    }
}
