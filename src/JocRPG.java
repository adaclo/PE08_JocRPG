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
        int opt=0;
        do {
            System.err.println("RPG GAME BY ADRIAN ACARRETA");
            System.err.println("(1) Create character");
            if (allCharacters.size()>=2)
                System.err.println("(2) Play 1v1");
            System.out.println("(0) Exit");
            System.out.print("\nChoose an option: ");
            opt=readInt();
            switch (opt) {
                case 1:
                    makeCharacter(allCharacters, allWeapons);
                    break;
                case 2:
                    startGame(allCharacters, allWeapons);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
            
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        } while(opt!=0);
    }

    public void startGame(ArrayList<Personatges>allCaracters,ArrayList<Armes>allWeapons) {
        String[] players = new String[2];
        Personatges[] characters = new Personatges[2];
        boolean end=false;
        choosePlayers(players);
        chooseCharacters(players,characters,allCaracters,allWeapons);
        while(!end) {
            for(int p=0;p<players.length;p++) {
                if(characters[p].getHealth()>0) {
                    newTurn(allCaracters, allWeapons, p, characters, players);
                }
                if (characters[p].getHealth()<=0) {
                    System.out.println("Player"+p+" has lost...");
                    end=true;
                }
            }
        }
    }

    public void newTurn(ArrayList<Personatges>allCharacters,ArrayList<Armes>allWeapons,int p,Personatges[] characters,String[] players) {
        int enemy=0;
        if (p==0) 
            enemy=1;
        int opt=0;
        boolean validOpt=false;
        characters[p].regenHealth();
        characters[p].regenMana();
        while(!validOpt) {
            System.out.println("Its turn of player"+p);
            System.out.println("Player"+p+" stats:");
            System.out.println(characters[p].toString());
            System.out.println("------------------------");
            System.out.println("Weapon info:");
            System.out.println(characters[p].getActiveWeapon().toString());
            System.out.println("------------------------");
            System.out.println("Enemy stats:");
            System.out.println(characters[enemy].toString());
            System.out.println("------------------------");
            System.out.println("(1) Change weapon");
            System.out.println("(2) Attack");
            System.out.println("(3) Defense next turn");
            System.out.print("\nChoose: ");
            opt=readInt();
            switch (opt) {
                case 1:
                    characters[p].setActiveWeapon(chooseWeapon(allWeapons, characters[p]));
                    validOpt=true;
                    break;
                case 2:
                    characters[p].attack(characters[enemy]);
                    validOpt=true;
                    break;
                case 3:
                    characters[p].setDefending(true);
                    validOpt=true;
                    break;
            
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }

    }

    public void chooseCharacters(String[] players,Personatges[] characters,ArrayList<Personatges>allCharacters,ArrayList<Armes>allWeapos) {
        for (int p=0;p<players.length;p++) {
            showCharacter(allCharacters);
            System.out.print("\nChoose a character: ");
            int index=0;
            int id=readInt();
            boolean found=false;
            while(!found&&index<allCharacters.size()) {
                if (allCharacters.get(index).getID()==id) {
                    characters[p]=allCharacters.get(index);
                    found=true;
                } else {index++;}
            }
        }
    }

    public void choosePlayers(String[] players) {
        String var="";
        s.nextLine();
        do{
            for (int i=0;i<players.length;i++) {
                System.out.print("\nChoose a name for the player"+i+": ");
                players[i]=s.nextLine();
            }
            System.out.print("\nAre you sure '"+players[0]+"' and '"+players[1]+"' are the names? (y/n): ");
            var=s.nextLine();
        } while(!var.equalsIgnoreCase("y"));
    }

    public void showCharacter(ArrayList<Personatges> allCharects) {
        for (int i=0;i<allCharects.size();i++) {
            System.out.println(allCharects.get(i).toString());
        }
    }

    public void makeCharacter(ArrayList<Personatges> allCharacters,ArrayList<Armes>allWeapons) {
        String type=chooseType();
        s.nextLine(); // clean buffer
        String name=chooseName();
        int age=chooseAge();
        int[] stats = new int[6];
        String[] statsName = {"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"};
        int opt=0;
        boolean validOpt=false;
        while (!validOpt) {
            System.out.println("What do you prefer");
            System.out.println("(1) Automatic asignment");
            System.out.println("(2) Manual asignment");
            opt=readInt();
            switch (opt) {
                case 1:
                    autoStats(stats, statsName);
                    validOpt=true;
                    break;
                case 2:
                    manualStats(stats, statsName);
                    validOpt=true;
                    break;
            
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }
        int strength=stats[0];
        int dexterity=stats[1];
        int constitution=stats[2];
        int intelligence=stats[3];
        int wisdom=stats[4];
        int charisma=stats[5];
        int luck=setLuck();
        double health=setDefaultHealth(constitution);
        int mana=setDefaultMana(intelligence);
        Personatges c;
        if (type.equalsIgnoreCase("Human")) {
            c = new Human(cID, type, name, age, health, mana, strength, dexterity, constitution, intelligence, wisdom, charisma, luck);
        } else if (type.equalsIgnoreCase("Elf")) {
            c = new Elf(cID, type, name, age, health, mana, strength, dexterity, constitution, intelligence, wisdom, charisma, luck);
        } else if (type.equalsIgnoreCase("Orc")) {
            c = new Orc(cID, type, name, age, health, mana, strength, dexterity, constitution, intelligence, wisdom, charisma, luck);
        } else {
            c = new Dwarf(cID, type, name, age, health, mana, strength, dexterity, constitution, intelligence, wisdom, charisma, luck);
        }
        c.setHealth(setDefaultHealth(c.getConstitution()));
        c.setMana(setDefaultMana(c.getIntelligence()));
        Armes activeWeapon=chooseWeapon(allWeapons,c);
        while (!c.setActiveWeapon(activeWeapon)) {
            activeWeapon=chooseWeapon(allWeapons,c);
        }
        allCharacters.add(c);
        cID++;
    }

    public Armes chooseWeapon(ArrayList<Armes>allWeapons,Personatges c) {
        int id=0;
        Armes weapon=new Armes();
        int index=0;
        boolean found=false;
        if (allWeapons.size()!=0) {
            System.out.println();
            boolean validOpt=false;
            while(!validOpt) {
                System.out.print("\nDo you want to create a new weapon? (y/n): ");
                String var=s.nextLine();
                if(var.equalsIgnoreCase("y")) {
                    weapon=makeWeapon();
                    allWeapons.add(weapon);
                    c.addWeapon(weapon);
                    validOpt=true;
                } else if (var.equalsIgnoreCase("n")) {
                    showWeapons(allWeapons);
                    System.out.print("\nChoose one: ");
                    id=readInt();
                    while (!found&&index<allWeapons.size()) {
                        if (allWeapons.get(index).getID()==id) {
                            weapon=allWeapons.get(id);
                            found=true;
                        } else {index++;}
                    }
                    validOpt=true;
                }
            }
        } else {
            weapon=makeWeapon(); //auto create because no weapon created
            c.addWeapon(weapon);
            allWeapons.add(weapon);
        }
        return weapon;
    }

    public Armes makeWeapon() {
        String type=chooseWeaponType();
        double damage=(int)(Math.random()*100)+1;
        boolean isMagic=false;
        if(type.equalsIgnoreCase("wand"))
            isMagic=true;
        Armes w = new Armes(wID, type, damage, isMagic);
        wID++;
        return w;
    }

    public String chooseWeaponType() {
        boolean validOpt=false;
        int opt=0;
        String type="None";
        while (!validOpt) {
            System.out.println("Available types");
            System.out.println("(1) Sword");
            System.out.println("(2) Axe");
            System.out.println("(3) Wand");
            System.out.println("(4) Bow");
            System.out.print("\nChoose the type of weapon: ");
            opt=readInt();
            switch (opt) {
                case 1:
                    type="sword";
                    System.out.println("You have been selected Sword!");
                    validOpt=true;
                    break;
                case 2:
                    type="axe";
                    System.out.println("You have been selected Axe!");
                    validOpt=true;
                    break;
                case 3:
                    type="wand";
                    System.out.println("You have been selected Wand!");
                    validOpt=true;
                    break;
                case 4:
                    type="bow";
                    System.out.println("You have been selected Bow!");
                    validOpt=true;
                    break;
            
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }
        return type;
    }

    public void showWeapons(ArrayList<Armes>allWeapons) {
        for (int i=0;i<allWeapons.size();i++) {
            System.out.println(allWeapons.get(i).toString());
        }
    }

    public void manualStats(int[] stats,String[] statsName) {
        int leftPoints=60;
        boolean validPoints=false;
        while (leftPoints!=0) {
            for (int i=0;i<stats.length;i++) {
                validPoints=false;
                System.out.println("Left points: "+leftPoints);
                while (!validPoints) {
                    System.out.print("\nPlease choose the amount of points of "+statsName[i]+" you want to add (5-20): ");
                    int num=readInt();
                    if (num+stats[i]>=5&&num+stats[i]<=20&&leftPoints-num>=0) {
                        stats[i]+=num;
                        leftPoints=leftPoints-num;
                        validPoints=true;
                    }
                }
            }
        }
        for (int i=0;i<statsName.length;i++) {
            System.out.println(statsName[i]+" have been set to "+stats[i]);
        }
    }

    public void autoStats(int[] stats, String[] statsName) {
        boolean validStats = false;
        while (!validStats) {

            int leftPoints = 60;

            for (int i = 0; i < stats.length; i++) {
                stats[i] = 0;
            }

            while (leftPoints > 0) {

                for (int i = 0; i < stats.length && leftPoints > 0; i++) {

                    int randNum = (int)(Math.random()*5)+1;

                    if (stats[i] + randNum <= 20 && leftPoints - randNum >= 0) {

                        stats[i] += randNum;
                        leftPoints -= randNum;

                    }
                }
            }

            validStats = true;

            for (int i = 0; i < stats.length; i++) {

                if (stats[i] < 5) {
                    validStats = false;
                    break;
                }
            }
        }

        for (int i = 0; i < statsName.length; i++) {
            System.out.println(statsName[i] + " have been set to " + stats[i]);
        }
    }

    public int setLuck() {
        int luck=(int)(Math.random()*3)+1;
        return luck;
    }
    // 1Luck -> 1/5 to 2x damage
    // 2Luck -> 1/4 to 2x damage
    // 3Luck -> 1/3 to 2x damage

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
