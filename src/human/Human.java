package human;

import items.*;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.function.Function;

public class Human implements Emotionable, Moveable {
    String name;
    Size size;
    Sex sex;
    Searchable onSearch;
    Openable onOpen;
    Place place;
    ArrayList<Limb> limbs = new ArrayList<Limb>();
    ArrayList<Memory> memories = new ArrayList<Memory>();

    public Human(String name, Size size, Sex sex, Place place) {
        this.name = name;
        this.size = size;
        this.sex = sex;
        this.place = place;
        this.limbs.add(new Limb(LimbSide.RIGHT, LimbType.LEG));
        this.limbs.add(new Limb(LimbSide.LEFT, LimbType.LEG));
        this.limbs.add(new Limb(LimbSide.RIGHT, LimbType.ARM));
        this.limbs.add(new Limb(LimbSide.LEFT, LimbType.ARM));
    }

    public Human(String name, Size size, Sex sex, Place place, ArrayList<Limb> limbs) {
        this(name, size, sex, place);
        this.limbs = limbs;
    }

    public Human(String name, Size size, Sex sex, Place place, ArrayList<Limb> limbs, ArrayList<Memory> memories) {
        this(name, size, sex, place, limbs);
        this.memories = memories;
    }

    @Override
    public String toString() {
        return this.size + " " + this.name;
    }

    public boolean equals(Human obj) {
        return (obj.name == this.name && obj.size == this.size && obj.sex == this.sex);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.size.hashCode();
    }

    @Override
    public String beFrozenInFear() {
        return " застывает от страха";
    }

    @Override
    public String beHappy() {
        return " испытывает счастье";
    }

    @Override
    public String beNormal() {
        return " больше не плачет";
    }

    @Override
    public String beMoreScary() {
        return " пугается всё больше и больше";
    }

    @Override
    public String sobbing() {
        return " всхлипывая";
    }

    @Override
    public String scarring() {
        return " испугано";
    }

    public void remember(Memory memory) {
        this.memories.add(memory);
    }

    public String memorize() {
        Memory memory = this.memories.get(this.memories.size() - 1);
        this.memories.remove(this.memories.size() - 1);
        return this.toString() + " вспомнила " + memory.getText();
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
        return " передвигается бегом";
    }

    @Override
    public String byTouch() {
        if (this.place.getPlaceCondition() == PlaceCondition.DARK)
            return " передвигается на ощупь в темноте";
        return " передвигается на ощупь";
    }

    public String walkBack() {
        return " пятится";
    }

    public void setOnSearch(Searchable onSearch) {
        this.onSearch = onSearch;
    }

    public String search() {
        return this.toString() + " шарила и шарила " + this.onSearch.search();
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
        return doSomething.apply(null) + " пока не " + untilSomething.apply(null);
    }

}
