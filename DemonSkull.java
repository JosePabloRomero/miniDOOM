import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dante es el personaje principal del juego.
 * 
 * @Jose Pablo Romero Arcila - Anderson Rodriguez 
 * @Version 1.0
 */
public class DemonSkull extends Actor
{
    public static final int NUMERO_IMAGENES = 8;
    public static final int ITERACIONES_ANIMACION = 8;
    public static final int PROBABILIDAD_GIRO = 10;
    
    private int indiceAnimacion;
    private int contadorIteraciones;
    private int direccion;
    private int velocidadX = 3;
    private int velocidadY = 0;
    
    private Dante dante;
    
    
    private GreenfootImage[] imagenesAnimacion;
    public DemonSkull(Dante dante)
    {
       imagenesAnimacion = new GreenfootImage[NUMERO_IMAGENES];
       for( int i = 0; i < NUMERO_IMAGENES; i++ )
       {
           imagenesAnimacion[i] = new GreenfootImage( "DemonSkullMove" + i + ".png" );
       }
       this.dante = dante;
       indiceAnimacion = 0;
       contadorIteraciones = 0;       
       setImage(imagenesAnimacion[0]);       
    }
    
    public void animar()
    {
        if( contadorIteraciones >= ITERACIONES_ANIMACION )
        {
            if( indiceAnimacion < NUMERO_IMAGENES-1 )
            {
                indiceAnimacion++;
            } else {
                indiceAnimacion = 0;
            }
            setImage( imagenesAnimacion[indiceAnimacion] );
            contadorIteraciones = 0;
        } else {
            contadorIteraciones++;
        }
    }
    
    public void mover()
    {
        int x = getX();
        int y = getY();
        setLocation( x + velocidadX, y + velocidadY );
        
    }
    
    public void intentarHacerGiroInteligentemente()
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
        } else if ( Greenfoot.getRandomNumber(10) < 3 ) {
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
        /*public void intentarHacerGiro()
        {
            if( Greenfoot.getRandomNumber(1000) < PROBABILIDAD_GIRO )
            {
                int temp = velocidadX;
                velocidadX = velocidadY;
                velocidadY = temp;
            }
            
            if( Greenfoot.getRandomNumber(1000) < 50 )
            {
                velocidadX = velocidadX * -1;
                velocidadY = velocidadY * -1;
            }
        }*/
    
    public void act() 
    {
       animar();
       mover();
       intentarHacerGiroInteligentemente();
       //intentarHacerGiro();
    }    
}
