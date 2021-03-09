package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean running = true;
        Scanner command = new Scanner(System.in);

        System.out.println("Hello welcome to the game");
        System.out.println("Please enter your name");
        String name = command.nextLine();



        Room basement= new Room("basement", null, null, null, null);
        Room kitchen = new Room("kitchen",null,null,null,null);
        basement.setNorth(kitchen);
        kitchen.setSouth(basement);

        Character player = new Character(100, name,basement);

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
