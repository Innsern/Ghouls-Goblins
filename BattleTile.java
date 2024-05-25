import java.awt.*;
import javax.swing.ImageIcon;

public class BattleTile extends Tile{
    public BattleTile(String file, String[] name, char cli,boolean walk)
    {
        super(file, name, cli, walk);
    }
    @Override
    public Object behavior()
    {

        //sort trough enemy table to pick one enemy
            //ImageIcon background = new ImageIcon(super.root+super.title+"BackGround"+super.ext);
        //invoke battle and pass background and enemy in
            //Monster monster = new Monster();
            //return new Battle(background,monster);
        return new Battle();
    }
}
