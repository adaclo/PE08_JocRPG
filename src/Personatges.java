package Activitats.PE08_AcarretaAdrian.src;

public class Personatges {
    private int ID;
    private String type;
    private String name;
    private int age;
    private double health;
    private int mana;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int luck;
    private Armes activeWeapon;
    
    public void setID(int ID) {
        this.ID=ID;
    }

    public int getID() {
        return this.ID;
    }
    
    public void setType(String type) {
        this.type=type;
    }

    public String getType() {
        return this.type;
    }
    
    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setAge(int age) {
        this.age=age;
    }

    public int getAge() {
        return this.age;
    }
    
    public void setHealth(double health) {
        this.health=health;
    }

    public double getHealth() {
        return this.health;
    }

    public void setDefaultHealth() {
        this.health=this.constitution*50;
    }
    
    public void setMana() {
        this.mana=this.intelligence*30;
    }

    public int getMana() {
        return this.mana;
    }
    
    public void setStrength(int strength) {
        this.strength=strength;
    }

    public int getStrength() {
        return this.strength;
    }
    
    public void setDexterity(int dexterity) {
        this.dexterity=dexterity;
    }

    public int getDexterity() {
        return this.dexterity;
    }
    
    public void setConstitution(int constitution) {
        this.constitution=constitution;
    }

    public int getConstitution() {
        return this.constitution;
    }
    
    public void setIntelligence(int intelligence) {
        this.intelligence=intelligence;
    }

    public int getIntelligence() {
        return this.intelligence;
    }
    
    public void setWisdom(int wisdom) {
        this.wisdom=wisdom;
    }

    public int getWisdom() {
        return this.wisdom;
    }
    
    public void setCharisma(int charisma) {
        this.charisma=charisma;
    }

    public int getCharisma() {
        return this.charisma;
    }
    
    public void setActiveWeapon(Armes activeWeapon) {
        if (activeWeapon.getIsMagic()==true&&getIntelligence()<10) {
            System.out.println("You cannot equip this weapon, needed intelligence >=10");
        } else {
            this.activeWeapon=activeWeapon;
        }
    }

    public Armes getActiveWeapon() {
        return this.activeWeapon;
    }
    
    public void setLuck(int luck) {
        this.luck=(int)(Math.random()*3)+1;
    }

    public int getLuck() {
        return this.luck;
    }

    public int calcDamage(int damage) {
        if (didDodge()) {
            damage=0;
        }
        return damage;
    }

    public boolean didDodge() {
        boolean dodge = false;
        int randomNum = (int)(Math.random()*2);
        if (randomNum==0) {
            dodge=true;
        }
        return dodge;
    }

    public void regenHealth() {
        double maxHealth=this.constitution*50;
        double expectedHealth=this.health+this.constitution*3;
        if (expectedHealth>maxHealth) {
            this.health=maxHealth;
        } else {
            this.health=expectedHealth;
        }
    }

    public String toString() {
        String info="";
        info="ID="+this.ID+"\nType="+this.type+"\nName="+this.name+"\nAge="+this.age+"\nHealth="+this.health+"\nMana="+this.mana+"\nStrength="+this.strength+"\nDexterity="+this.dexterity+"\nConstitution="+this.constitution+"\nIntelligence="+this.intelligence+"\nWisdom="+this.wisdom+"\nLuck="+this.luck+"\nCharisma="+this.charisma+"\nWeapon="+this.activeWeapon;
        return info;
    }
}
