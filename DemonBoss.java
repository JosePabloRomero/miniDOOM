import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DemonBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemonBoss extends Actor
{
    public static final int NUMERO_IMAGENES = 6;
    public static final int NUMERO_IMAGENES_ATAQUE = 6;
    public static final int ITERACIONES_ANIMACION = 5;
    public static final int VELOCIDAD = 5;
    
    private int velocidadX = 3;
    private int velocidadY = 0;
    
    
    private GreenfootImage[] imagenesMovimiento;
    private GreenfootImage[] imagenesAtaque;
    
    private int indiceAnimacion;
    private int contadorIteraciones;
    private int direccion;  
    
    private Dante dante;
    
    
    public DemonBoss(Dante dante)
    {
        imagenesMovimiento = new GreenfootImage[NUMERO_IMAGENES];
        imagenesAtaque = new GreenfootImage[NUMERO_IMAGENES_ATAQUE];
        
        for(int i = 0; i < NUMERO_IMAGENES; i++)
        {
            imagenesMovimiento[i] = new GreenfootImage("Demon1Move" + i + ".png" );
            imagenesAtaque[i] = new GreenfootImage("Demon1Attack" + i + ".png" );
        }        
        this.dante = dante;
        indiceAnimacion = 0;
        contadorIteraciones = 0;
        setImage(imagenesMovimiento[0]);        
       
    }
    public void mover()
    {
        int x = getX();
        int y = getY();
        setLocation( x + velocidadX, y + velocidadY );
        
    }
    
    public void animarMovimiento()
    {
        if( contadorIteraciones >= ITERACIONES_ANIMACION )
        {
            if( indiceAnimacion < NUMERO_IMAGENES-1 )
            {
                indiceAnimacion++;
            } else {
                indiceAnimacion = 0;
            }
            setImage( imagenesMovimiento[indiceAnimacion] );
            contadorIteraciones = 0;
        } else {
            contadorIteraciones++;
        }
    }
    
    public void animarAtaque()
    {        
        if( contadorIteraciones >= ITERACIONES_ANIMACION )
        {
            if( indiceAnimacion < NUMERO_IMAGENES-1 )
            {
                indiceAnimacion++;
            } else {
                indiceAnimacion = 0;
            }
            setImage( imagenesAtaque[indiceAnimacion] );
            contadorIteraciones = 0;
        } else {
            contadorIteraciones++;
        }
    }
    
    public void intentarMover()
    {       
        int xDante = dante.getX();
        int yDante = dante.getY();
        int x = getX();
        int y = getY();
        
        if( Greenfoot.getRandomNumber(10) < 2 )
        {
            if( velocidadX == 0 )
            {
                int temp = velocidadX;
                velocidadX = velocidadY;
                velocidadY = temp;
            }
            
            if( xDante - x > 0 ) //Dante está a la derecha del demonio
            {
                if( velocidadX < 0 )
                {
                    velocidadX = velocidadX * -1;
                }
            } else { //Dante está a la izquierda del demonio
                if( velocidadX > 0 ) 
                {
                    velocidadX = velocidadX * -1;
                }
            }
        } else if ( Greenfoot.getRandomNumber(10) < 2 ) {
            if( velocidadY == 0 )
            {
                int temp = velocidadX;
                velocidadX = velocidadY;
                velocidadY = temp;
            }
            
            if( yDante - y > 0 )
            {
                if( velocidadY < 0 )
                {
                    velocidadY = -velocidadY;
                }
            } else if( velocidadY > 0 )
            {
                velocidadY = -velocidadY;
            }
        }       
    }
   
    
    public void act() 
    {
        animarMovimiento();
        mover();
        intentarMover();
    }    
}
