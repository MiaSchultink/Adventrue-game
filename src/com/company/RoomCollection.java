package com.company;

import java.util.ArrayList;

public class RoomCollection {
    private ArrayList<Room> roomList;

    public RoomCollection() {
        this.roomList = new ArrayList<Room>();

    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void setRooms(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void god(){
        for(int i=0; i<roomList.size(); i++){
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

    public void walk(Character character, String direction) {
        Room possibleRoom;
        Room currentRoom = character.getRoom();

        switch (direction) {
            case "north":
                possibleRoom = character.getRoom().getNorth();
                if (possibleRoom != null) {
                    currentRoom.setNorth(currentRoom.getNorth());
                    character.setRoom(possibleRoom);
                    //System.out.println("You are in the " + character.getRoom().getName());
                }
//                else {
//                    System.out.println("You can't go that way");
//                }
                break;
            case "south":
                possibleRoom = character.getRoom().getSouth();
                if (possibleRoom != null) {
                    currentRoom.setSouth(currentRoom.getSouth());
                    character.setRoom(possibleRoom);
                    // System.out.println("You are in the "+character.getRoom().getName());
                }
//                else {
//                    System.out.println("You can't go that way");
//                }
                break;
            case "west":
                possibleRoom = character.getRoom().getWest();
                if (possibleRoom != null) {
                    currentRoom.setWest(currentRoom.getWest());
                    character.setRoom(possibleRoom);
                    // System.out.println("You are in the "+character.getRoom().getName());
             }
//                else {
//                  System.out.println("You can't go that way");
//              }
                break;

            case "east":
                possibleRoom = character.getRoom().getEast();
                if (possibleRoom != null) {
                    currentRoom.setEast(currentRoom.getEast());
                    character.setRoom(possibleRoom);
                    //   System.out.println("You are in the "+character.getRoom().getName());
                }
//                else {
//                    System.out.println("You can't go that way");
//                }
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
            //System.out.println(randomDirectionNumber);
            String direction = directions.get(randomDirectionNumber);

            if (monster != null) {
                if (randomNumber > 2) {
                    walk(monster, direction);
                    System.out.println(direction);
                    System.out.println(monster.getName()+" is in "+monster.getRoom().getName());
                }
            }
        }
    }
}


