//Window is 15x23

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class GUI extends JFrame implements KeyListener
{
  private Map currMap;
  //private ImageIcon[][][] imageArr;
  //private int[][] animLengthArr;
  private MapLabel mapLabel;
  private Thread animator;
  public GUI(Map currMap)
  {

    this.currMap = currMap;
    ImageIcon[][][] imageArr = currMap.getImageArr();
    int[][] animLengthArr = currMap.getAnimLengthArr();

    mapLabel = new MapLabel(imageArr,animLengthArr);
    animator = new Thread(new FramePainter(mapLabel));
    animator.start();
    
    add(mapLabel);
    addKeyListener(this);
    pack();
    setVisible(true);
    System.out.println("constructor done");
  }

  @Override
  public void keyTyped(KeyEvent e){}

  @Override
  public void keyReleased(KeyEvent e){}

  @Override
  public void keyPressed(KeyEvent e) {
    int dir = 0;
    int keyCode = e.getKeyCode();
    switch (keyCode) {
      case 38:
        dir = 1;
        break;     //move up
      case 40:
        dir = 2;
        break;   //move down
      case 37:
        dir = 3;
        break;   //move left
      case 39:
        dir = 4;
        break;  //move right
    }
    //long startTime = System.nanoTime();
    Object response = currMap.move(dir);

    if (response instanceof Map)
    {
      System.out.println("Changing Maps!!");
      currMap = (Map) response;
    } else if (response instanceof Battle) {
      System.out.println("Battle Time!!");
    }

    ImageIcon[][][] imageArr = currMap.getImageArr();
    int[][] animLengthArr = currMap.getAnimLengthArr();
    mapLabel.update(imageArr,animLengthArr);
    //mapLabel.repaint();

    //long endTime = System.nanoTime();
    //double time = (endTime - startTime)/1.0;
  }

}