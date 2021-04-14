package com.company;

public class Item {
    private String name;
    private int attackDamage;
    private int healthIncrease;
    private int health;
    private String message;

    public Item(String name, int attackDamage, int healthIncrease, int health) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.health = health;
        this.healthIncrease = healthIncrease;
    }

    public String getName() {
        return name;
    }
    public void setAttackDamage(int attackDamage){
      this.attackDamage = attackDamage;
    }
    public int getAttackDamage(){
        return attackDamage;
    }

 public void printItem(Item item){
     System.out.println("name: "+ item.getName()+", health: "+item.getHealth()+" , attackDamage "+item.getAttackDamage()+" ,healing: "+item.getHealthIncrease());
 }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
    public int getHealthIncrease(){
        return healthIncrease;
    }

    public void setHealthIncrease(int healthIncrease){
        this.healthIncrease = healthIncrease;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
