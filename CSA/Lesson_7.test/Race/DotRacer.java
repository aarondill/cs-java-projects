public class DotRacer
{
    private int position;
    private final int STEPSIZE = 1; //make step size a constant
    private String name;
        
    public DotRacer(String name)//change parameters to just name
    {
    	position = 0;//always set position to 0
    	this.name = name;//Assign name
    }
    
    public DotRacer() 
    {
        position = 0;//do not set the step size        
    }
    
    public int getPosition() 
    {
        return position;
    }
    
    public int getStepSize()
    {
    	return STEPSIZE;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void move()
    {
        int numSteps = (int)(Math.random() * 11); //ensure that DotRacer always goes forward
        position += numSteps * STEPSIZE;
    }
    
    //Remove setStepSize method
        
    public String toString()
    {
    	return name + " is at position: " + position;
    }    
}


