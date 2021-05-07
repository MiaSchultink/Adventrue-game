package com.company;


import java.util.*;


public class Main {

    public static int random(int a, int b) {
        int randomNumber = (int) ((b - a) * (Math.random()) + a);
        return randomNumber;
    }

    public static void pet(Character petter, Character pet) {
        petter.getRoom().removeCharacter(pet);
        petter.addCharacter(pet);
    }

//    public static void moveTo(Room room, ArrayList<Room> path, Room lastRoom) {
//
//        path.add(room);
//        String pathNames = "";
//        for (int i = 0; i < path.size() - 1; i++) {
//            pathNames = pathNames + "-" + path.get(i).getName();
//        }
//        System.out.println(pathNames);
//
//        if (room == lastRoom) {
//            //  path.add(lastRoom);
//            System.out.println("finished");
//            return;
//        }
//        else if ((room.getNorth() != null) && (!path.contains(room.getNorth()))) {
//            System.out.println("north");
//            System.out.println(room.getNorth().getName());
//            moveTo(room.getNorth(), path, lastRoom);
//        }
//        else if ((room.getEast() != null) && (!path.contains(room.getEast()))) {
//            System.out.println("east");
//            System.out.println(room.getEast().getName());
//            moveTo(room.getEast(), path, lastRoom);
//        }
//        else if ((room.getWest() != null) && (!path.contains(room.getWest()))) {
//            System.out.println("west");
//            System.out.println(room.getWest().getName());
//            moveTo(room.getWest(), path, lastRoom);
//        }
//        else if ((room.getSouth() != null) && (!path.contains(room.getSouth()))) {
//            System.out.println("south");
//            System.out.println(room.getSouth().getName());
//            moveTo(room.getWest(), path, lastRoom);
//        }
//        else {
//            System.out.println("stuck");
//            path.clear();
//        }
//
//    }


    public static boolean moveTo(Room room, ArrayList<Room> path, Room lastRoom) {

        path.add(room);
        String pathNames = "";
        for (int i = 0; i < path.size() - 1; i++) {
            pathNames = pathNames + "-" + path.get(i).getName();
        }
        System.out.println(pathNames);

        if (room == lastRoom) {
            //  path.add(lastRoom);
            System.out.println("finished");
            return true;
        } else if ((room.getNorth() != null) && (!path.contains(room.getNorth()))) {
            System.out.println("north");
            System.out.println(room.getNorth().getName());
            moveTo(room.getNorth(), path, lastRoom);
        } else if ((room.getEast() != null) && (!path.contains(room.getEast()))) {
            System.out.println("east");
            System.out.println(room.getEast().getName());
            moveTo(room.getEast(), path, lastRoom);
        } else if ((room.getWest() != null) && (!path.contains(room.getWest()))) {
            System.out.println("west");
            System.out.println(room.getWest().getName());
            moveTo(room.getWest(), path, lastRoom);
        } else if ((room.getSouth() != null) && (!path.contains(room.getSouth()))) {
            System.out.println("south");
            System.out.println(room.getSouth().getName());
            moveTo(room.getWest(), path, lastRoom);
        } else {
            System.out.println("stuck");
            path.clear();

        }
        return false;
    }

    public static Room getRandomNeighbor(Room[] rooms) {
        Room resultRoom = new Room("");
        int roomIndex = random(0, 4);

       int counter = 0;
       boolean finished = false;
       while ((!finished)&&(counter<3)) {
               roomIndex = (roomIndex + counter) % 4;
               Room randomRoom = rooms[roomIndex];
               if (randomRoom != null) {
                   resultRoom = randomRoom;
                  // System.out.println("at last room");
                   finished=true;
               }

           counter++;
       }
        return resultRoom;
    }

