public class BaseTile extends Tile
{
    public BaseTile()
    {
        super ("Default", new String[]{"Default"},' ', false);
    }
    public BaseTile(String file, String[] name, char cli,boolean walk)
    {
        super(file, name, cli, walk);
    }
    @Override
    public Object behavior()
    {return null;}
}
