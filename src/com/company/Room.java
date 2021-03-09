package com.company;

public class Room {
    private String name;
    private Room north;
    private Room south;
    private Room west;
    private Room east;

    public Room(String name, Room north, Room south, Room west, Room east) {
        this.name = name;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
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

}
