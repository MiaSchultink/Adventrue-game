package com.company;

import java.util.ArrayList;

public class Item {
    private String name;
    private int attackDamage;

    public Item(String name, int attackDamage) {
        this.name = name;
        this.attackDamage = attackDamage;
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




}
