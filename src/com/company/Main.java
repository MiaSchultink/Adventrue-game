package com.company;
import javax.imageio.event.IIOReadProgressListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int random(int a, int b) {
        int randomNumber = (int) ((b - a) * (Math.random()) + a);
        return randomNumber;
    }
    public static void pet(Character petter, Character pet){
        petter.getRoom().removeCharacter(pet);
        petter.addCharacter(pet);
    }
    public static void god(ArrayList<Room> rooms){
        for(int i=0; i<rooms.size();i++){
            Room room = rooms.get(i);
            System.out.println(room.getName());
            room.viewRoomItems();
            room.viewCharacters();
        }
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
        Item bread = new Item("bread",0,20,10);
        Item pasta =  new Item("pasta bowl",0,15,10);
        Item slime = new Item("grose monster slime",10,0,30);
        Item treasureChest = new Item("gold coin", 0,0,5);
        Item RPG = new Item("RPG",50,0,80);
        Item jello = new Item("super jello",5,25,20);
        Item jelloBlaster= new Item("jello blaster",25,0,50);


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

        RoomCollection rooms = new RoomCollection();
        rooms.addRoom(basement);
        rooms.addRoom(kitchen);
        rooms.addRoom(diningRoom);
        rooms.addRoom(gameRoom);
        rooms.addRoom(movieTheater);
        rooms.addRoom(jelloRoom);
        rooms.addRoom(bathRoom);
        rooms.addRoom(creepyLibrary);
        rooms.addRoom(fishTank);
        rooms.addRoom(bedRoom);
        rooms.addRoom(closet);
        rooms.addRoom(whiteRoom);
        rooms.addRoom(controlRoom);
        rooms.addRoom(finish);
        rooms.addRoom(livingRoom);

        //characters
        Character player = new Character(100, name, "player", basement);
        Character cat = new Character(50, "mittens", "pet", diningRoom);
        Character redFish = new Character(30,"bloody perana","monster",fishTank);
        Character blueFish = new Character(30,"Anigma","pet",fishTank);
        Character greenFish = new Character(30,"deep water tail trout","pet",fishTank);
        Character rainBowFish = new Character(30,"rain bow fish","pet",fishTank);
        Character shark = new Character(60,"The shark","monster",fishTank);

        //monsters
        Character monster1 = new Character(80, "the fanged man", "monster", kitchen);
        monster1.addItem(baseBallBat);

        Character testAttackMonster = new Character(80, "test monster", "monster", basement);
        testAttackMonster.addItem(rock);

        Character gameRoomMonster =  new Character(100,"game gangster","monster", gameRoom);
        gameRoomMonster.addItem(machineGun);

        Character jelloMonster = new Character(40,"mr blob","monster", closet);
        jelloMonster.addItem(jelloBlaster);


        //basement settings
        basement.setNorth(kitchen);

        basement.addItem(watterBottle);
        basement.addItem(note);
        basement.addItem(flashLight);
        basement.addItem(knife);
        basement.addItem(bread);
        basement.addCharacter(testAttackMonster);
        basement.addCharacter(cat);

        //kitchen settings
        kitchen.setEast(diningRoom);
        kitchen.setSouth(basement);

        kitchen.addItem(sword);
        kitchen.addItem(diningRoomKey);
        kitchen.setMessage("The scenic abandoned kitchen. There is a cat here, it has nice orange fur.\nIf you pet the cat he might become your friend.\nType look to see items available.\nWarning there is a monster here.");
        kitchen.addCharacter(monster1);

        //dining room settings
        diningRoom.setSouth(bedRoom);
        diningRoom.setWest(kitchen);

        diningRoom.setMessage("The dinning room, the great festive hall. The long table and leather coated chairs are as elegant as ever, the refinement in the carefully picked velvet certians is imminent.");
        diningRoom.addItem(pasta);


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
        gameRoom.setEast(fishTank);
        gameRoom.addCharacter(gameRoomMonster);

        //fish tabk settings
        fishTank.setWest(gameRoom);
        fishTank.setNorth(jelloRoom);
        fishTank.setMessage("Oh oh, you are underwater. You have a glimps of the trees and the outside world.\n Warning, you are loosing air quickly and under water trouble lurks close.\n There may be valuable items here. ");

        fishTank.addCharacter(redFish);
        fishTank.addCharacter(blueFish);
        fishTank.addCharacter(rainBowFish);
        fishTank.addCharacter(greenFish);
        fishTank.addCharacter(shark);
        fishTank.addItem(RPG);

        //jello room settings
        jelloRoom.setSouth(fishTank);
        jelloRoom.setWest(creepyLibrary);
        jelloRoom.addCharacter(jelloMonster);

        // creepy library settings
        creepyLibrary.setEast(jelloRoom);
        creepyLibrary.setSouth(whiteRoom);
        jelloRoom.setMessage("Wow what a change of scenery!\nEverything is sticky but delicious non the less.\nThe walls are made of brightly colored jello.\nHowever, danger never rests.");



        //white room settings
        whiteRoom.setWest(controlRoom);
        whiteRoom.setNorth(creepyLibrary);

        //control room settings
        controlRoom.setEast(whiteRoom);
        controlRoom.setSouth(finish);


        while (running) {

            Character monster = player.getRoom().getCharacters().typeCheck("monster");

            //checking if character and item health is under 0
            player.getPocket().clean();
            player.getRoom().getItems().clean();
            player.getRoom().getCharacters().clean();
            player.getCharacterBag().clean();

            if (player.getHealth() <= 0) {
                running = false;
                System.out.println("Oh no looks like you have died");
            }

            if(monster!=null) {
                if (monster.getHealth() <= 0) {
                    System.out.println("You have defeated the monster");
                    monster.getRoom().removeCharacter(monster);
                }
            }

            if(player.getHealth()<=10){
                System.out.println("Your health is very low!");
            }

            rooms.checkMonster();

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
                case "pets":
                    player.viewCharacters();
                    break;

                case "pocket":
                    player.viewPocket();
                    break;

                case "walk":
                    Room roomBefore  = player.getRoom();
                    rooms.walk(player,inputCommands[1]);
                    Room roomAfter  =  player.getRoom();
                    if(roomBefore!=roomAfter){
                        System.out.println(player.getName()+" is in the "+player.getRoom().getName());
                    }
                    else{
                        System.out.println("You can't go that way");
                    }
                    if(player.getRoom().getMessage()!=null) {
                        System.out.println(player.getRoom().getMessage());
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

                            if(newPlayerHealth>100){
                               newPlayerHealth=100;
                            }
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

                case "pet":
           Character pet = player.getRoom().getCharacters().collectRequest(inputCommands[1]);
           if((pet!=null)&&(pet.getType().equals("pet"))){
                   int scratchChances = random(0, 2);
                   if (scratchChances == 0) {
                       player.setHealth(player.getHealth() - 5);
                       System.out.println("Oh oh, looks like the " + pet.getName() + " has scratched you!");
                       System.out.println("Your health = "+ player.getHealth());
                   }
                   if (scratchChances == 1) {
                       pet(player,cat);
                       System.out.println("Congratulations, you have a pet!");
                   }
           }
           else{
               System.out.println("You can't pet that");
           }
           break;

                case "god":
                   rooms.god();
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