    public static void testPath(Room startRoom, Room lastRoom) {
        ArrayList<Room> path = new ArrayList<>();
        Room currentRoom;
        currentRoom = startRoom;
        path.add(currentRoom);

        Room[] rooms = new Room[4];
        rooms[0] = currentRoom.getNorth();
        rooms[1] = currentRoom.getEast();
        rooms[2] = currentRoom.getSouth();
        rooms[3] = currentRoom.getWest();

        int moves = 10000;
        int counter = 0;
        boolean done = false;

        // for (int i = 0; i < moves; i++) {
        while ((counter < moves) && (done == false)) {

            //System.out.println(i);
            int random = random(0, rooms.length);
            //System.out.println("before " +currentRoom.getName());
//            if(rooms[random]!=null){
//                currentRoom=rooms[random];


            rooms[0] = currentRoom.getNorth();
            rooms[1] = currentRoom.getEast();
            rooms[2] = currentRoom.getSouth();
            rooms[3] = currentRoom.getWest();

   if((path.contains(rooms[0])||rooms[0]==null)&&(path.contains(rooms[1])||rooms[1]==null)&&(path.contains(rooms[2])||rooms[2]==null)&&(path.contains(rooms[3])||rooms[3]==null)){
       currentRoom=startRoom;
       System.out.println("back at start");
      // counter++;
   }

           // currentRoom = getRandomNeighbor(rooms);
            Room nextRoom = getRandomNeighbor(rooms);
            if(!(path.contains(nextRoom))){
                currentRoom = nextRoom;
                path.add(currentRoom);
            }

           // path.add(currentRoom);
            else if(path.contains(nextRoom)){
               // nextRoom=getRandomNeighbor(rooms);
               // counter++;
            }
           // counter++;

            if (rooms[random] == lastRoom) {
                System.out.println("done");
                for (int k = 0; k < path.size(); k++) {
                    Room room = path.get(k);
                    System.out.println(room.getName());
                }
                System.out.println("When done " + counter);
                done = true;

            }
            //System.out.println(counter);
 counter++;
        }
        System.out.println("end " + currentRoom.getName());

    }


    public static void findPath(Room startRoom, Room lastRoom, RoomCollection rooms) {
        ArrayList<Room> visited = new ArrayList<>();
        ArrayList<Room> unvisited = new ArrayList<>();


        for (int i = 0; i < rooms.getRoomList().size(); i++) {
            Room room = rooms.getRoomList().get(i);
            room.setShortestDistance(100000000);
            unvisited.add(room);
        }
        startRoom.setShortestDistance(0);
    }


    public static void rickRole() {
        String link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstleyVEVO";
        System.out.println(link);
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
        int targetAttackDamage = targetWeapon.getAttackDamage();

        //getting weapon health
        int attackerWeaponHealth = attackerWeapon.getHealth();
        int targetWeaponHealth = targetWeapon.getHealth();

        //creating percentage of weapon health decrease
        int attackerWeaponDecrease = (int) Math.round(1 * 100.0 / attackerWeaponHealth);
        int targetWeaponDecrease = (int) Math.round(1 * 100.0 / targetWeaponHealth);

        //target during attack
        targetHealth = targetHealth - attackerAttackDamage;
        target.setHealth(targetHealth);
        System.out.println(target.getName() + " health = " + targetHealth);

        targetWeaponHealth = targetWeaponHealth - targetWeaponDecrease;
        targetWeapon.setHealth(targetWeaponHealth);

        //attacker during attack
        attackerHealth = attackerHealth - targetAttackDamage;
        attacker.setHealth(attackerHealth);
        System.out.println(attacker.getName() + " health = " + attackerHealth);

        attackerWeaponHealth = attackerWeaponHealth - attackerWeaponDecrease;
        attackerWeapon.setHealth(attackerWeaponHealth);

        //weapon printing
        System.out.println("******************************************");
        System.out.println(attackerWeapon.getName() + " health = " + attackerWeaponHealth);
        System.out.println(targetWeapon.getName() + " health = " + targetWeaponHealth);

        System.out.println("-----------------------------------------");
    }

    public static int rounds(String rounds) {
        int roundNumber = Integer.parseInt(rounds);
        return roundNumber;
    }

    public static String printPattern(int n) {
        String pattern = "";
        for (int i = 0; i < n; i++) //outer loop for number of rows(n) { for (int j=n-i; j>1; j--) //inner loop for spaces
        {
            pattern = pattern + " ";
            for (int j = 0; j <= i; j++) //inner loop for number of columns
            {
                pattern = pattern + "* ";

            }
            pattern = pattern + "\n";
        }
        return pattern;
    }


    public static void arrayFill(String[][] roomsArray) {
        for (int i = 0; i < roomsArray.length; i++) {
            for (int j = 0; j < roomsArray[i].length; j++) {
                roomsArray[i][j] = "-";
            }

        }
    }

