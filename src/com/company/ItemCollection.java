package com.company;

import java.util.ArrayList;

public class ItemCollection {
    private ArrayList<Item> itemList;

    public ItemCollection() {
        this.itemList = new ArrayList<Item>();

    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }

    public Item getPlayerWeapons(){
        Item weapon = new Item("",0,0,0);
        for(int i=0; i<itemList.size(); i++){
            Item item = itemList.get(i);
            if(item.getAttackDamage()!=0){
                weapon=item;
            }
            else{
                weapon=null;
            }
        }
        return weapon;
    }

    public Item collectRequest(String itemName) {
        int index = -1;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (itemName.equals(item.getName())) {
                index = i;
            }
        }
        if (index != -1) {
            Item item = itemList.get(index);
            itemList.remove(index);
            return item;
        } else {
            return null;
        }
    }
    public Item eatRequest(String itemName){
        Item eatItem = new Item("",0,0,0);
        for(int i=0; i<itemList.size(); i++){
            Item item = itemList.get(i);
            if(item.getName().equals(itemName)&&item.getHealthIncrease()>0){
                eatItem=item;
            }
            else{eatItem=null;
            }
        }
        return eatItem;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }


    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public boolean attackRequest(String name) {
        boolean result = false;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (item.getName().equals(name) && (item.getAttackDamage() > 0)) {
                result = true;
            }
        }
        return result;
    }

    public String getAttackItems() {
        String result = "";
        for (int i = 0; i < this.itemList.size(); i++) {
            Item item = this.itemList.get(i);
            int attackDamage = item.getAttackDamage();
            if (attackDamage > 0) {
                result = result + " " + item.getName();
            }
        }
        return result;

    }

    public Item getMonsterWeapon() {
        Item weapon = new Item(null, 0, 0, 0);
        for (int i = 0; i < this.itemList.size(); i++) {
            Item item = this.itemList.get(i);
            int attackDamage = item.getAttackDamage();
            if (attackDamage > 0) {
                weapon = item;
            }
            else{
                weapon=null;
            }
        }
        return weapon;
    }

    public Item use(String itemName) {
        Item result = null;
        for (int i = 0; i < this.itemList.size(); i++) {
            Item item = this.itemList.get(i);

            if (item.getName().equals(itemName)) {
                result = item;
            }
        }
        return result;
    }


    public void look() {
        if (!this.itemList.isEmpty()) {
            for (int i = 0; i < this.itemList.size(); i++) {
               Item item = this.itemList.get(i);
               item.printItem(item);
            }
        }
        else{
            System.out.println("No items here");
        }
    }

    public int countBag(){
        int counter =0;
        for(int i=0; i<itemList.size(); i++){
           counter++;
        }
        return counter;
    }


    public void clean(){
        for(int i=0; i<itemList.size(); i++){
            Item item = itemList.get(i);
            if(item.getHealth()<=0){
                itemList.remove(item);
            }
        }
    }


    public void remove(Item item) {
        this.itemList.remove(item);
    }
}
