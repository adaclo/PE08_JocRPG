package Activitats.PE08_AcarretaAdrian.src;

public class Dwarf extends Personatges {
    public Dwarf (int ID,String type,String name,int age,double health,int mana,int strength,int dexterity,int constitution,int intelligence,int wisdom,int charisma,int luck) {
        super(ID, type, name, age, health, mana, strength, adjustStat(dexterity,'d'), adjustStat(constitution,'c'), intelligence, wisdom, charisma, luck);
    }

    public static int adjustStat(int stat, char name) {
        if (name=='d'&&(stat+1)<=20)
            stat+=1;
        else if (name=='c'&&(stat+4)<=20)
            stat+=4;
        return stat;
    }
}
