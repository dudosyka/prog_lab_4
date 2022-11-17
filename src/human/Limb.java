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

    public boolean equals(Limb obj) {
        return this.side == obj.side && this.type == obj.type;
    }

    @Override
    public int hashCode() {
        return this.type.hashCode() + this.side.hashCode();
    }
}
