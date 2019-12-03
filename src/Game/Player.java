package Game;

public class Player
{
	public static final int GUARD_COST = 100;
	public static final int ARCHER_COST = 200;
	public static final int EXECUTION_COST = 300;
	public static final int CATAPULT_COST = 500;
	public static final int WIZARD_COST = 1000;
    private int life,money;
    private boolean isAlive;
    /**
     * Constructor for objects of class Player
     */
    public Player(int inLife,int inMoney)
    {
        isAlive=true;
        if(inLife<=0)
            isAlive=false;
        life=inLife;
        money=inMoney;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public void setMoney(int m)
    {
        if(m>=0)
            money=m;
            else
            money=0;
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
    
    public boolean canBuyGuard() {
    	if(this.money >= GUARD_COST)
    		return true;
    	return false;
    }
    
    public boolean canBuyArcher() {
    	if(this.money >= ARCHER_COST)
    		return true;
    	return false;
    }
    
    public boolean canBuyExecutioner() {
    	if(this.money >= EXECUTION_COST)
    		return true;
    	return false;
    }
    
    public boolean canBuyCatapult() {
    	if(this.money >= CATAPULT_COST)
    		return true;
    	return false;
    }
    
    public boolean canBuyWizard() {
    	if(this.money >= WIZARD_COST)
    		return true;
    	return false;
    }
}