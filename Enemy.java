package CS211FINAL;

import java.awt.Point;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Thread
{
    private int locX,locY,life,damage,speed,dps;
    private Point[] targets;
    private int currTarget;
    boolean alive;
    long delay;
    private Player target;
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
    public Enemy(int x,int y,int inLife,int inDamage,int inSpeed,int inDps,Point[]inTargets, Player inP)
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
        delay=50;
        target=inP;
    }

    public void run(){
        while(alive()){
            move();
            try{sleep(delay);}catch(Exception e){}
        }
    }

    protected void setCurrTargetIndex(int i)
    {
        if(i>=0&&i<targets.length)
            currTarget=i;
    }

    public int getX(){return locX;}

    public int getY(){return locY;}

    public void move()
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
                delay=8000/dps;
                attack(target);
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

    public abstract void ability();

    public abstract String toString();
}
