import java.io.*;

public class Serializer implements Serializable
{
  public static void serializeDataOut(Map map)
  {
    String filename = "Test.txt";
    try (FileOutputStream fos = new FileOutputStream(filename);
      ObjectOutputStream oos = new ObjectOutputStream(fos);)
    {
      oos.writeObject(map);
      oos.close();
    }
    catch(FileNotFoundException fnde)
    {
      System.out.println("FileNotFoundException thrown on data out");
    }
    catch (IOException e)
    {
      System.out.println("IOException thrown on data out");
    }
  }

  public static Map serializeDataIn()
  {
    
    String filename = "Test.txt";
    Map map = null;
    try (FileInputStream fin = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fin);)
    {
    
    map = (Map) ois.readObject();
    ois.close();
    }
    catch (IOException ioe)
    {
      System.out.println("IOException thrown on data in");
    }
    catch (ClassNotFoundException cnfe)
    {
      System.out.println("ClassNotFoundException thrown on data in");
    }
    return map;
  }
}