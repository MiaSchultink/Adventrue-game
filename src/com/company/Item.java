package com.company;

import java.util.ArrayList;

public class Item {
    private String name;
    private int attackDamage;
    private int health;

    public Item(String name, int attackDamage, int health) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.health = health;
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


    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }



}
