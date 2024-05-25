//tool

import java.util.Scanner;

public class Inspect
{
  private Tile[][] TileArr;
  
  public Inspect(Tile[][] arr)
  {
    TileArr = arr;
    int[] index = Input();
    search(index);
  }

  private int[] Input()
  {
    Scanner in = new Scanner(System.in);
    int[] result = new int[2];

    do {
    System.out.println("Input the desired row:");
    result[0] = in.nextInt();
    } while (result[0] < 0 || result[0] > TileArr.length);

    do {
    System.out.println("Input desired col:");
    result[1] = in.nextInt();
    } while (result[1] < 0 || result[1] > TileArr.length);

    return result;
  }
  
  private Tile search(int[] index)
  {
    int r = index[0];
    int c = index[1];

    return TileArr[r][c];
  }
}