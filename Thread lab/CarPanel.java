package lab9;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;



public class CarPanel extends JComponent
{
    private Car car1;
    private int x,y, delay;
    private CarQueue carQueue;
    private int direction;
    
    CarPanel(int x1, int y1, int d, CarQueue queue)
    {
        delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
    }
    
    public void startAnimation()
    {
        class AnimationRunnable implements Runnable
        {
            public void run()
            {
                try
                {
                    for(int i=0;i<10;i++)
                    {
                        direction = carQueue.deleteQueue();

                        

                        switch(direction) {
                            case(0): y = !(y > 380) ? y + 10 : 0; break;
                            case(1): y = !(y < 20) ? y - 10 : 0; break;
                            case(2): x = !(x > 280) ? x + 10 : 0; break;
                            case(3): x = !(x < 20) ? x - 10 : 0; break;
                        } repaint();
                        Thread.sleep(delay*1000);

                    }
                }
                catch (InterruptedException exception)
                {

                }
                finally
                {

                }
            }
        }

        Runnable r = new AnimationRunnable();
        Thread t = new Thread(r);
        t.start();
    }


   
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        car1.draw(g2,x,y);
    }
}