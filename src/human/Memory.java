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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Memory)) return false;
        Memory memory = (Memory) obj;
        return this.text == memory.text;
    }

    @Override
    public int hashCode() {
        return this.text.hashCode() + 100;
    }
}
