package com.company;

import java.util.ArrayList;

public class CharacterCollection {
    private ArrayList<Character> characterList;

    public CharacterCollection(){
        this.characterList = new ArrayList<Character>();
    }


    public Character collectRequest(String characterName){
        int index = -1;
        for (int i = 0; i < characterList.size(); i++) {
            Character character = characterList.get(i);
            if (characterName.equals(character.getName())) {
                index = i;
            }
        }
        if (index != -1) {
            Character character = characterList.get(index);
           characterList.remove(index);
            return character;
        } else {
            return null;
        }

    }

    public Character monsterAttackRequest(String monsterName){
        Character character= new Character(0,"","",null);
        for(int i=0; i<characterList.size(); i++){
            Character possibleCharacter = characterList.get(i);
            if (monsterName.equals(possibleCharacter.getName())&&possibleCharacter.characterTypeCheck("monster")){
               character = possibleCharacter;
            }
            else{
                character=null;
            }

        }
       return character;
    }

    public Character talkRequest(String characterName){
        Character character= new Character(0,"","",null);
        for(int i=0; i<characterList.size(); i++){
            Character possibleCharacter = characterList.get(i);
            if((possibleCharacter.getName().equals(characterName))&&(possibleCharacter.getType().equals("person"))){
                character=possibleCharacter;
            }
            else{
                character=null;
            }
        }
        return character;
    }

    public void clean(){
        for(int i=0; i<characterList.size(); i++){
            Character character= characterList.get(i);
            if(character.getHealth()<=0){
                characterList.remove(character);
            }
        }
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
               Character character = this.characterList.get(i);
               character.printCharacter(character);
            }
        }
        else{
            System.out.println("No characters in this room");
        }
    }


    public void addCharacter(Character player){
        this.characterList.add(player);
    }
    public void removeCharacter(Character player){
        this.characterList.remove(player);
    }

}

