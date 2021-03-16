package com.company;

import java.util.ArrayList;

public class CharacterCollection {
    private ArrayList<Character> characterList;

    public CharacterCollection(){
        this.characterList = new ArrayList<Character>();
    }
    public void look() {
        if (!this.characterList.isEmpty()) {
            for (int i = 0; i < this.characterList.size(); i++) {
                System.out.println(this.characterList.get(i).getName());
            }
        }
    }
    public void addCharacter(Character player){
        this.characterList.add(player);
    }
    public void removeCharacter(Character player){
        this.characterList.remove(player);
    }
}

