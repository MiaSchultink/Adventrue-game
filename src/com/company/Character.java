package com.company;


public class Character {
    private int health;
    private String name;
    private Room room;
    private ItemCollection pocket;
    private Character pet;
    private String type;
    private CharacterCollection characterBag;

    public Character(int health, String name, String type, Room room) {
        this.health = health;
        this.name = name;
        this.room = room;
        this.type = type;
        this.pocket = new ItemCollection();
        this.characterBag = new CharacterCollection();
    }
public void addCharacter(Character character){
        this.characterBag.addCharacter(character);
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

    public void addItem(Item item) {
        this.pocket.addItem(item);
    }

    public void removeItem(Item item) {
        this.pocket.removeItem(item);
    }
    public int eat(Item item){
        int increase  = item.getHealthIncrease();
         int health = this.health+increase;
            this.pocket.removeItem(item);
            return health;
        }


    public void viewPocket() {
        pocket.look();
    }

    public ItemCollection getPocket() {
        return pocket;
    }

    public void printCharacter(Character character){
        System.out.println("name: "+ character.getName()+", type: "+character.getType()+ ", health: "+character.getHealth());
    }

    public void setPet(Character pet) {
        this.pet = pet;
    }

    public Character getPet() {
        return pet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CharacterCollection getCharacterBag() {
        return characterBag;
    }

    public void viewCharacters(){
        this.characterBag.look();
    }
    public void typeCheck(String characterType){
        this.characterBag.typeCheck(characterType);
    }

    public void setCharacterBag(CharacterCollection characterBag) {
        this.characterBag = characterBag;
    }
}

