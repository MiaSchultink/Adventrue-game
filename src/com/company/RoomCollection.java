package com.company;

import javax.print.attribute.standard.Copies;
import java.util.ArrayList;
import java.util.Collections;

public class RoomCollection {
    private ArrayList<Room> roomList;
    private ArrayList<Room> path;
    private boolean out;
    private ArrayList<Room> visitedRooms;
    private ArrayList<Room> unvisitedRooms;
    private ArrayList<Room> unvisitedNeighbors;


    public RoomCollection() {
        this.roomList = new ArrayList<Room>();
        this.out = false;
        this.path = new ArrayList<Room>();
        this.visitedRooms = new ArrayList<>();
        this.unvisitedRooms = new ArrayList<>();
        this.unvisitedNeighbors = new ArrayList<>();

    }

    public ArrayList<Room> getVisitedRooms() {
        return visitedRooms;
    }

    public void setVisitedRooms(ArrayList<Room> visitedRooms) {
        this.visitedRooms = visitedRooms;
    }

    public ArrayList<Room> getUnvisitedRooms() {
        return unvisitedRooms;
    }

    public void setUnvisitedRooms(ArrayList<Room> unvisitedRooms) {
        this.unvisitedRooms = unvisitedRooms;
    }

    public ArrayList<Room> getUnvisitedNeighbors() {
        return unvisitedNeighbors;
    }

    public void setUnvisitedNeighbors(ArrayList<Room> unvisitedNeighbors) {
        this.unvisitedNeighbors = unvisitedNeighbors;
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

    public int roomCounter(){
        int counter =0;
        for(int i=0; i<roomList.size(); i++){
           counter=i;
        }
        return counter;
    }

    public void setDistanceFromStart(Room startRoom){
        for(int i=0; i<roomList.size(); i++){
            Room room = roomList.get(i);
            if(room==startRoom){
                room.setShortestDistanceFromStart(0);
               // System.out.println(room.getName()+" "+" "+room.getShortestDistanceStart());
            }
            else{
                room.setShortestDistanceFromStart(10000);
                //System.out.println(room.getName()+" "+" "+room.getShortestDistanceStart());
            }
        }
    }

    public void printVisited(){
        for(int i=0; i<visitedRooms.size(); i++){
            Room room = visitedRooms.get(i);
            System.out.println("visited "+room.getName());
        }
    }
   public void printUnvisited(){
      for(int i=0; i<unvisitedRooms.size(); i++){
          Room room = unvisitedRooms.get(i);
          System.out.println("unvisited "+room.getName());
      }
   }

   public void printDistanceFromStart(){
        for(int i=0; i<roomList.size(); i++){
            Room room= roomList.get(i);
            int shortestDistance = room.getShortestDistanceStart();
            System.out.println(room.getName()+" "+shortestDistance);
        }
   }

   public void printPreviousRoom(){
        for(int i=0; i<roomList.size(); i++){
           Room room = roomList.get(i);
           Room previousRoom = room.getPreviousRoom();
           if(previousRoom==null){
               System.out.println("null");
           }
           else {
               System.out.println("room " + room.getName() + " previous room " + previousRoom.getName());
           }
        }
   }

   public ArrayList<Room> checkNeighbor(Room currentRoom){
        Room roomNorth  = currentRoom.getNorth();
        Room roomSouth = currentRoom.getSouth();
        Room roomEast = currentRoom.getEast();
        Room roomWest = currentRoom.getWest();

        ArrayList<Room> possibleNeighbors = new ArrayList<>();
        possibleNeighbors.add(roomEast);
        possibleNeighbors.add(roomNorth);
        possibleNeighbors.add(roomSouth);
        possibleNeighbors.add(roomWest);

        for(int i=0; i<possibleNeighbors.size(); i++) {
            Room room = possibleNeighbors.get(i);

            if (room != null) {
                if (unvisitedRooms.contains(room)) {
                    unvisitedNeighbors.add(room);
                    System.out.println(room.getName());
                }
            }
        }
     return unvisitedNeighbors;
   }

    public void previousRoom(){
        for(int i=0; i<roomList.size(); i++){
           Room room = roomList.get(i);
           room.setPreviousRoom(null);
//            if(room.getPreviousRoom()==null){
//                System.out.println("null");
//            }
//            else {
//                System.out.println(room.getName() + " " + room.getPreviousRoom().getName());
//            }
        }
    }

    public void printStatus(Room startRoom){
        System.out.println("previous rooms:");
       // previousRoom();
        printPreviousRoom();
        System.out.println("shortest distance from start: ");
       // distanceFromStart(startRoom);
        printDistanceFromStart();
        System.out.println("unvisited");
        printUnvisited();
        System.out.println("visited");
        printVisited();
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


