package Activitats.PE08_AcarretaAdrian.src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JocRPG {
    int cID=0;
    int wID=0;
    Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        JocRPG p = new JocRPG();
        p.principal();
    }

    public void principal() {
        ArrayList<Armes> allWeapons = new ArrayList<Armes>();
        ArrayList<Personatges> allCharacters = new ArrayList<Personatges>();
    }

    public void makeCharacter(ArrayList<Personatges> allCharacters,Scanner s) {
        String type=chooseType();
        String name=chooseName();
        int age=chooseAge();
        System.out.println("What do you prefer");
        System.out.println("(1) Automatic asignment");
        System.out.println("(2) Manual asignment");
        int strength;
        int dexterity;
        int constitution;
        int intelligence;
        int wisdom;
        int charisma;
        int luck;
        double health;
        int mana;
        Armes activeWeapon;
    }

    public double setDefaultHealth(int constitution) {
        double health=constitution*50;
        return health;
    }

    public int setDefaultMana(int intelligence) {
        int mana=intelligence*30;
        return mana;
    }

    public int chooseAge() {
        System.out.print("\nEnter an age: ");
        int age=readInt();
        return age;
    }

    public String chooseName() {
        System.out.print("\nEnter a name: ");
        String name=s.nextLine();
        return name;
    }

    public String chooseType() {
        boolean validOpt=false;
        int opt=0;
        String type="None";
        while (!validOpt) {
            System.out.println("Available types");
            System.out.println("(1) Human");
            System.out.println("(2) Elf");
            System.out.println("(3) Orc");
            System.out.println("(4) Dwarf");
            System.out.print("\nChoose the type of character: ");
            opt=readInt();
            switch (opt) {
                case 1:
                    type="Human";
                    System.out.println("You have been selected Human!");
                    validOpt=true;
                    break;
                case 2:
                    type="Elf";
                    System.out.println("You have been selected Elf!");
                    validOpt=true;
                    break;
                case 3:
                    type="Orc";
                    System.out.println("You have been selected Orc!");
                    validOpt=true;
                    break;
                case 4:
                    type="Dwarf";
                    System.out.println("You have been selected Dwarf!");
                    validOpt=true;
                    break;
            
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }
        return type;
    }

    public void showCharacters(ArrayList<Personatges> allCharacters) {

    }

    public void makeWeapon(ArrayList<Armes> allWeapons) {

    }

    public void showWeapons(ArrayList<Armes> allWeapons) {

    }

    public int readInt() {
        int num=0;
        boolean validNum=false;
        while (!validNum) {
            try {
                num=s.nextInt();
                validNum=true;
            } catch (InputMismatchException e) {
                System.out.println("(!) Please enter a valid num");
                s.nextLine();
            }
        }
        return num;
    }
    public double readDouble() {
        double num=0;
        boolean validNum=false;
        while (!validNum) {
            try {
                num=s.nextDouble();
                validNum=true;
            } catch (InputMismatchException e) {
                System.out.println("(!) Please enter a valid num");
                s.nextLine();
            }
        }
        return num;
    }
}
