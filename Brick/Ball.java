import greenfoot.*;  

public class Ball extends Actor
{
    
    int dy = 5;
    int dx = 0;
    int count = 0;
    public Jugador jugador;
    public World myWorld;
    public Ball(Jugador jugador, World world)
    {
        myWorld = world;
        this.jugador = jugador;
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
    public void act() 
    {
        moverse();
        bounce();
        rebota();
        pegar();
        perder();
        ganar();
    }
    public void moverse()
    {
        setLocation(getX() + dx, getY() + dy);
    }
    public void bounce()
    {
        if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 50)
        {
            dy = -dy;
            dx-= 6;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 50)
        {
            dy = -dy;
            dx+= 6;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 40)
        {
            dy = -dy;
            dx-= 5;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 40)
        {
            dy = -dy;
            dx+= 5;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 30)
        {
            dy = -dy;
            dx-= 4;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 30)
        {
            dy = -dy;
            dx+= 4;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 20)
        {
            dy = -dy;
            dx-= 3;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 20)
        {
            dy = -dy;
            dx+= 3;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() > getX() + 10)
        {
            dy = -dy;
            dx-= 2;
        }
        else if(isTouching(Jugador.class) && this.jugador.getX() < getX() - 10)
        {
            dy = -dy;
            dx+= 2;
        }
        else if((isTouching(Jugador.class) || isTouching(Bloque.class)))
        {
            dy = -dy;
        }
    }
    public void rebota()
    {
        if(getX() >= getWorld().getWidth() - 1)
        {
            dx = -dx;
        }
        if(getX() <= 0)
        {
            dx = -dx;
        }
        if(getY() <= 0)
            dy = -dy;
        if(getY() >= getWorld().getHeight() -1)
            dy = -dy;
    }
    public void pegar()
    {
        Actor bloque = getOneIntersectingObject(Bloque.class);
        if(bloque != null && bloque.getX() > getX() + 30)
        {
            getWorld().removeObject(bloque);
            dx = -dx;
            count++;
        }
        else if(bloque != null && bloque.getX() < getX() - 30)
        {
            getWorld().removeObject(bloque);
            dx = -dx;
            count++;
        }
        else if(bloque != null)
        {
            getWorld().removeObject(bloque);
            count++;
        }
    }
    public void perder()
    {
        if(getY() >= getWorld().getHeight() -1)
        {
            Greenfoot.stop();
            getWorld().showText("PERDISTE JEJEJE", getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }
    public void ganar()
    {
        if(count == 32)
        {
            Greenfoot.stop();
            getWorld().showText("Ganasteeee!!", getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }
}
