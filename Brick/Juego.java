import greenfoot.*; 

public class Juego extends World
{

    public Jugador jugador = new Jugador();
    public Juego()
    {    
        super(600, 600, 1);
        prepare();
    }
    
    public void prepare()
    {
        getBackground().setColor(Color.BLUE);
        getBackground().fill();
        addObject(jugador, 300, 550);
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 4; j++)
            addObject(new Bloque(), 55 + 70 * i, 20 + 30 * j);
        Ball ball = new Ball(jugador,this);
        addObject(ball, 300, 450);
    }
}
