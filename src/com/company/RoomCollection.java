package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class RoomCollection {
    private ArrayList<Room> roomList;
    private ArrayList<Room> path;
    private boolean out;

    public RoomCollection() {
        this.roomList = new ArrayList<Room>();
        this.out = false;
        this.path = new ArrayList<Room>();

    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public ArrayList<Room> shuffleRooms(int a, int b) {
        return roomList;
    }

    public void setRooms(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public void lookPath() {
        for (int i = 0; i < path.size(); i++) {
            Room room = path.get(i);
            System.out.println(room.getName());
        }
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void relocate(Character character, String roomName) {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            if (room.getName().equals(roomName)) {
                character.setRoom(room);
            }
        }
    }


    public void god() {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            System.out.println("--------------------------");
            System.out.println(room.getName());
            room.viewCharacters();
            room.viewRoomItems();
            System.out.println("--------------------------");
        }
    }

    public int randomNumber(int a, int b) {
        int randomNumber = (int) ((b - a) * (Math.random()) + a);
        return randomNumber;
    }

    public int randomIndex() {
        int index = (int) (Math.random() * roomList.size());
        return index;
    }

    public ArrayList<Room> shuffle() {
        Collections.shuffle(roomList);
        return roomList;
    }

    public Room randomRoom() {
        int index = randomIndex();
        Room randomRoom = roomList.get(index);
        return randomRoom;
    }

    public boolean pathCheck(Room room) {
        boolean check = true;
        for (int i = 0; i < path.size(); i++) {
            if (path.contains(room)) {
                check = false;
            } else {
                check = true;
            }
        }
        return check;
    }


    public void walk(Character character, String direction) {
        Room possibleRoom;
        Room currentRoom = character.getRoom();

        switch (direction) {
            case "north":
                possibleRoom = character.getRoom().getNorth();
                if (possibleRoom != null) {
                    currentRoom.setNorth(currentRoom.getNorth());
                    character.setRoom(possibleRoom);

                }
                break;
            case "south":
                possibleRoom = character.getRoom().getSouth();
                if (possibleRoom != null) {
                    currentRoom.setSouth(currentRoom.getSouth());
                    character.setRoom(possibleRoom);
                }
                break;
            case "west":
                possibleRoom = character.getRoom().getWest();
                if (possibleRoom != null) {
                    currentRoom.setWest(currentRoom.getWest());
                    character.setRoom(possibleRoom);

                }
                break;
            case "east":
                possibleRoom = character.getRoom().getEast();
                if (possibleRoom != null) {
                    currentRoom.setEast(currentRoom.getEast());
                    character.setRoom(possibleRoom);
                }
                break;
            default:
                System.out.println("I don't understand that direction");
                break;
        }
    }


    public void checkMonster() {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            int randomNumber = randomNumber(0, 6);
            Character monster = room.getCharacters().typeCheck("monster");

            ArrayList<String> directions = new ArrayList<String>();
            directions.add("north");
            directions.add("west");
            directions.add("east");
            directions.add("south");

            int randomDirectionNumber = randomNumber(0, (directions.size()));
            String direction = directions.get(randomDirectionNumber);

            if (monster != null) {
                if (randomNumber > 2) {
                    walk(monster, direction);
                }
            }
        }
    }
}


