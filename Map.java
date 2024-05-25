import javax.swing.ImageIcon;
import java.io.Serializable;

public class Map implements Serializable
{
  private int maxRow;
  private int maxCol;

  private int playerRow;
  private int playerCol;

  final int VIEWROW = 15;
  final int VIEWCOL = 23;

  private Tile[][] map;

  private ImageIcon[][][] imageArr;
  //[col][row][frame]
  private int[][] animLengthArr;

  public Map(int row, int col)
  {
    //playerRow = 0;
    //playerCol = 0;
    maxRow = row;
    maxCol = col;
    map = new Tile[maxRow][maxCol];
    imageArr = new ImageIcon[VIEWROW][VIEWCOL][24];
    animLengthArr = new int[VIEWROW][VIEWCOL];

    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        map[i][j] = new BaseTile();
      }
    }
  }

  public Object move(int dir)
  {
    int newPlayerRow = 0;
    int newPlayerCol = 0;
    switch (dir)
    {
      case 1: newPlayerRow = playerRow - 1; newPlayerCol = playerCol; break;
      case 2: newPlayerRow = playerRow + 1; newPlayerCol = playerCol; break;
      case 3: newPlayerRow = playerRow; newPlayerCol = playerCol - 1; break;
      case 4: newPlayerRow = playerRow; newPlayerCol = playerCol + 1; break;
    }
    Tile newTile = map[newPlayerRow][newPlayerCol];
    if (newTile.isWalkable())
    {
      playerRow = newPlayerRow;
      playerCol = newPlayerCol;
      ImageIcon[][][] newImageArr = new ImageIcon[VIEWROW][VIEWCOL][24];
      int[][] newAnimLengthArr = new int[VIEWROW][VIEWCOL];
      switch(dir)
      {
        case 1:
          for(int i = 0; i < VIEWCOL; i++)
          {
            newImageArr[0][i] = map[playerRow-((VIEWROW-1 )/2)][i+playerCol-((VIEWCOL-1)/2)].getAnim();
            newAnimLengthArr[0][i] = map[playerRow-((VIEWROW-1 )/2)][i+playerCol-((VIEWCOL-1)/2)].getAnimLength();}
          for(int i = 1; i < VIEWROW; i++)
          {
            newImageArr[i] = imageArr[i-1].clone();
            newAnimLengthArr[i] = animLengthArr[i-1].clone();
          }
          break;
        case 2:
          for(int i = 0; i < VIEWCOL; i++)
          {
            newImageArr[VIEWROW-1][i] = map[VIEWROW-1+playerRow-((VIEWROW-1 )/2)][i+playerCol-((VIEWCOL-1)/2)].getAnim();
            newAnimLengthArr[VIEWROW-1][i] = map[VIEWROW-1+playerRow-((VIEWROW-1 )/2)][i+playerCol-((VIEWCOL-1)/2)].getAnimLength();}
          for(int i = 0; i < VIEWROW-1; i++)
          {
            newImageArr[i] = imageArr[i+1].clone();
            newAnimLengthArr[i] = animLengthArr[i+1].clone();
          }
          break;
        case 3:
          for(int i = 0; i < VIEWROW; i++)
          {
            newImageArr[i][0] = map[i+playerRow-((VIEWROW-1 )/2)][playerCol-((VIEWCOL-1)/2)].getAnim();
            newAnimLengthArr[i][0] = map[i+playerRow-((VIEWROW-1 )/2)][playerCol-((VIEWCOL-1)/2)].getAnimLength();
            System.arraycopy(imageArr[i],0,newImageArr[i],1,VIEWCOL-1);
            System.arraycopy(animLengthArr[i],0,newAnimLengthArr[i],1,VIEWCOL-1);
          }
          break;
        case 4:
          for(int i = 0; i < VIEWROW; i++)
          {
            newImageArr[i][VIEWCOL-1] = map[i+playerRow-((VIEWROW-1 )/2)][VIEWCOL-1+playerCol-((VIEWCOL-1)/2)].getAnim();
            animLengthArr[i][0] = map[i+playerRow-((VIEWROW-1 )/2)][playerCol-((VIEWCOL-1)/2)].getAnimLength();
            System.arraycopy(imageArr[i],1,newImageArr[i],0,VIEWCOL-1);
            System.arraycopy(animLengthArr[i],1,newAnimLengthArr[i],0,VIEWCOL-1);
          }
          break;
      }
      imageArr = newImageArr;
    }
    return newTile.behavior();
    //return null;
  }

  public void setTile(int row, int col,Tile newTile)
  {
    map[row][col]=newTile;
  }

  public void setPlayer(int row, int col)
  {
    playerRow = row;
    playerCol = col;

    for (int i = 0; i < VIEWROW; i++)
    {
      for (int j = 0; j < VIEWCOL; j++)
      {
        imageArr[i][j] = map[i+playerRow-((VIEWROW-1 )/2)][j+playerCol-((VIEWCOL-1)/2)].getAnim();
        animLengthArr[i][j] = map[i+playerRow-((VIEWROW-1 )/2)][j+playerCol-((VIEWCOL-1)/2)].getAnimLength();
      }
    }
  }
  public Tile getTile(int row, int col)
  {
    return map[row][col];
  }

  /*public ImageIcon[][] getImageArr()
  {
    ImageIcon[][] result= new ImageIcon[VIEWROW][VIEWCOL];

    for (int i = 0; i < VIEWROW; i++)
    {
      for (int j = 0; j < VIEWCOL; j++)
      {
        //System.out.println(i+playerRow-((VIEWCOL-1)/2)+", "+(j+playerCol-((VIEWROW-1)/2)));
        result[i][j] = map[i+playerRow-((VIEWROW-1 )/2)][j+playerCol-((VIEWCOL-1)/2)].getIcon();
      }
    }
    return result;
  }*/


  public ImageIcon[][][] getImageArr()
  {
    return imageArr;
  }

  public int[][] getAnimLengthArr() {return animLengthArr;}
  public int getRow()
  {
    return playerRow;
  }

  public int getCol()
  {
    return playerCol;
  }
  
  public String toString()
  {
    String result = "";

    for (int i = 0; i < maxRow; i++)
    {
      for (int j = 0; j < maxCol; j++)
      {
        result += map[i][j].getCLI();
      }
      result += "\n";
    }
    return result;
  }
}