    public static String[][] chekFree(int row, int column, String[][] roomsArray) {
        if (row > 0) {
            if (roomsArray[row - 1][column].equals("-")) {
                roomsArray[row - 1][column] = "F";
            }
        }
        if (row < roomsArray.length - 1) {
            if (roomsArray[row + 1][column].equals("-")) {
                roomsArray[row + 1][column] = "F";
            }
        }
        if (column > 0) {
            if (roomsArray[row][column - 1].equals("-")) {
                roomsArray[row][column - 1] = "F";
            }
        }
        if (column < roomsArray[0].length - 1) {
            if (roomsArray[row][column + 1].equals("-")) {
                roomsArray[row][column + 1] = "F";
            }
        }
        return roomsArray;
    }

    public static int findF(String[][] roomsArray) {
        int numberOfF = 0;
        for (int i = 0; i < roomsArray.length; i++) {
            for (int j = 0; j < roomsArray[i].length; j++) {
                if (roomsArray[i][j].equals("F")) {
                    numberOfF++;
                }
            }
        }
        return numberOfF;
    }

    public static int roomCountInMap(Room[][] rooms) {
        int counter = 0;
        for (int i = 0; i < rooms.length; i++) {
            counter++;
        }
        return counter;
    }


    public static String[][] findNextR(String[][] roomsArray, int Fnumber) {
        int counter = 0;
        //int numberOfR = 0;

        int randomNumberOfF = random(1, Fnumber);
        for (int i = 0; i < roomsArray.length; i++) {
            for (int j = 0; j < roomsArray[i].length; j++) {
                if (roomsArray[i][j].equals("F")) {
                    counter++;
                    if (counter == randomNumberOfF) {
                        roomsArray[i][j] = "R";
                        //numberOfR++;
                        roomsArray = chekFree(i, j, roomsArray);


//                        if (numberOfR > Fnumber) {
//                            for (int k = 0; k < roomsArray.length; k++) {
//                                for (int y = 0; y < roomsArray[k].length; y++) {
//                                    System.out.println("got here");
//                                    roomsArray = chekFree(k, y, roomsArray);
//                                }
//                            }
//                        }
                    }
                }
            }
        }

        return roomsArray;
    }

    public static int countR(String[][] roomsArray) {
        int rCounter = 0;
        for (int i = 0; i < roomsArray.length; i++) {
            for (int j = 0; j < roomsArray[i].length; j++) {
                if (roomsArray[i][j].equals("R")) {
                    rCounter++;
                }
            }
        }
        return rCounter;
    }

//    public static void replaceF(String[][] roomsArray) {
//        for (int i = 0; i < roomsArray.length; i++) {
//            for (int j = 0; j < roomsArray[i].length; j++) {
//                if (roomsArray[i][j].equals("F")) {
//                    roomsArray[i][j] = "-";
//                }
//            }
//        }
//    }

    public static void printArray(String[][] roomsArray) {

        for (int i = 0; i < roomsArray.length; i++) {
            String row = "";
            for (int j = 0; j < roomsArray[i].length; j++) {
                row = row + "   " + roomsArray[i][j];
            }
            System.out.println(row);
        }

    }

    public static String[][] makeMap(int roomNumber) {
        String[][] roomsArray = new String[15][15];
        arrayFill(roomsArray);

        roomsArray[6][4] = "R";
        roomsArray = chekFree(6, 4, roomsArray);

        for (int y = 0; y < roomNumber - 1; y++) {
            int F = findF(roomsArray);
            roomsArray = findNextR(roomsArray, F);
        }
        return roomsArray;
    }


    public static void printRoomArray(Room[][] rooms) {
        int labelLength = 17;
        for (int i = 0; i < rooms.length; i++) {
            String roomName = "";
            for (int j = 0; j < rooms[i].length; j++) {
                Room room = rooms[i][j];
                if (room != null) {
                    String name = rooms[i][j].getName();
                    int roomNameLength = name.length();
                    roomName = roomName + " ".repeat(labelLength - roomNameLength + 1) + name;
                } else {
                    roomName = roomName + " " + "-".repeat(labelLength);
                }
            }
            System.out.println(roomName);
        }
    }

