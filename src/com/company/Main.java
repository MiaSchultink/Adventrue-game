package com.company;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean running = true;
        Scanner command = new Scanner(System.in);


        System.out.println("Please enter your name");
        String name = command.nextLine();
        System.out.println("Hello, "+ name);

        Room basement= new Room("basement", null, null, null, null,new ArrayList<Item>(),null);
        basement.setMessage("You are in a dimly lit basement of a large house. There is a note and a water bottle and a flashlight on the table in front of you. There is a stairwell leading south.");
        System.out.println(basement.getMessage());

        Item watterBottle = new Item("water bottle");
        Item note = new Item("note");
        Item flashLight = new Item("flash light");
        Item sword = new Item("sword");
        Item carpet = new Item("carpet");
        Item diningRoomKey=  new Item("key");
        Item spear = new Item("spear");



        Room kitchen = new Room("kitchen",null,null,null,null, new ArrayList<Item>(),null);
        Room diningRoom = new Room("dining room",null,null,null,null,new ArrayList<Item>(),null);
        Room gameRoom = new Room("gaming room", null,null,null,null, new ArrayList<Item>(), null);

        Character player = new Character(100, name,basement, new ArrayList<Item>(),null);
        Character monster1 = new Character(80,"the fanged man",gameRoom,new ArrayList<Item>(),null);
        Character cat  =  new Character(50,"mittens",kitchen,null,null);


        basement.setNorth(kitchen);
        basement.addItems(watterBottle);
        basement.addItems(note);
        basement.addItems(flashLight);


        kitchen.setSouth(basement);
        kitchen.setWest(diningRoom);
        kitchen.addItems(sword);
        kitchen.addItems(carpet);
        kitchen.addItems(diningRoomKey);
        kitchen.setMessage("There is a cat here, it has nice orange fur. If you pet the cat he might become your friend. There is also a sward here.");

        diningRoom.setEast(kitchen);

        Room possibleRoom;



        while (running) {



            switch (command.nextLine()) {
                case "start":

                    break;


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
                  ArrayList<Item> roomItems = player.getRoom().getItems();
                  if(!roomItems.isEmpty()) {
                      for (int counter = 0; counter < roomItems.size(); counter++)
                          System.out.println(roomItems.get(counter).getName());
                  }
                  break;

                case "pocket":
                    ArrayList<Item> itemBag = player.getItems();
                    if(!itemBag.isEmpty()) {
                        for (int i = 0; i < itemBag.size(); i++) {
                            System.out.println(itemBag.get(i).getName());
                        }
                    }
                    break;

                case "walk south":
                     possibleRoom = player.getRoom().getSouth();
                    if(possibleRoom!=null){
                        player.setRoom(possibleRoom);
                        System.out.println("You are now in "+ player.getRoom().getName());
                    }
                    else{
                        System.out.println("You cant go that way");
                    }
                    break;

                case "walk east":
                    possibleRoom = player.getRoom().getEast();
                    if(possibleRoom!=null){
                        player.setRoom(possibleRoom);
                        System.out.println("You are now in "+ player.getRoom().getName());
                    }
                    else{
                        System.out.println("You cant go that way");
                    }
                    break;

                case "walk west":
                    possibleRoom = player.getRoom().getWest();
                    if(possibleRoom!=null){
                        player.setRoom(possibleRoom);
                        System.out.println("You are now in "+ player.getRoom().getName());
                    }
                    else{
                        System.out.println("You cant go that way");
                    }
                    break;

                case "walk north":
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

                case "pick up water bottle":
                    player.addItem(watterBottle);
                    System.out.println("you have the water bottle");
                    break;

                case "look under carpet":
                    System.out.println("There is a key here");
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
