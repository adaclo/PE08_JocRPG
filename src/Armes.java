package Activitats.PE08_AcarretaAdrian.src;

public class Armes {
    private int ID;
    private String type;
    private int damage;
    private boolean isMagic;

    public Armes() {

    }

    public Armes(int ID,String type,int damage,boolean isMagic) {
        this.ID=ID;
        this.type=type;
        this.damage=damage;
        this.isMagic=isMagic;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID=ID;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type=type;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage=damage;
    }

    public boolean getIsMagic() {
        return this.isMagic;
    }

    public void setIsMagic(boolean isMagic) {
        this.isMagic=isMagic;
    }
    
}


