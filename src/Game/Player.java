package Game;

public class Player
{
    private int life;
    private boolean isAlive;
    /**
     * Constructor for objects of class Player
     */
    public Player(int inLife)
    {
        isAlive=true;
        if(inLife<=0)
            isAlive=false;
        life=inLife;
    }

    public int getLife()
    {
        return life;
    }

    public void setLife(int inLife)
    {
        if(inLife<=0)
            isAlive=false;
        life=inLife;
    }

    public boolean isAlive()
    {
        isAlive=true;
        if(life<=0)
            isAlive=false;
        return isAlive;
    }
}
