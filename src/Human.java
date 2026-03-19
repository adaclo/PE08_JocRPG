package Activitats.PE08_AcarretaAdrian.src;

public class Human extends Personatges {
    public Human(int ID,String type,String name,int age,double health,int mana,int strength,int dexterity,int constitution,int intelligence,int wisdom,int charisma,int luck) {
        super(ID, type, name, age, health, mana, adjustStat(strength), adjustStat(dexterity), adjustStat(constitution), adjustStat(intelligence), adjustStat(wisdom), adjustStat(charisma), luck);
    }

    private static int adjustStat(int stat) {
        if (stat<20)
            stat++;
        return stat;
    }
}
