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
    
    private int indiceAnimacion;
    private int contadorIteraciones;
    private int direccion;
    private int velocidadX = 3;
    private int velocidadY = 0;
    
    private GreenfootImage[] imagenesAnimacion;
    public DemonSkull()
    {
        imagenesAnimacion = new GreenfootImage[NUMERO_IMAGENES];
       for( int i = 0; i < NUMERO_IMAGENES; i++ )
       {
           imagenesAnimacion[i] = new GreenfootImage( "DemonSkullMove" + i + ".png" );
       }
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
        setLocation()
    }
    
    public void act() 
    {
       animar();
    }    
}
