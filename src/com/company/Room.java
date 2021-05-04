package com.company;

public class Room {
    private String name;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private ItemCollection items;
    private CharacterCollection characters;
    private String message;
    private int shortestDistance;
    private Room previousRoom;


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
   public void typeCheck(String type){
        this.characters.typeCheck(type);
   }

    public int getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(int shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }
}
