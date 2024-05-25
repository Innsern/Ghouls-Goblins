public class TransferTile extends Tile{
    private Map nextMap;
    public TransferTile() {
        super("Default", new String[]{"Default"}, ' ', true);
        nextMap = null;
    }

    public TransferTile(String file, String[] name, char cli, Map nMap) {
        super(file, name, cli, true);
        nextMap = nMap;
    }

    @Override
    public Object behavior() {
        return nextMap;
    }
}
