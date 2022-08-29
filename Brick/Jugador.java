import greenfoot.*;  


public class Jugador extends Actor
{

    public Jugador()
    {
        getImage().setColor(Color.WHITE);
        getImage().fillRect(0, 0, 100, 20);
    }
    public void act() 
    {
        if(Greenfoot.isKeyDown("right"))
            setLocation(getX() + 6, getY());
        if(Greenfoot.isKeyDown("left"))
            setLocation(getX() - 6, getY());
    }    
}
