package human;

import items.*;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.function.Function;

public class Human implements Emotionable, Moveable, Opener {
    public Head head;
    String name;
    Size size;
    Sex sex;
    Searchable onSearch;
    Openable onOpen;
    Place place;
    ArrayList<Limb> limbs = new ArrayList<Limb>();
    ArrayList<Memory> memories = new ArrayList<Memory>();

    public Human(String name, Size size, Sex sex, Place place, Density hairDensity, boolean isNeckLong, Fatness neckFatness) {
        this.name = name;
        this.size = size;
        this.sex = sex;
        this.place = place;
        this.head = new Head(false, hairDensity, isNeckLong, neckFatness);
        this.limbs.add(new Limb(LimbSide.RIGHT, LimbType.LEG));
        this.limbs.add(new Limb(LimbSide.LEFT, LimbType.LEG));
        this.limbs.add(new Limb(LimbSide.RIGHT, LimbType.ARM));
        this.limbs.add(new Limb(LimbSide.LEFT, LimbType.ARM));
    }

    public Human(String name, Size size, Sex sex, Place place, Density hairDensity, boolean isNeckLong, Fatness neckFatness, ArrayList<Limb> limbs) {
        this(name, size, sex, place, hairDensity, isNeckLong, neckFatness);
        this.limbs = limbs;
    }

    public Human(String name, Size size, Sex sex, Place place, Density hairDensity, boolean isNeckLong, Fatness neckFatness, ArrayList<Limb> limbs, ArrayList<Memory> memories) {
        this(name, size, sex, place, hairDensity, isNeckLong, neckFatness, limbs);
        this.memories = memories;
    }

    @Override
    public String toString() {
        return this.size + " " + this.name;
    }

    private interface Status {
        Sex getSex();

        Size getSize();

        String getName();

        Place getLocation();
    }

    public String toString(boolean printSize) {
        return printSize ? this.toString() : this.name;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return (human.name == this.name && human.size == this.size && human.sex == this.sex);
    }

    public Status getStatus() {
        return new Status() {
            @Override
            public Sex getSex() {
                return Human.this.sex;
            }

            @Override
            public Size getSize() {
                return Human.this.size;
            }

            @Override
            public String getName() {
                return Human.this.name;
            }

            @Override
            public Place getLocation() {
                return Human.this.place;
            }
        };
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.size.hashCode();
    }

    @Override
    public String beFrozenInFear() {
        return " ?????????????????? ???? ????????????";
    }

    @Override
    public String beHappy() {
        return " ???????????????????? ??????????????";
    }

    @Override
    public String beNormal() {
        return " ???????????? ???? ????????????";
    }

    @Override
    public String beMoreScary() {
        return " ???????????????? ?????? ???????????? ?? ????????????";
    }

    @Override
    public String sobbing() {
        return " ????????????????????";
    }

    @Override
    public String scarring() {
        return " ????????????????";
    }

    @Override
    public String horrified(String horrifiedFrom) {
        return "?? ?????? ????????, " + horrifiedFrom + " ???????????????????? " + this.toString();
    }

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

    public void remember(String text) {
        this.memories.add(new Memory(text));
    }

    public String memorize() {
        Memory memory = this.memories.get(this.memories.size() - 1);
        this.memories.remove(this.memories.size() - 1);
        return this.toString() + " ?????????????????? " + memory.getText();
    }

    public String legStomp(LimbSide side) throws LegNotFoundException {
        for (Limb el : this.limbs) {
            if (el.type == LimbType.LEG && el.side == side) {
                return this.toString() + " " + el.stomp(this.sex);
            }
        }
        throw new LegNotFoundException(this, side);
    }

    @Override
    public String ran() {
        return " ?????????????????????????? ??????????";
    }

    @Override
    public String byTouch() {
        if (this.place.getPlaceCondition() == PlaceCondition.DARK)
            return " ?????????????????????????? ???? ?????????? ?? ??????????????";
        return " ?????????????????????????? ???? ??????????";
    }

    public String walkBack() {
        return " ??????????????";
    }

    public void setOnSearch(Searchable onSearch) {
        this.onSearch = onSearch;
    }

    public String search() {
        return this.toString() + " ???????????? ?? ???????????? " + this.onSearch.search();
    }

    public String finallyFound() {
        return this.onSearch.finallyFound();
    }

    public void setOnOpen(Openable onOpen) {
        this.onOpen = onOpen;
    }

    public String open() {
        return this.onOpen.open(this);
    }

    public String doSomethingDoingSomething(Function <NullType, String> doSomething, Function <NullType, String> sideDoing) {
        return sideDoing.apply(null) + doSomething.apply(null);
    }

    public String doSomethingUntilSomething(Function <NullType, String> doSomething, Function <NullType, String> untilSomething) {
        return doSomething.apply(null) + " ???????? ???? " + untilSomething.apply(null);
    }

    public String ignore() {
        return this.name + " ???? ????????????????";
    }

    public String failedWithRoom(Room expectedRoom, Room trueRoom) {
        return " ???? ?????????????? " + this.name + " ?????????? ???? ?? " + expectedRoom.toString() + ", ?? ?? " + trueRoom.toString();
    }
}
