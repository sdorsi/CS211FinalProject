package Enemies;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import Game.Player;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Thread
{
	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;
    private int locX,locY,life,damage,speed,dps;
    private Point[] targets;
    private int currTarget;
    protected boolean alive;
    private Player target;
    private int attackCt;
    protected boolean attacking;
    private ImageIcon myImage;
    /**
     * Constructor for objects of class Enemy
     * 
     * @param x    X-Coordinate on the screen
     * @param y    Y-Coordinate on the screen
     * @param inLife   sets the Enemy's life
     * @param inDamage   sets the Enemy's damage toward player's base
     * @param inSpeed   sets the Enemy's speed that it travels
     * @param inDps   sets the Enemy's damage it deals per second
     * @param inTarget   an array of coordinate points called targets[] that act as checkpoints for the enemy to travel in
     */
    public Enemy(int x,int y,int inLife,int inDamage,int inSpeed,int inDps,Point[]inTargets, Player inP, ImageIcon img)
    {
        locX=x;
        locY=y;
        life=inLife;
        damage=inDamage;
        speed=inSpeed;
        dps=inDps;
        targets=new Point[inTargets.length];
        for(int i=0;i<targets.length;i++)
        {
            targets[i]=inTargets[i];
        }
        currTarget=0;
        alive=true;
        target=inP;
        attacking=false;
        attackCt=1;//delay for attacking at dps
        this.myImage = img;
    }

    public void run(){
        while(true){
            if(alive())
                move();
            ability();
            try{sleep(100);}catch(Exception e){}
        }
    }

    protected void setCurrTargetIndex(int i)
    {
        if(i>=0&&i<targets.length)
            currTarget=i;
    }

    public int getX(){return locX;}

    public int getY(){return locY;}

    public void setX(int x)
    {
        if(x>=0)
            locX=x;
    }

    public void setY(int y)
    {
        if(y>=0)
            locY=y;
    }

    private void move()
    {
        boolean xReady=false,yReady=false;

        if(alive())
        {
            if(currTarget<targets.length && targets[currTarget]!=null)//if this has not hit all target nodes yet
            {
                if(targets[currTarget].getX()-locX >4)
                    locX=(locX+speed);

                else if(targets[currTarget].getX()-locX <-4)
                    locX=(locX-speed);
                else
                    xReady=true;

                if(targets[currTarget].getY()-locY>4)
                    locY=(locY+speed);

                else if(targets[currTarget].getY()-locY<-4)
                    locY=(locY-speed);
                else
                    yReady=true;
                if(xReady&&yReady)
                    currTarget++;
            }
            else//attack player base
            {
                attacking=true;
                if(100/attackCt<=dps)
                {
                    attackCt=1;
                    attack(target);
                }
                else
                    attackCt++;

            }
        }
    }

    public int getLife()
    {
        return life;
    }

    public void setLife(int inLife)
    {
        if(inLife<1)
        {
            life=0;
        }
        else
            life=inLife;
    }

    protected void setSpeed(int s)
    {
        speed=s;
    }

    protected int getSpeed()
    {
        return speed;
    }

    public boolean alive()
    {
        if(life<1)
            alive=false;
        else
            alive=true;
        return alive;
    }

    public void attack(Player p)
    {
        p.setLife(p.getLife()-damage);
    }

    public void draw(Graphics g) {
    	g.drawImage(this.myImage.getImage(), this.locX - (WIDTH / 2), this.locY - (HEIGHT), WIDTH, HEIGHT, null);
    }

    public abstract void ability();

    public abstract String toString();
}
