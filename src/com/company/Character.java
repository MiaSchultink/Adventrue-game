package com.company;


import java.util.ArrayList;

public class Character {
    private int health;
    private String name;
    private Room room;
    private ArrayList<Item> items;
    private Character pet;

    public Character(int health, String name, Room room,ArrayList<Item> items, Character pet) {
        this.health = health;
        this.name = name;
        this.room = room;
        this.items = items;
        this.pet = pet;
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

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
    public void setPet(Character pet){
        this.pet = pet;
    }
    public Character getPet(){
        return pet;
    }

}
