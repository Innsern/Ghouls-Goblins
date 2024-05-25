import javax.swing.ImageIcon;


public class Character {

    final String root = "Images/";
    final String ext = ".png";
    private String name;
    private ImageIcon icon;

    private int health;
    private int mana;
    private int str;
    private int dex;
    private int vit;
    private int mag;
    private int wil;
    private int lck;
    private int attack;
    private int accuracy;
    private int defense;
    private int evasion;
    private int magicDefense;
    private int magicEvasion;


    public Character() {
        this.name = "Default";
        this.icon = new ImageIcon(root+name+ext);
        this.str = 1;
        this.dex = 1;
        this.vit = 1;
        this.mag = 1;
        this.wil = 1;
        this.lck = 1;
    }
    public Character(String name, int str, int dex, int vit, int mag, int wil, int lck) {
        this.name = name;
        this.icon = new ImageIcon(root+name+ext);
        this.str = str;
        this.dex = dex;
        this.vit = vit;
        this.mag = mag;
        this.wil = wil;
        this.lck = lck;

        //attack =
    }


}
