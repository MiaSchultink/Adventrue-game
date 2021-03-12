package com.company;

import java.util.ArrayList;

public class Room {
    private String name;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private ArrayList<Item> items;
    private String message;


    public Room(String name, Room north, Room south, Room west, Room east,ArrayList<Item> items, String message) {
        this.name = name;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
        this.items = items;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getNorth() {
        return north;
    }


    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }
    public void addItems(Item item){
        this.items.add(item);
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
