public class FramePainter implements Runnable{
    private MapLabel mapLabel;

    public FramePainter(MapLabel mLabel)
    {
        mapLabel = mLabel;
    }

    public void run(){
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 24.0;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){

                mapLabel.repaint();



                delta--;
            }
        }
    }
}
