package com.company;

import java.util.ArrayList;

public class ItemCollection {
    private ArrayList<Item> itemList;

    public ItemCollection() {
        this.itemList = new ArrayList<>();
    }


    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void look(){
        if(!this.itemList.isEmpty()){
            for (int i = 0; i < this.itemList.size(); i++) {
                System.out.println(this.itemList.get(i).getName());
            }
        }
    }
    public void remove(Item item){
        this.itemList.remove(item);
    }
}
