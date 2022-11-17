import human.*;
import items.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Door> doors = new ArrayList<Door>();
        Room hall = new Room(PlaceCondition.DARK, "зал");
        Door doorToHall = new Door(DoorType.OAK, hall);
        doors.add(doorToHall);
        Room livingRoom = new Room(PlaceCondition.DARK, "гостинная", doors);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(livingRoom);
        rooms.add(hall);
        House house = new House(PlaceCondition.DARK, "Дом", rooms);
        Human misa = new Human("Миса", Size.SMALL, Sex.WOMAN, livingRoom);
        misa.remember(new Memory("о том, кто так странно смеялся в " + house.toString()));
        try {
            System.out.println(misa.legStomp(LimbSide.RIGHT));
        } catch (LegNotFoundException e) {
            System.out.println(e.toString());
        }
        System.out.println(misa.doSomethingUntilSomething(func -> misa.doSomethingDoingSomething(byTouch -> misa.byTouch(), sobbing -> misa.sobbing()), beFrozenInFear -> misa.beFrozenInFear()));
        System.out.println(misa.memorize());
        System.out.println(misa.toString() + misa.beNormal() + misa.scarring() + misa.walkBack());
        misa.setOnSearch(doorToHall);
        System.out.println(misa.search() + misa.beMoreScary());
        misa.setOnOpen(doorToHall);
        System.out.println(misa.finallyFound() + misa.open());
    }
}
