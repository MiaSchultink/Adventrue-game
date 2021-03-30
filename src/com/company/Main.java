package com.company;
import java.util.Scanner;


public class Main {

    public static int random(int a, int b) {
        int randomNumber = (int) ((b - a) * (Math.random()) + a);
        return randomNumber;
    }

    public static void attack(Character attacker, Character target, Item attackerWeapon, Item targetWeapon) {

//setting attacker and target health
        attacker.setHealth(attacker.getHealth());
        target.setHealth(target.getHealth());

        //setting weapons health
        attackerWeapon.setHealth(attackerWeapon.getHealth());
        targetWeapon.setHealth(targetWeapon.getHealth());

 //getting existing attacker and target heath
        int attackerHealth = attacker.getHealth();
        int targetHealth = target.getHealth();
        //getting weapon attack damage

        int attackerAttackDamage = attackerWeapon.getAttackDamage();
        int targetAttackDamage =  targetWeapon.getAttackDamage();

      //getting weapon health
        int attackerWeaponHealth = attackerWeapon.getHealth();
        int targetWeaponHealth = targetWeapon.getHealth();

        //creating percentage of weapon health decrease
        int attackerWeaponDecrease =(int) Math.round(1 * 100.0/attackerWeaponHealth);
        int targetWeaponDecrease = (int)Math.round(1 * 100.0/targetWeaponHealth);

        //target during attack
        targetHealth = targetHealth - attackerAttackDamage;
        target.setHealth(targetHealth);
        System.out.println(target.getName() +" health = " + targetHealth);

        targetWeaponHealth = targetWeaponHealth-targetWeaponDecrease;
        targetWeapon.setHealth(targetWeaponHealth);

        //attacker during attack
        attackerHealth = attackerHealth - targetAttackDamage;
        attacker.setHealth(attackerHealth);
        System.out.println(attacker.getName()+" health = "+attackerHealth);

        attackerWeaponHealth = attackerWeaponHealth-attackerWeaponDecrease;
        attackerWeapon.setHealth(attackerWeaponHealth);

        //weapon printing
        System.out.println("******************************************");
        System.out.println(attackerWeapon.getName()+ " health = "+attackerWeaponHealth);
        System.out.println(targetWeapon.getName()+ " health = "+ targetWeaponHealth);

        System.out.println("-----------------------------------------");
    }

    public static int rounds(String rounds){
        int roundNumber = Integer.parseInt(rounds);
        return roundNumber;
    }


    public static void main(String[] args) {
        boolean running = true;


        Scanner command = new Scanner(System.in);


        System.out.println("Please enter your name");
        String name = command.nextLine();
        System.out.println("Hello, " + name);


        Room basement = new Room("basement");
        basement.setMessage("You are in a dimly lit basement of a large house.\nThere is a stairwell leading north.\nType look to find items available");
        System.out.println(basement.getMessage());

        //items
        Item watterBottle = new Item("water bottle", 0,10,10);
        Item flashLight = new Item("flash light", 0,0,15);
        Item note = new Item("note", 0,0,5);
        Item sword = new Item("sword", 20,0,65);
        Item diningRoomKey = new Item("key", 0,0,10);
        Item spear = new Item("spear", 15,0,50);
        Item baseBallBat = new Item("baseball bat", 20,0,60);
        Item knife = new Item("knife",15,0,70);
        Item rock = new Item("rock",10,0,40);
        Item machineGun =  new Item("machine gun", 17,0,70);


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
        Character player = new Character(100, name, "player", basement);
        Character cat = new Character(50, "mittens", "pet", diningRoom);

        //monsters
        Character monster1 = new Character(80, "the fanged man", "monster", kitchen);
        monster1.addItem(baseBallBat);

        Character testAttackMonster = new Character(80, "test monster", "monster", basement);
        testAttackMonster.addItem(rock);

        Character gameRoomMonster =  new Character(100,"gmame gangster","monster", gameRoom);
        gameRoomMonster.addItem(machineGun);


        //basement settings
        basement.setNorth(kitchen);

        basement.addItem(watterBottle);
        basement.addItem(note);
        basement.addItem(flashLight);
        basement.addItem(knife);
        basement.addCharacter(testAttackMonster);

        //kitchen settings
        kitchen.setEast(diningRoom);
        kitchen.setSouth(basement);


        kitchen.addItem(sword);
        kitchen.addItem(diningRoomKey);
        kitchen.setMessage("There is a cat here, it has nice orange fur.\nIf you pet the cat he might become your friend.\nType look to see items available.\nWarning there is a monster here");
        kitchen.addCharacter(monster1);

        //dining room settings
        diningRoom.setSouth(bedRoom);
        diningRoom.setWest(kitchen);

        //bed room settings
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
        gameRoom.addCharacter(gameRoomMonster);

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

            Character monster = player.getRoom().getCharacters().typeCheck("monster");

            if (player.getHealth() <= 0) {
                running = false;
                System.out.println("Oh no looks like you have died");
            }
            if(monster.getHealth()<=0){
                System.out.println("You have defeated the monster");
                monster.getRoom().removeCharacter(monster);
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
                    if (!attackItemNames.equals("")) {
                        System.out.println("What do you want to attack with?");
                        System.out.println("You can attack with:" + attackItemNames);
                    } else {
                        System.out.println("You don't have any items you can use to attack");
                    }

                    String attackItemName = command.nextLine();
                    boolean itemCheck = player.getPocket().attackRequest(attackItemName);

                    if (itemCheck) {
                        System.out.println("You are going to attack with the " + attackItemName);
                        System.out.println("How many battle rounds do you want? (max of 10 rounds)");
                        int numberOfRounds = rounds(command.nextLine());

                        Item attackItem = player.getPocket().use(attackItemName);
                        Item monsterAttackItem = monster.getPocket().getMonsterWeapon();

                        int i=0;
                        while((i<numberOfRounds)&&(player.getHealth()>0)&&(monster.getHealth()>0)){
                            attack(player,monster,attackItem, monsterAttackItem);
                            i++;
                        }

                    }


                    else {
                        System.out.println("Did you make a typo? not sure if this item can be used to attack");
                    }

                    break;

                case "eat":
                    Item eatItem = player.getPocket().collectRequest(inputCommands[1]);
                    if(eatItem!=null){
                        if(player.getHealth()<100) {
                            int newPlayerHealth = player.eat(eatItem);
                            System.out.println("Your health = " + newPlayerHealth);
                        }
                        if (player.getHealth() == 100) {
                            System.out.println("You have full health");
                        }
                    }
                    else{
                        System.out.println("Sorry I don't understand you here is what might have happened:\n1.You don't have the health increasing item\n2.You have already worn this item out\n3.This item does not exist\n4. You made a typo");
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

        }
        command.close();
    }

}