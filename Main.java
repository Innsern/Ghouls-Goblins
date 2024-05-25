// java Main (build)

class Main {
  public static void main(String[] args) {
    
    Serializer mySerial = new Serializer();
    if (args.length == 1 && args[0].equals("build"))
    {
      System.out.println("started building");
      MapGenerator myGen = new MapGenerator();
      Map myMap = myGen.generate();
      System.out.println(myMap);
      mySerial.serializeDataOut(myMap);
      
    } else 
    {
      Map myMap = mySerial.serializeDataIn();
      System.out.print(myMap.getRow());
      System.out.println(myMap.getCol());
      System.out.println(myMap);
      myMap.setPlayer(13,22);
      GUI myGUI = new GUI(myMap);
    }

    
    
    
    
  }
}