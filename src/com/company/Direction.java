package com.company;

public class Direction {
    private String name;
    private Direction opposite;

    public Direction(String name){
        this.name = name;
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
