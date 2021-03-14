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
       //ItemCollection playerItems =  new ItemCollection();
       //playerItems.setItemList(new ArrayList<Item>());



        Room basement= new Room("basement", null, null, null, null,null);
        basement.setMessage("You are in a dimly lit basement of a large house. There is a note and a water bottle and a flashlight on the table in front of you. There is a stairwell leading south.");
        System.out.println(basement.getMessage());

        //items
        Item watterBottle = new Item("water bottle");
        Item note = new Item("note");
        Item flashLight = new Item("flash light");
        Item sword = new Item("sword");
        Item carpet = new Item("carpet");
        Item diningRoomKey=  new Item("key");
        Item spear = new Item("spear");

        //rooms
        Room kitchen = new Room("kitchen",null,null,null,null/*, new ArrayList<Item>()*/,null);
        Room diningRoom = new Room("dining room",null,null,null,null/*,new ArrayList<Item>()*/,null);
        Room gameRoom = new Room("gaming room", null,null,null,null/*, new ArrayList<Item>()*/, null);

        //characters
        Character player = new Character(100, name, basement,null);
        Character monster1 = new Character(80,"the fanged man",gameRoom/*,new ArrayList<Item>()*/,null);
        Character cat  =  new Character(50,"mittens",kitchen/*,null*/,null);

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

        //dining room settings
        diningRoom.setEast(kitchen);

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
                            break;

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
                    }
                    break;

                case "collect":
                    switch(inputCommands[1]){
                        case "water":
                            player.addItem(watterBottle);
                            System.out.println("You have the bottle");
                            break;

                        default:
                            System.out.println("You can't do that");
                            break;
                    }
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
