package human;

import items.BodyPart;

public class Head extends BodyPart {
    public Neck neck;
    public Hair hair;

    public Rotation rotation;

    @Override
    public String toString() {
        if (isChoppedOff)
            return "отрубленная голова";
        return "голова";
    }

    public class Rotation {
        private String direction;

        Rotation(String direction) {
            this.direction = direction;
        }

        public String getDirection() {
            return this.direction;
        }

        public void rotate(String newDirection) {
            this.direction = newDirection;
        }
    }

    public static class Hair {
        public Density density;

        Hair(Density density) {
            this.density = density;
        }

        public String comb() {
            return "расчесывает волосы";
        }
    }

    public class Neck {
        public boolean isLong;

        public Fatness fatness;

        Neck(boolean isLong, Fatness fatness) {
            this.isLong = isLong;
            this.fatness = fatness;
        }

        @Override
        public String toString() {
            String object = "";
            if (isLong)
                object += "ужасно длинная ";
            object += this.fatness.toString();
            return object;
        }
    }

    public Head (boolean isChoppedOff, Density hairDensity, boolean isNeckLong, Fatness neckFatness) {
        this.isChoppedOff = isChoppedOff;
        this.hair = new Hair(hairDensity);
        this.neck = new Neck(isNeckLong, neckFatness);
        this.rotation = new Rotation("к стене");
    }

    public String getRotation() {
        return  "повернуты " + this.rotation.getDirection();
    }

    public String lookAt() {
        return "голова глазеет";
    }
}
