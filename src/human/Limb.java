package human;

public class Limb {
    LimbSide side;
    LimbType type;

    Limb(LimbSide side, LimbType type) {
        this.side = side;
        this.type = type;
    }

    private String eventString(Sex sex) {
        String sexSuffix = "а";
        if (sex == Sex.MAN) {
            sexSuffix = "";
        }
        return sexSuffix+" " + this.side.toString(true) + " " + this.type.toString(true, false);
    }

    String kick(Sex sex) {
        return "ударил"+this.eventString(sex);
    };

    String stomp(Sex sex) {
        return "топнул"+this.eventString(sex);
    };

    String move(Sex sex) {
        return "сдвинул"+this.eventString(sex);
    };

    public String toString(boolean howNotation, boolean whatNotation) {
        return null;
    };
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Limb)) return false;
        Limb limb = (Limb) obj;
        return this.side == limb.side && this.type == limb.type;
    }

    @Override
    public int hashCode() {
        return this.type.hashCode() + this.side.hashCode();
    }
}
