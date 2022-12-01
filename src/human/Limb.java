package human;

import items.BodyPart;

import java.util.ArrayList;

public class Limb extends BodyPart {
    private class Finger {
        public String name;
        public Finger(String name) {
            this.name = name;
        }
        private String move() {
            return "шевелится " + this.name + " палец на " + side.toString(true) + " " + type.toString(false, false, true);
        }
    }
    LimbSide side;
    LimbType type;
    ArrayList<Finger> fingers = new ArrayList<Finger>();

    Limb(LimbSide side, LimbType type) {
        this.side = side;
        this.type = type;
        this.fingers.add(new Finger("первый"));
        this.fingers.add(new Finger("второй"));
        this.fingers.add(new Finger("третий"));
        this.fingers.add(new Finger("четвертый"));
        this.fingers.add(new Finger("пятый"));
    }

    private String eventString(Sex sex) {
        String sexSuffix = "а";
        if (sex == Sex.MAN) {
            sexSuffix = "";
        }
        return sexSuffix+" " + this.side.toString(true) + " " + this.type.toString(true, false, false);
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
        if (this.isChoppedOff)
            return "отрубленные конечности";
        else
            return this.type.toString() + " " + this.side.toString();
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

    public void moveFingers() {
        this.fingers.forEach(finger -> {
            System.out.println(finger.move() + " ");
        });
    }
}
