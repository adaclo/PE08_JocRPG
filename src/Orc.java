package Activitats.PE08_AcarretaAdrian.src;

public class Orc extends Personatges {
    public Orc (int ID,String type,String name,int age,double health,int mana,int strength,int dexterity,int constitution,int intelligence,int wisdom,int charisma,int luck) {
        super(ID, type, name, age, health, mana, adjustStat(strength,'s'), dexterity, adjustStat(constitution,'c'), intelligence, wisdom, charisma, luck);
    }

    public static int adjustStat(int stat,char name) {
        if (name=='s'&&(stat+3)<=20)
            stat+=3;
        else if (name=='c'&&(stat+1)<=20)
            stat+=1;
        return stat;
    }

    @Override
    public boolean setActiveWeapon(Armes activeWeapon) {
        boolean didChange=false;
        if (activeWeapon.getIsMagic()) {
            System.out.println("Orcs cannot equip magic weapons");
        } else {
            didChange=super.setActiveWeapon(activeWeapon);
        }
        return didChange;
    }

    @Override
    public double calcDamage() {
        return super.calcDamage()*1.1;
    }
}
