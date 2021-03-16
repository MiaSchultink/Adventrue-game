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
    public void removeItem(Item item){
        this.itemList.remove(item);
    }

    public Item collectRequest(String itemName) {
        int index = -1;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (itemName.equals(item.getName()))
            {
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

    public void look() {
        if (!this.itemList.isEmpty()) {
            for (int i = 0; i < this.itemList.size(); i++) {
                System.out.println(this.itemList.get(i).getName());
            }
        }
    }

    public void remove(Item item) {
        this.itemList.remove(item);
    }
}
