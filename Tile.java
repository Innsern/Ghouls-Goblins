import javax.swing.ImageIcon;
import java.io.Serializable;

public abstract class Tile implements Serializable
{
  final String ROOT = "Images/";
  final String EXT = ".png";

  protected String title;
  private char cli;
  private ImageIcon[] anim;
  private int animLength;
  private boolean walkable;
  
  //intent??

  public Tile (String file,String[] name,char cli,boolean walk) {
    title = file;
    this.cli = cli;

    anim = new ImageIcon[24];
    animLength = name.length;
    for (int i = 0; i < animLength; i++)
    {
      anim[i] = new ImageIcon(ROOT + file + "/" + name[i] + EXT);
    }

    walkable = walk;
  }

  public String getTitle()
  {
    return title;
  }
  
  public char getCLI()
  {
    return cli;
  }

  public ImageIcon[] getAnim()
  {
    return anim;
  }

  public int getAnimLength() {return animLength;}

  public boolean isWalkable()
  {
    return walkable;
  }

  abstract Object behavior();
}

