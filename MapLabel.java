import java.awt.*;
import javax.swing.*;

public class MapLabel extends JLabel
{
  private int frame;
  private ImageIcon[][][] imageArr;
  private int[][] animLengthArr;
  //final ImageIcon rat = new ImageIcon("Images/Rat/Rat.png");
  final ImageIcon[] rat = {new ImageIcon("Images/Rat/Rat1.png"),
          new ImageIcon("Images/Rat/Rat1.png"),
          new ImageIcon("Images/Rat/Rat2.png"),
          new ImageIcon("Images/Rat/Rat2.png"),
          new ImageIcon("Images/Rat/Rat3.png"),
          new ImageIcon("Images/Rat/Rat3.png"),
          new ImageIcon("Images/Rat/Rat2.png"),
          new ImageIcon("Images/Rat/Rat2.png"),
          new ImageIcon("Images/Rat/Rat4.png"),
          new ImageIcon("Images/Rat/Rat4.png"),
          new ImageIcon("Images/Rat/Rat5.png"),
          new ImageIcon("Images/Rat/Rat5.png"),
          new ImageIcon("Images/Rat/Rat6.png"),
          new ImageIcon("Images/Rat/Rat6.png"),
          new ImageIcon("Images/Rat/Rat5.png"),
          new ImageIcon("Images/Rat/Rat5.png")};
  final ImageIcon def = new ImageIcon("Images/Default/Default.png");
  public MapLabel (ImageIcon[][][] images, int[][] lengthArr)
  {
    frame = 0;
    setPreferredSize(new Dimension(23*64,15*64));
    imageArr = images;
    animLengthArr = lengthArr;
  }

  public void update(ImageIcon[][][] images, int[][] lengthArr)
  {
    imageArr = images;
    animLengthArr = lengthArr;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    for (int i = 0; i < imageArr.length; i++){
      for (int j = 0; j < imageArr[0].length;j++)
      {
        imageArr[i][j][frame%animLengthArr[i][j]].paintIcon(this,g,j*64,i*64);
      }
    }
    rat[frame%rat.length].paintIcon(this,g,11*64,7*64);

    frame++;
    if (frame >= 256)
          frame = 0;
  }
}