package Activitats.PE08_AcarretaAdrian.src;

public class Elf extends Personatges{
    public Elf(int ID,String type,String name,int age,double health,int mana,int strength,int dexterity,int constitution,int intelligence,int wisdom,int charisma,int luck) {
        super(ID, type, name, age, health, mana, strength, adjustStat(dexterity), constitution, adjustStat(intelligence), wisdom, charisma, luck);
    }

    public static int adjustStat(int stat) {
        if ((stat+2)<=20)
            stat+=2;
        else
            stat=20;
        return stat;
    }

    @Override
    public void regenMana() {
        int maxMana=getIntelligence()*30;
        int expectedMana=getMana()+getIntelligence()*3;
        if (expectedMana>maxMana) {
            setMana(maxMana);
        } else {
            setMana(expectedMana);
        }
    }
}
