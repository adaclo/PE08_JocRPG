package Activitats.PE08_AcarretaAdrian.src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JocRPG {
    public static void main(String[] args) {
        JocRPG p = new JocRPG();
        p.principal();
    }

    public void principal() {
        Scanner s = new Scanner(System.in);
        ArrayList<Armes> allWeapons = new ArrayList<Armes>();
        ArrayList<Personatges> allCharacters = new ArrayList<Personatges>();
    }

    public int readInt(Scanner s) {
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
    public double readDouble(Scanner s) {
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
    public String readString(Scanner s) {
        String text="";
        boolean validNum=false;
        while (!validNum) {
            try {
                text=s.nextLine();
                validNum=true;
            } catch (InputMismatchException e) {
                System.out.println("(!) Please enter a valid num");
            }
        }
        return text;
    }
}
