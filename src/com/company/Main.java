package com.company;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.jar.JarOutputStream;

public class Main {

    public static int random(int a, int b){
          int randomNumber = (int)((b-a)*(Math.random())+a);
          return randomNumber;
    }


    public static void attack1(Character player,Character monster) {

        int playerAttackDamage = random(10,15);
        int monsterAttackDamage = random(10,15);
        if (monster != null) {
            player.setHealth(player.getHealth() - playerAttackDamage);
            monster.setHealth(monster.getHealth() - monsterAttackDamage);

            System.out.println(player.getName()+" health " +player.getHealth());
            System.out.println(monster.getName()+ " health " + monster.getHealth());

            if (monster.getHealth() <= 0) {
                System.out.println("You have defeated the monster");
                monster.getRoom().removeCharacter(monster);
            }
        } else {
            System.out.println("There is nothing to attack here");
        }

    }

    public static void attack(Character player, Character monster, String itemName){

    }


    public static void main(String[] args) {
        boolean running = true;


        Scanner command = new Scanner(System.in);


        System.out.println("Please enter your name");
        String name = command.nextLine();
        System.out.println("Hello, " + name);

        ItemCollection gameItems = new ItemCollection();

        Room basement = new Room("basement");
        basement.setMessage("You are in a dimly lit basement of a large house.\nThere is a note, a water bottle and a flashlight on the table in front of you.\nThere is a stairwell leading north.");
        System.out.println(basement.getMessage());

        //items
        Item watterBottle = new Item("water bottle",0);
        Item flashLight = new Item("flash light",0);
        Item note = new Item("note",0);
        Item sword = new Item("sword",20);
        Item diningRoomKey = new Item("key",0);
        Item spear = new Item("spear",15);
        Item baseBallBat =  new Item("baseball bat",20);

        //item settings
        sword.setAttackDamage(20);
        spear.setAttackDamage(15);

        //rooms
        Room kitchen = new Room("kitchen");
        Room diningRoom = new Room("dining room");
        Room gameRoom = new Room("gaming room");
        Room movieTheater = new Room("movie room");
        Room jelloRoom = new Room("jello room");
        Room lounge = new Room("lounge");
        Room bathRoom = new Room("bath room");
        Room creepyLibrary = new Room("creepy library");
        Room potionRoom = new Room("potion room");
        Room climbingWall = new Room("climbing wall room");
        Room natureReserve = new Room("nature reserve");
        Room bedRoom = new Room("bed room");
        Room closet = new Room("closet");
        Room lavaRoom = new Room("nature reserve");
        Room fishTank = new Room("fish tank");
        Room whiteRoom = new Room("white room");
        Room controlRoom = new Room("control room");
        Room finish = new Room("finish");
        Room livingRoom = new Room("living room");


        //characters
        Character player = new Character(100, name, "player", basement, null);
        Character cat = new Character(50, "mittens", "pet", diningRoom, null);

        //monsters
        Character monster1 = new Character(80, "the fanged man", "monster", kitchen, null);
        monster1.addItem(baseBallBat);

        Character testAttackMonster= new Character(80,"test monster","monster",basement,null);

        //basemnt settings
        basement.setNorth(kitchen);

        basement.addItem(watterBottle);
        basement.addItem(note);
        basement.addItem(flashLight);

        //kitchen settings
        kitchen.setEast(diningRoom);
        kitchen.setSouth(basement);



        kitchen.addItem(sword);
        kitchen.addItem(diningRoomKey);
        kitchen.setMessage("There is a cat here, it has nice orange fur. \nIf you pet the cat he might become your friend.\nThere is also a sward here.");
        kitchen.addCharacter(monster1);

        //dining room settings
        diningRoom.setSouth(bedRoom);
        diningRoom.setWest(kitchen);

        //bed room settigns
        bedRoom.setEast(bathRoom);
        bedRoom.setNorth(diningRoom);

        //bath room settings
        bathRoom.setWest(bedRoom);
        bathRoom.setNorth(closet);

        // closet settings
        closet.setSouth(bathRoom);
        closet.setNorth(movieTheater);

        /// movie room settings
        movieTheater.setSouth(closet);
        movieTheater.setWest(livingRoom);

        // living room settings
        livingRoom.setEast(movieTheater);
        livingRoom.setNorth(gameRoom);

        //game room settings
        gameRoom.setSouth(livingRoom);
        gameRoom.setEast(natureReserve);

        //nature reserve settings
        natureReserve.setWest(gameRoom);
        natureReserve.setNorth(jelloRoom);

        //jello room settings
        jelloRoom.setSouth(natureReserve);
        jelloRoom.setWest(creepyLibrary);

        // creepy library settings
        creepyLibrary.setEast(jelloRoom);
        creepyLibrary.setSouth(whiteRoom);

        //white room settings
        whiteRoom.setWest(controlRoom);
        whiteRoom.setNorth(creepyLibrary);

        //control room settings
        controlRoom.setEast(whiteRoom);
        controlRoom.setSouth(finish);


        Room possibleRoom;



        while (running) {
           // System.out.println("New round");



         //   System.out.println("After cmd");

            if (player.getHealth() <= 0) {
                running = false;
                System.out.println("Oh no looks like you have died");
            }

            Character monster = player.getRoom().getCharacters().typeCheck("monster");
            if(monster!=null){
               int randomNumber= random(0,10);
               if(randomNumber<4){
                   attack(monster,player,null);
               }

            }
            String[] inputCommands = command.nextLine().split(" ", 2);

            switch (inputCommands[0]) {

                case "health":
                    System.out.println("your current health = " + player.getHealth());
                    break;

                case "name":
                    System.out.println("I remember your name, it is " + player.getName());
                    break;

                case "where":
                    System.out.println("You are in the " + player.getRoom().getName());
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
                    switch (inputCommands[1]) {
                        case "east":
                            possibleRoom = player.getRoom().getEast();
                            if (possibleRoom != null) {
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in " + player.getRoom().getName());
                            } else {
                                System.out.println("You cant go that way");
                            }
                            break;

                        case "south":
                            possibleRoom = player.getRoom().getSouth();
                            if (possibleRoom != null) {
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in " + player.getRoom().getName());
                            } else {
                                System.out.println("You cant go that way");
                            }
                            break;

                        case "west":
                            possibleRoom = player.getRoom().getWest();
                            if (possibleRoom != null) {
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in " + player.getRoom().getName());
                            } else {
                                System.out.println("You cant go that way");
                            }
                            break;

                        case "north":
                            possibleRoom = player.getRoom().getNorth();
                            if (possibleRoom != null) {
                                player.setRoom(possibleRoom);
                                System.out.println("You are now in " + player.getRoom().getName());
                                System.out.println(player.getRoom().getMessage());
                            } else {
                                System.out.println("You cant go that way");
                            }
                            break;

                        default:
                            System.out.println("I don't understand that");
                            break;
                    }
                    break;


                case "collect":
                    Item item = player.getRoom().getItems().collectRequest(inputCommands[1]);
                    if (item != null) {
                        player.addItem(item);
                        System.out.println("you have the " + item.getName());
                    } else {
                        System.out.println("That item does not exist, or is already in your item bag");
                    }
                    break;

                case "drop":
                    Item itemRemoved = player.getPocket().collectRequest(inputCommands[1]);
                    if (itemRemoved != null) {
                        player.removeItem(itemRemoved);
                        System.out.println("you have dropped the " + itemRemoved.getName());
                    }
                    break;


                case "attack":
                String attackItemNames = player.getPocket().getAttackItems();
                if(!attackItemNames.equals("")){
                    System.out.println("What do you want to attack with?");
                    System.out.println("You can attack with: "+attackItemNames);
                }
                else{
                    System.out.println("You don't have any items you can use to attack");
                }
                String itemAttack = command.nextLine();
                boolean  itemCheck = player.getPocket().attackRequest(itemAttack);

              if(itemCheck) {
                  System.out.println("You are going to attack with the " + itemAttack);
              }
              else {
                  System.out.println("Did you make a typo? not sure if this item can be used to attack");
              }
                break;

                case "quit":
                    System.out.println("Thanks for playing, " + player.getName() + "!");
                    running = false;
                    break;


                default:
                    System.out.println("I don't understand that");
                    break;
            }
         //   System.out.println("After round");

        }
        command.close();
    }

}