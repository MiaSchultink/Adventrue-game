package com.company;

import java.util.ArrayList;

public class Room {
    private String name;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
   // private ArrayList<Item> items;
    private ItemCollection items;
    private CharacterCollection characters;
    private String message;



    public Room(String name) {
        this.name = name;
        this.items = new ItemCollection();
        this.characters = new CharacterCollection();

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
    public void addItem(Item item){
        this.items.addItem(item);
    }

    public ItemCollection getItems(){
        return items;
    }

    public void viewRoomItems(){
        this.items.look();
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void addCharacter(Character player){
        this.characters.addCharacter(player);
    }
    public void removeCharacter(Character player){
        this.characters.removeCharacter(player);
    }
    public CharacterCollection getCharacters(){
        return characters;
    }

    public void viewCharacters(){
        this.characters.look();
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
