package com.company;



public class Character {
    private int health;
    private String name;
    private Room room;

    public Character(int health, String name, Room room) {
        this.health = health;
        this.name = name;
        this.room = room;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
