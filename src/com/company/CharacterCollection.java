package com.company;

import java.util.ArrayList;

public class CharacterCollection {
    private ArrayList<Character> characterList;

    public CharacterCollection(){
        this.characterList = new ArrayList<Character>();
    }

    public Character typeCheck(String type){
        int index = -1;

        for (int i = 0; i < characterList.size(); i++) {
             String characterType = characterList.get(i).getType();
            if (characterType.equals(type))
            {
                index = i;
            }
        }
        if (index != -1) {
            return characterList.get(index);
        }
        else {
            return null;
        }
    }

    public void look() {
        if (!this.characterList.isEmpty()) {
            for (int i = 0; i < this.characterList.size(); i++) {
                System.out.println(this.characterList.get(i).getName()+" "+this.characterList.get(i).getType());
            }
        }
        else{
            System.out.println("there are no characters in this room");
        }
    }


    public void addCharacter(Character player){
        this.characterList.add(player);
    }
    public void removeCharacter(Character player){
        this.characterList.remove(player);
    }
}

