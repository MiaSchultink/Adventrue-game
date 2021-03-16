package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean running = true;
        Scanner command = new Scanner(System.in);


        System.out.println("Please enter your name");
        String name = command.nextLine();
        System.out.println("Hello, "+ name);

       ItemCollection gameItems =  new ItemCollection();

        Room basement= new Room("basement", null, null, null, null,null);
        basement.setMessage("You are in a dimly lit basement of a large house.\nThere is a note, a water bottle and a flashlight on the table in front of you.\nThere is a stairwell leading south.");
        System.out.println(basement.getMessage());

        //items
        Item watterBottle = new Item("water bottle");
        Item flashLight = new Item("flash light");
        Item note = new Item("note");
        Item sword = new Item("sword");
        Item carpet = new Item("carpet");
        Item diningRoomKey=  new Item("key");
        Item spear = new Item("spear");

        //rooms
        Room kitchen = new Room("kitchen",null,null,null,null,null);
        Room diningRoom = new Room("dining room",null,null,null,null,null);
        Room gameRoom = new Room("gaming room", null,null,null,null, null);

        //characters
        Character player = new Character(100, name, basement,null);
        Character monster1 = new Character(80,"the fanged man",kitchen,null);
        Character cat  =  new Character(50,"mittens",diningRoom,null);

        //player settings


        //basement settings
        basement.setNorth(kitchen);
        basement.addItem(watterBottle);
        basement.addItem(note);
        basement.addItem(flashLight);

        //kitchen settings
        kitchen.setSouth(basement);
        kitchen.setWest(diningRoom);
        kitchen.addItem(sword);
        kitchen.addItem(diningRoomKey);
        kitchen.setMessage("There is a cat here, it has nice orange fur. If you pet the cat he might become your friend. There is also a sward here.");
        kitchen.addCharacter(monster1);

        //dining room settings
        diningRoom.setEast(kitchen);
        diningRoom.addCharacter(cat);

        Room possibleRoom;

        while (running) {

            String [] inputCommands = command.nextLine().split(" ", 2);


            switch (inputCommands[0]) {

                case "health":
                    System.out.println("your current health = " + player.getHealth());
                    break;

                case "name":
                    System.out.println( "I remember your name, it is "+ player.getName());
                    break;

                case "where":
                    System.out.println("You are in the "+ player.getRoom().getName());
                    break;

                case "look":
                    player.getRoom().viewRoomItems();
                  break;

                case "character":
                    player.getRoom().viewCharacters();
                    break;

                case "pocket":
                  player.viewPocket();
                    break;

                case "walk":
                    switch (inputCommands[1]){
                        case "east":possibleRoom = player.getRoom().getEast();
                            if(possibleRoom!=null){
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in "+ player.getRoom().getName());
                            }
                            else{
                                System.out.println("You cant go that way");
                            }
                            break;

                        case "south": possibleRoom = player.getRoom().getSouth();
                           if(possibleRoom!=null){
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in "+ player.getRoom().getName());
                            }
                           else{
                              System.out.println("You cant go that way");
                          }
                            break;

                        case "west":
                            possibleRoom = player.getRoom().getWest();
                            if(possibleRoom!=null){
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in "+ player.getRoom().getName());
                            }
                            else{
                                System.out.println("You cant go that way");
                            }

                        case "north":
                            possibleRoom = player.getRoom().getNorth();
                            if(possibleRoom!=null){
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in "+ player.getRoom().getName());
                                System.out.println(player.getRoom().getMessage());
                            }
                            else{
                                System.out.println("You cant go that way");
                            }
                            break;

                        default:
                            System.out.println("I don't understand that");
                            break;
                    }
                    break;


                case"collect":
                  Item item = player.getRoom().getItems().collectRequest(inputCommands[1]);
                    if(item !=null){
                        player.addItem(item);
                        System.out.println("you have the "+item.getName());
                    }
                    else{
                        System.out.println("That item does not exist, or is already in your item bag");
                    }
                    break;

                case "drop":
                    Item itemRemoved = player.getPocket().collectRequest(inputCommands[1]);
                    if(itemRemoved !=null){
                        player.removeItem(itemRemoved);
                        System.out.println("you have dropped the "+itemRemoved.getName());
                    }
                    break;


                case "attack":
                    if(player.getRoom().viewCharacters();) {
                        player.setHealth(player.getHealth() - 10);
                        monster1.setHealth(monster1.getHealth() - 15);
                        System.out.println(player.getHealth());
                        if (player.getHealth() <= 0) {
                            System.out.println("Sorry you have died");
                            running = false;
                        }
                        if (monster1.getHealth() <= 0) {
                            System.out.println("You have defeated the monster");
                        }
                    }
                    else{
                        System.out.println("There is nothing to attack");}
                    break;


                case "quit":
                    System.out.println("Thanks for playing, "+player.getName()+"!");
                    running = false;
                    break;


                default:
                    System.out.println("I don't understand that");
                    break;
            }
        }
        command.close();
    }

}