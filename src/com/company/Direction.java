package com.company;

public class Direction {
    private String name;
    private Direction opposite;
    private Room north;
    private Room east;
    private Room west;
    private Room south;


    public Direction(String name){
        this.name = name;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getOpposite() {
        return opposite;
    }

    public void setOpposite(Direction opposite) {
        this.opposite = opposite;
    }
}
