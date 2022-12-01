import human.*;
import items.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Door> doors = new ArrayList<Door>();
        ArrayList<BodyPart> bodyParts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Head head = new Head(true, Density.SUPER_THICK, true, Fatness.FAT);
            bodyParts.add(head);
        }
        Room hall = new Room(PlaceCondition.DARK, "зал");
        Room unknown = new Room(PlaceCondition.POORLY_LIGHT, "незнакомая", bodyParts);
        Door doorToHall = new Door(DoorType.OAK, hall);
        doors.add(doorToHall);
        Room livingRoom = new Room(PlaceCondition.DARK, "гостинная", doors, bodyParts);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(livingRoom);
        rooms.add(hall);
        try {
            House house = new House(PlaceCondition.DARK, "Дом", rooms);
            Human misa = new Human("Миса", Size.SMALL, Sex.WOMAN, livingRoom, Density.SUPER_THICK, false, Fatness.FAT);
            Human mumla = new Human("Мюмла", Size.NORMAL, Sex.WOMAN, livingRoom, Density.SUPER_THICK, false, Fatness.FAT);
            Human frekenSnork = new Human("Фрекен снорк", Size.BIG, Sex.WOMAN, livingRoom, Density.SUPER_THICK, false, Fatness.FAT);
            System.out.println(misa.toString(false) + " " + misa.head.hair.comb());
            System.out.println(mumla.toString(false) + " " + mumla.head.hair.comb());
            System.out.println(frekenSnork.toString(false) + " " + frekenSnork.head.hair.comb());
            System.out.println(misa.ignore());
            misa.remember("о том, кто так странно смеялся в " + house.toString());
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
            System.out.println(misa.failedWithRoom(hall, unknown));
            System.out.println(unknown.inspect().getInfo());
            Head head = (Head)bodyParts.get(0);
            System.out.println(misa.horrified(head.lookAt()));
        } catch (EmptyHouseException e) {
            System.out.println(e.getMessage());
        }
    }
}
