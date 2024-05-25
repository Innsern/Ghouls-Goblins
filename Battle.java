import javax.swing.ImageIcon;
public class Battle {
    private ImageIcon background;
    private Monster mon;

    public Battle()
    {mon = null;
    background = null;}
    public Battle(ImageIcon back,Monster monster)
    {
        background = back;
        mon = monster;
    }
}