    public static String[][] checkExitRoom(String[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                boolean onEdge = false;
                if (rooms[i][j].equals("F")) {
                    if (i == 0 || j == 0 || i == (rooms.length - 1) || j == (rooms[i].length - 1)) {
                        onEdge = true;
                    }
                    if (onEdge) {
                        rooms[i][j] = "E";
                    } else {

                        String up = rooms[i - 1][j];
                        String down = rooms[i + 1][j];
                        String right = rooms[i][j + 1];
                        String left = rooms[i][j - 1];

                        if ((down.equals("-") || up.equals("-") || right.equals("-") || left.equals("-")) || (down.equals("F") || up.equals("F") || right.equals("F") || left.equals("F"))) {
                            rooms[i][j] = "E";
                        }
                    }
                }
            }
        }
        return rooms;
    }

    public static int findE(String[][] rooms) {
        int numberOfE = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j].equals("E")) {
                    numberOfE++;
                }
            }
        }
        return numberOfE;
    }

    public static Room[][] placeExitRoom(String[][] rooms, Room[][] roomsArray, Room exitRoom, int eNumber) {
        int counter = 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j].equals("E")) {
                    counter++;
                    if (counter == eNumber) {
                        rooms[i][j] = "*";
                        roomsArray[i][j] = exitRoom;
                    }
                }
            }
        }
        return roomsArray;
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
        Item watterBottle = new Item("water bottle", 0, 10, 10);
        Item flashLight = new Item("flash light", 0, 0, 15);
        Item note = new Item("note", 0, 0, 5);
        Item sword = new Item("sword", 20, 0, 65);
        Item diningRoomKey = new Item("key", 0, 0, 10);
        Item spear = new Item("spear", 15, 0, 50);
        Item baseBallBat = new Item("baseball bat", 20, 0, 60);
        Item knife = new Item("knife", 15, 0, 70);
        Item rock = new Item("rock", 10, 0, 40);
        Item machineGun = new Item("machine gun", 17, 0, 70);
        Item bread = new Item("bread", 0, 20, 10);
        Item pasta = new Item("pasta bowl", 0, 15, 10);
        Item slime = new Item("grose monster slime", 10, 0, 30);
        Item RPG = new Item("RPG", 50, 0, 80);
        Item jello = new Item("super jello", 5, 25, 20);
        Item jelloBlaster = new Item("jello blaster", 25, 0, 50);
        Item fishDish = new Item("fish dish", 0, 25, 10);
        Item sprayPaint = new Item("spray paint", 10, 0, 40);
        Item sharkFangs = new Item("shark fangs", 15, 0, 60);
        Item soup = new Item("soup", 5, 0, 15);
        Item pillow = new Item("pillow", 0, 15, 20);
        Item nunchucks = new Item("nunchucks", 20, 0, 60);
        Item healingPotion = new Item("healign potion", 0, 20, 40);
        Item poison = new Item("poison", 20, 0, 40);
        Item book = new Item("book", 0, 0, 20);
        Item shooshingDevice = new Item("shooshing device", 17, 0, 35);
        Item laptop = new Item("laptop", 0, 0, 40);
        Item fire = new Item("fire", 40, 0, 75);
        String lapTopMessage = " can you solve the following problem?" +
                " Print this pattern:\n" +
                printPattern(5) +

                "Solution \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "int n=5; \n" +
                "for (int i=0; i<n; i++) //outer loop for number of rows(n) { for (int j=n-i; j>1; j--) //inner loop for spaces\n" +
                "            { \n" +
                "                System.out.print(\" \"); //print space\n" +
                "            }  \n" +
                "            for (int j=0; j<=i; j++ ) //inner loop for number of columns\n" +
                "            { \n" +
                "                System.out.print(\"* \"); //print star\n" +
                "            } \n" +
                "  \n" +
                "            System.out.println(); //ending line after each row\n" +
                "        } ";

        laptop.setMessage(lapTopMessage);
        Item cellPhone = new Item("cell phone", 0, 0, 30);
        cellPhone.setMessage("Sorry no service! all the service is going to the servers to power the super computers");
        Item jacket = new Item("jacket", 0, 15, 20);
        Item chocolate = new Item("secret chocolate", 0, 20, 30);
        Item psychicAbility = new Item("psychic powers", 20, 0, 80);
        Item popCorn = new Item("popcorn", 0, 25, 30);
        Item coke = new Item("cola", 0, 15, 25);
        Item spookyPower = new Item("spooky power", 10, 0, 40);
        Item protectiveShoes = new Item("fire protection shoes", 0, 15, 40);
        Item strawBerries = new Item("strawberries", 0, 9, 10);
        Item pineapple = new Item("pineapple", 0, 7, 10);
        Item jollyRanchers = new Item("jolly ranchers", 0, 15, 20);
        Item gameMedal = new Item("gold medal", 0, 90, 90);

        Item gun = new Item("pistol", 10, 0, 30);
        Item taser = new Item("taser", 15, 0, 50);
        Item glassShard = new Item("glass shard", 10, 0, 25);
        Item toxicGas = new Item("toxic gas", 15, 0, 40);
        Item attackVines = new Item("grip vines", 10, 0, 50);
        Item grenade = new Item("grenade", 20, 0, 25);
        Item temporarySuperStrength = new Item("temporary super strength", 10, 0, 35);

        //torture chamber weapons
        Item beatingStick = new Item("beating stick", 10, 0, 20);
        Item scythe = new Item("scythe", 15, 0, 20);


        //rooms
        Room kitchen = new Room("kitchen");
        Room diningRoom = new Room("dining room");
        Room gameRoom = new Room("gaming room");
        Room movieTheater = new Room("movie room");
        Room jelloRoom = new Room("jello room");
        Room bathRoom = new Room("bath room");
        Room creepyLibrary = new Room("creepy library");
        Room natureReserve = new Room("nature reserve");
        Room bedRoom = new Room("bed room");
        Room closet = new Room("closet");
        Room lavaRoom = new Room("lava room");
        Room fishTank = new Room("fish tank");
        Room whiteRoom = new Room("white room");
        Room controlRoom = new Room("control room");
        Room finish = new Room("freedom");
        Room livingRoom = new Room("living room");
        Room tortureChamber = new Room("torture chamber");

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
        rooms.addRoom(livingRoom);
        rooms.addRoom(lavaRoom);
        rooms.addRoom(natureReserve);
        rooms.addRoom(tortureChamber);


        String[][] roomMap = makeMap(rooms.getRoomList().size());
        checkExitRoom(roomMap);
        Room[][] roomLayout = new Room[15][15];

        rooms.shuffle();
        int roomCounter = 0;
        for (int i = 0; i < roomMap.length; i++) {
            for (int j = 0; j < roomMap[i].length; j++) {
                if (roomMap[i][j].equals("R")) {
                    Room randomRoom = rooms.getRoomList().get(roomCounter);

                    roomCounter++;
                    roomLayout[i][j] = randomRoom;
                }
            }
        }
        rooms.addRoom(finish);
        roomLayout = placeExitRoom(roomMap, roomLayout, finish, random(1, findE(roomMap)));

        for (int i = 0; i < roomLayout.length - 1; i++) {
            for (int j = 0; j < roomLayout[i].length - 1; j++) {

                Room room = roomLayout[i][j];
                if (room != null) {
                    if (i > 0) {
                        Room roomNorth = roomLayout[i - 1][j];
                        if (roomNorth != null) {
                            room.setNorth(roomNorth);
                        }
                    }
                    if (i < roomLayout.length - 1) {
                        Room roomSouth = roomLayout[i + 1][j];
                        if (roomSouth != null) {
                            room.setSouth(roomSouth);
                        }
                    }
                    if (j < roomLayout[i].length - 1) {
                        Room roomEast = roomLayout[i][j + 1];
                        if (roomEast != null) {
                            room.setEast(roomEast);
                        }
                    }
                    if (j > 0) {
                        Room roomWest = roomLayout[i][j - 1];
                        if (roomWest != null) {
                            room.setWest(roomWest);
                        }
                    }

                }
            }
        }


        //characters
        Character player = new Character(100, name, "player", basement);
        player.setScore(0);

        Character cat = new Character(50, "mittens", "pet", diningRoom);
        Character redFish = new Character(30, "bloody perana", "monster", fishTank);
        Character blueFish = new Character(30, "Anigma", "pet", fishTank);
        Character greenFish = new Character(30, "deep water tail trout", "pet", fishTank);
        Character rainBowFish = new Character(30, "rain bow fish", "pet", fishTank);
        Character italianGreyhound = new Character(60, "Griffin", "pet", finish);


        Character butler = new Character(85, "the butler", "person", diningRoom);

        //monsters
        Character monster1 = new Character(80, "the fanged man", "monster", kitchen);
        monster1.addItem(baseBallBat);

        Character testAttackMonster = new Character(80, "test monster", "monster", basement);
        testAttackMonster.addItem(rock);

        Character gameRoomMonster = new Character(100, "game gangster", "monster", gameRoom);
        gameRoomMonster.addItem(machineGun);

        Character jelloMonster = new Character(40, "mr blob", "monster", closet);
        jelloMonster.addItem(jelloBlaster);

        Character shark = new Character(60, "shark", "monster", fishTank);
        shark.addItem(sharkFangs);

        Character zombiLibrarian = new Character(60, "zombi librarian", "monster", creepyLibrary);
        zombiLibrarian.addItem(shooshingDevice);

        Character giantDragon = new Character(130, "Dragon of death", "monster", finish);
        giantDragon.addItem(fire);

        Character invisibleMan = new Character(200, "invisible man", "monster", whiteRoom);
        invisibleMan.addItem(psychicAbility);

        Character movieWatcher = new Character(70, "jake", "person", movieTheater);
        movieWatcher.setMessage("Hey there, do you come here often?  Anyway, if you come by soon the best movie is ‘monsters inc’!");

        Character ghost = new Character(55, "creepy ghost", "monster", closet);
        ghost.addItem(spookyPower);

        Character lavaMonster = new Character(100, "burning legend", "monster", lavaRoom);
        lavaMonster.addItem(fire);

        Character natureReserveMonster = new Character(70, "the master of green", "monster", natureReserve);
        natureReserveMonster.addItem(attackVines);

        Character livingRoomMonster = new Character(60, "civilised monster", "monster", livingRoom);
        livingRoomMonster.addItem(taser);

        Character stretchingMonster = new Character(60, "stretch torturer", "monster", tortureChamber);

        //basement settings
        basement.addItem(watterBottle);
        basement.addItem(note);
        basement.addItem(flashLight);
        basement.addItem(knife);
        basement.addItem(bread);
        basement.addCharacter(testAttackMonster);
        basement.addCharacter(cat);

        //kitchen settings
        kitchen.addItem(sword);
        kitchen.addItem(diningRoomKey);
        kitchen.setMessage("The scenic abandoned kitchen. There is a cat here, it has nice orange fur.\nIf you pet the cat he might become your friend.\nType look to see items available.\nWarning there is a monster here.");
        kitchen.addCharacter(monster1);

        //dining room settings
        diningRoom.setMessage("The dinning room, the great festive hall. The long table and leather coated chairs are as elegant as ever, the refinement in the carefully picked velvet certians is imminent.");
        diningRoom.addItem(pasta);
        diningRoom.addItem(fishDish);
        diningRoom.addCharacter(butler);

        //bed room settings
        bedRoom.setMessage("A comfortable safe haven, a tempting location for a quick nap, but remember there isn’t much time to rest!");
        bedRoom.addItem(pillow);
        bedRoom.addItem(nunchucks);
        bedRoom.addItem(chocolate);

        //bath room settings
        bathRoom.setMessage("Everything is clean, it smells like soup, be careful not to get any in your eyes!.");
        bathRoom.addItem(watterBottle);
        bathRoom.addItem(soup);

        // closet settings
        closet.addItem(jacket);
        closet.addCharacter(ghost);

        /// movie room settings
        movieTheater.addCharacter(movieWatcher);
        movieTheater.addItem(popCorn);
        movieTheater.addItem(coke);

        // living room settings
        livingRoom.addItem(gun);
        livingRoom.addItem(toxicGas);
        livingRoom.addCharacter(livingRoomMonster);

        //game room settings
        gameRoom.addCharacter(gameRoomMonster);
        gameRoom.addItem(grenade);
        gameRoom.addItem(popCorn);
        gameRoom.addItem(jollyRanchers);
        gameRoom.setMessage("The room of ultimate fun, the flashing lights and music, the popcorn and candy. \nTruly an amazing experience!");


        //fish tabk settings
        fishTank.setMessage("Oh oh, you are underwater. You have a glimps of the trees and the outside world.\n Warning, you are loosing air quickly and under water trouble lurks close.\n There may be valuable items here. ");

        fishTank.addCharacter(redFish);
        fishTank.addCharacter(blueFish);
        fishTank.addCharacter(rainBowFish);
        fishTank.addCharacter(greenFish);
        fishTank.addCharacter(shark);
        fishTank.addItem(RPG);
        fishTank.addItem(watterBottle);

        //jello room settings
        jelloRoom.setMessage("Wow what a change of scenery!\nEverything is sticky but delicious non the less.\nThe walls are made of brightly colored jello.\nHowever, danger never rests.");
        jelloRoom.addCharacter(jelloMonster);
        jelloRoom.addItem(jello);
        jelloRoom.addItem(jello);
        jelloRoom.addItem(jello);

        // creepy library settings
        creepyLibrary.addItem(poison);
        creepyLibrary.addItem(healingPotion);
        creepyLibrary.addItem(book);
        creepyLibrary.addCharacter(zombiLibrarian);

        // nature reserve settings
        natureReserve.addCharacter(natureReserveMonster);
        natureReserve.addItem(strawBerries);
        natureReserve.addItem(pineapple);

        //white room settings
        whiteRoom.addCharacter(invisibleMan);
        whiteRoom.setMessage("What is this strange place?  It is all white as far as the eye can, as if it is a part of another dimension. ");

        //control room settings
        controlRoom.addItem(laptop);
        controlRoom.addItem(cellPhone);
        controlRoom.addItem(watterBottle);

        //lava room settings
        lavaRoom.addCharacter(lavaMonster);
        lavaRoom.addItem(protectiveShoes);
        lavaRoom.setMessage("The floor is lava, the noise of the bubbling hot substance is a fair wearing.\nWe suggest that you get out of here as soon as possible!");


        //finish settings
        finish.setMessage("Congratulation! \nYou made it out! The sun you have not seen in a while is shining brightly, the leaves on the trees are rustling slightly. \nThere is an abandoned dog out here, perhaps you could take him on your future adventures.\nTake a deep breath of fresh air and celebrate! \nIt has been an honor helping you along your journey " + player.getName() + ". You have achieved great things " + "Your score is " + player.getScore() + ". \nThank you. Type 'end game' to end your journey");
        finish.addCharacter(italianGreyhound);
        finish.addItem(gameMedal);

        ArrayList<String> emoji = new ArrayList<String>();
        emoji.add("\uD83D\uDE07");
        emoji.add("\uD83E\uDD10");
        emoji.add("\uD83E\uDD25");
        emoji.add("\uD83D\uDE34");
        emoji.add("\uD83D\uDE37");
        emoji.add("\uD83E\uDD76");
        emoji.add("\uD83E\uDD29");
        emoji.add("\uD83D\uDCA9");

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

            if (monster != null) {
                if (monster.getHealth() <= 0) {
                    System.out.println("You have defeated the monster");
                    player.setScore(player.getScore() + 100);
                    monster.getRoom().removeCharacter(monster);
                }
            }

            if (player.getHealth() <= 10) {
                System.out.println("Your health is very low!");
            }

            int randomNumber = random(0, 20);
            if (randomNumber < 1) {
                System.out.println("Well well, looks like you got lucky!\n click this link for the soluiton to the game");
                rickRole();
            }


            if (player.getRoom() == lavaRoom) {
                if (player.getPocket().getItemList().contains(protectiveShoes)) {
                    player.setHealth(player.getHealth() - 3);
                } else {
                    player.setHealth(player.getHealth() - 7);
                }
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

                case "score":
                    int score = player.getScore();
                    System.out.println("score = " + score);
                    break;

                case "pocket":
                    player.viewPocket();
                    break;

                case "walk":
                    Room roomBefore = player.getRoom();
                    rooms.walk(player, inputCommands[1]);
                    Room roomAfter = player.getRoom();
                    if (roomBefore != roomAfter) {
                        System.out.println(player.getName() + " is in the " + player.getRoom().getName());
                        if (player.getRoom().getMessage() != null) {
                            System.out.println(player.getRoom().getMessage());
                        }
                        player.setScore(player.getScore() + 5);
                    } else {
                        System.out.println("You can't go that way");
                    }
                    break;


                case "collect":
                    Item item = player.getRoom().getItems().collectRequest(inputCommands[1]);
                    if (item != null) {
                        player.addItem(item);
                        System.out.println("you have the " + item.getName());
                        if (item.getMessage() != null) {
                            System.out.println(item.getMessage());
                        }
                        player.setScore(player.getScore() + 10);
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
                    if (monster != null) {
                        System.out.println("Who do you want to attack");
                        System.out.println("Your options are: " + player.getRoom().getCharacters().typeCheck("monster").getName());
                        Character possibleMonster = player.getRoom().getCharacters().monsterAttackRequest(command.nextLine());
                        if (possibleMonster != null) {
                            System.out.println("You are about to attack " + possibleMonster.getName());
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
                                player.setScore(player.getScore() + 50);

                                Item attackItem = player.getPocket().use(attackItemName);
                                Item monsterAttackItem = monster.getPocket().getMonsterWeapon();

                                int i = 0;
                                while ((i < numberOfRounds) && (player.getHealth() > 0) && (monster.getHealth() > 0)) {
                                    attack(player, monster, attackItem, monsterAttackItem);
                                    i++;
                                }

                            } else {
                                System.out.println("Did you make a typo? not sure if this item can be used to attack");
                            }

                        } else {
                            System.out.println("Sorry! that is not a valid character");
                        }
                    } else {
                        System.out.println("There is no one to attack here");
                    }
                    break;

                case "eat":
                    Item eatItem = player.getPocket().eatRequest(inputCommands[1]);
                    if (eatItem != null) {
                        if (player.getHealth() < 100) {
                            int newPlayerHealth = player.eat(eatItem);
                            player.setScore(player.getScore() + 7);

                            if (newPlayerHealth > 100) {
                                newPlayerHealth = 100;
                            }
                            System.out.println("Your health = " + newPlayerHealth);
                        } else {
                            System.out.println("You have full health");
                        }
                    } else {
                        System.out.println("Sorry I don't understand you here is what might have happened:\n1.You don't have the health increasing item\n2.You have already worn this item out\n3.This item does not exist\n4. You made a typo");
                    }

                    break;

                case "pet":
                    Character pet = player.getRoom().getCharacters().collectRequest(inputCommands[1]);
                    if ((pet != null) && (pet.getType().equals("pet"))) {
                        int scratchChances = random(0, 2);
                        if (scratchChances == 0) {
                            player.setHealth(player.getHealth() - 5);
                            System.out.println("Oh oh, looks like the " + pet.getName() + " has scratched you!");
                            System.out.println("Your health = " + player.getHealth());
                        }
                        if (scratchChances == 1) {
                            pet(player, cat);
                            System.out.println("Congratulations, you have a pet!");
                            player.setScore(player.getScore() + 25);
                        }
                    } else {
                        System.out.println("You can't pet that");
                    }
                    break;

                case "contact":
                    Character talkCharacter = player.getRoom().getCharacters().talkRequest(inputCommands[1]);
                    if (talkCharacter != null) {
                        if (talkCharacter.getMessage() != null) {
                            System.out.println(talkCharacter.getMessage());
                        } else {
                            System.out.println("I have nothing to say");
                        }
                    } else {
                        System.out.println("Sorry you can't talk to this person");
                    }
                    break;

                //game jokes
                case "emoji":
                    int index = (int) (Math.random() * emoji.size());
                    System.out.println(emoji.get(index));
                    break;

                //cheat commands for debugging
                case "relocate":
                    System.out.println("which room do you want to go to?");
                    rooms.relocate(player, command.nextLine());

                    System.out.println("You are in the " + player.getRoom().getName());
                    System.out.println(player.getRoom().getMessage());
                    break;

                case "god":
                    rooms.god();
                    player.setScore(0);
                    System.out.println("You don't get a score for this game because you cheated");
                    break;

                case "map":
                    printRoomArray(roomLayout);
                    break;


                case "path":
                    //exitConditions(basement,finish);
//                    ArrayList<Room> path = new ArrayList<>();
//                    for(int i=0; i<10; i++) {
//                        path.clear();
//                        moveTo(player.getRoom(), path, finish);
//                    }
                    testPath(basement, finish);

                    break;

                case "pattern":
                    printArray(roomMap);
                    break;

                case "count":
                    int counter = rooms.roomCounter();
                    System.out.println("number of rooms = " + counter);
                    break;

                case "count on map":
                    int numberRooms = roomCountInMap(roomLayout);
                    System.out.println("number of rooms on map =" + numberRooms);
                    break;

                case "quit":
                    System.out.println("Thanks for playing, " + player.getName() + "!");
                    running = false;
                    break;

                case "end game":
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