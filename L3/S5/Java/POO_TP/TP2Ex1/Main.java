package TP2Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        Door defaultDoor = new Door();
        AutoLockDoor autoLockDoor = new AutoLockDoor();
        SecretCodeDoor secretCodeDoor = new SecretCodeDoor();
        ClosedDoor closedDoor = new ClosedDoor();
        List<Door> doors = new ArrayList<>();

        doors.add(defaultDoor);
        doors.add(secretCodeDoor);
        doors.add(closedDoor);
        doors.add(autoLockDoor);


        defaultDoor.open();
        autoLockDoor.open();
        closedDoor.open();

        System.out.println(defaultDoor.toString());

        System.out.println((long) doors.size());

        System.out.println(doors.stream()
                .filter(door -> door.getClass().getSimpleName().equals("AutoLockDoor"))
                .filter(door -> ((AutoLockDoor) door).isLocked())
                .count());

        List<Door> secret = doors.stream()
                .filter(door -> door.getClass().getSimpleName().equals("SecretCodeDoor"))
                .filter(door -> !door.getStatus())
                .collect(Collectors.toList());
        System.out.println(secret.toString());

        doors.stream()
                .filter(door -> door.isOpen)
                .forEach(door -> System.out.println(door.toString()));
    }
}
