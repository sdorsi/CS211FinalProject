package CS211FINAL;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
public class Game extends JFrame implements Runnable
{
    //Image pic;
    Enemy enemies[];
    Thread main;
    Player player;
    Point nodes[]={new Point(20,0),new Point(20,350),new Point(500,350),new Point(500,400)};//either x or y val of each node should match next one for straight pathing lines

    private Game()
    {
        super("Tower Defense Final Project");
        setSize(1300,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        player=new Player(100);
        enemies=new Enemy[5];
        enemies[0]=new Brawler(0,0,nodes,player);//Enemy(1,1,5,5,5,5,nodes);
        enemies[1]=new Knight(0,0,nodes,player);
        enemies[2]=new Thief(0,0,nodes,player);
        enemies[3]=new Cavalry(0,0,nodes,player);
        enemies[4]=new Dragon(0,0,nodes,player);
        //We can make an array of enemies and set them all to those params since they all share methods.

        main=new Thread(this);
        main.start();

        //in array
        for(Enemy e:enemies)
            e.start();
        //pic=new ImageIcon("myPic.png").getImage();//used to get picture file in JFrame
    }

    public void run()
    {
        while(true)
        {
            repaint();
            try
            {
                main.sleep(10);
            } 
            catch(Exception e){} 

        }
    }

    public static void main(String args[])
    {
        new Game().setVisible(true);//creates game window and runs its constructor
    }

    public void paint(Graphics g)
    {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();//all code above in paint() used for double buffering JFrame
        //Graphics start
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());//background created so the repaint() function works, not duplicating image
        g.setColor(Color.red);
        if(player.isAlive())
            g.fillRect(500,400,20+3*player.getLife(),20);//main base
        g.setColor(Color.black);
        for( Point p:nodes)
            g.fillRect((int)p.getX(),(int)p.getY(),10,10);
        for(Enemy e:enemies)        
            g.drawRect(e.getX(),e.getY(),50,50);
        //Graphics end
        bs.show();
    }   

}
