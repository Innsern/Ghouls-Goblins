// 15x23

import java.io.Serializable;
public class MapGenerator implements Serializable
{
  private Map map;

  final Tile def = new BaseTile ();
  final Tile grass = new BaseTile ("Open",new String[]{"Grass"}, '-',true);
  final Tile mountain = new BaseTile ("Open",new String[]{"Mountain"},'#',false);
  final Tile water = new BaseTile ("Open",new String[]{"Water"}, '~',false);
  final Tile tallGrass = new BattleTile ("Open",new String[]{"TallGrass"}, '/', true);
  
  public MapGenerator()
  {
    map = new Map(27,45);
  }

  public Map generate()
  { 
    Tile currTile;
    boxPrint(0,27,0,45,def);
    boxPrint(6,21,11,34,mountain);
    boxPrint(7,20,12,33,grass);
    boxPrint(11,15,16,21,water);
    boxPrint(17,20,21,33,tallGrass);

    return map;
  }
  
  public void boxPrint(int startRow, int stopRow, int startCol, int stopCol, Tile tile)
  {
    for (int i = startRow; i < stopRow; i++)
    {
      for (int j = startCol; j < stopCol; j++)
      {
        map.setTile(i,j,tile);
      }
    }
  }
  
}