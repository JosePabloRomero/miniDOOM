import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dante es el personaje principal del juego.
 * 
 * @Jose Pablo Romero Arcila - Anderson Rodriguez 
 * @Version 1.0
 */
public class Dante extends Actor
{
    public static final int NUMERO_IMAGENES = 9;
    public static final int ITERACIONES_ANIMACION = 5;
    public static final int VELOCIDAD = 5;
    
    public static final int ABAJO = 3;
    public static final int ARRIBA = 4;
    public static final int DERECHA = 1;
    public static final int IZQUIERDA = 2;  
    
    
    private GreenfootImage[] imagenesAbajo;
    private GreenfootImage[] imagenesArriba;
    private GreenfootImage[] imagenesDerecha;
    private GreenfootImage[] imagenesIzquierda;
    
    private int indiceAnimacion;
    private int contadorIteraciones;
    private int direccion;
    
    public Dante()
    {
        imagenesAbajo = new GreenfootImage[NUMERO_IMAGENES];
        imagenesArriba = new GreenfootImage[NUMERO_IMAGENES];
        imagenesDerecha = new GreenfootImage[NUMERO_IMAGENES];
        imagenesIzquierda = new GreenfootImage[NUMERO_IMAGENES];
        
        for( int i = 0; i < NUMERO_IMAGENES; i++ )
        {
            imagenesAbajo[i] = new GreenfootImage( "principalMoveDown" + i + ".png" );
            imagenesArriba[i] = new GreenfootImage( "principalMoveUp" + i + ".png" );
            imagenesDerecha[i] = new GreenfootImage( "principalMoveRight" + i + ".png" );
            imagenesIzquierda[i] = new GreenfootImage( "principalMoveLeft" + i + ".png" );
        }
        
        indiceAnimacion = 0;
        contadorIteraciones = 0;
        direccion = DERECHA;
        setImage(imagenesAbajo[0]);
    }
    public void identificarTeclaYMover()
    {
        if( Greenfoot.isKeyDown("down") )
        {
            if( direccion == ABAJO )
            {
                indiceAnimacion = 0;
            }
            setLocation( getX(), getY() + VELOCIDAD );
            animarAbajo();
            direccion = ARRIBA;
        } else if( Greenfoot.isKeyDown("up") ) {
            if( direccion == ARRIBA )
            {
                indiceAnimacion = 0;
            }
            setLocation( getX(), getY() - VELOCIDAD );
            animarArriba();
            direccion = ABAJO;
        } else if( Greenfoot.isKeyDown("right") ) {
            if( direccion == DERECHA )
            {
                indiceAnimacion = 0;
            }
            setLocation( getX() + VELOCIDAD, getY() );
            animarDerecha();
            direccion = IZQUIERDA;
        } else if( Greenfoot.isKeyDown("left") ) {
            if( direccion == IZQUIERDA )
            {
                indiceAnimacion = 0;
            }
            setLocation( getX() - VELOCIDAD, getY() );
            animarIzquierda();
            direccion = DERECHA;
        }
    }
    public void animarAbajo()
    {
        if( contadorIteraciones >= ITERACIONES_ANIMACION )
        {
            if( indiceAnimacion < NUMERO_IMAGENES-1 )
            {
                indiceAnimacion++;
            } else {
                indiceAnimacion = 0;
            }
            setImage( imagenesAbajo[indiceAnimacion] );
            contadorIteraciones = 0;
        } else {
            contadorIteraciones++;
        }
    }
    
    public void animarArriba()
    {
        if( contadorIteraciones >= ITERACIONES_ANIMACION )
        {
            if( indiceAnimacion < NUMERO_IMAGENES-1 )
            {
                indiceAnimacion++;
            } else {
                indiceAnimacion = 0;
            }
            setImage( imagenesArriba[indiceAnimacion] );
            contadorIteraciones = 0;
        } else {
            contadorIteraciones++;
        }
    }
    
    public void animarDerecha()
    {
        if( contadorIteraciones >= ITERACIONES_ANIMACION )
        {
            if( indiceAnimacion < NUMERO_IMAGENES-1 )
            {
                indiceAnimacion++;
            } else {
                indiceAnimacion = 0;
            }
            setImage( imagenesDerecha[indiceAnimacion] );
            contadorIteraciones = 0;
        } else {
            contadorIteraciones++;
        }
    }
    
    public void animarIzquierda()
    {
        if( contadorIteraciones >= ITERACIONES_ANIMACION )
        {
            if( indiceAnimacion < NUMERO_IMAGENES-1 )
            {
                indiceAnimacion++;
            } else {
                indiceAnimacion = 0;
            }
            setImage( imagenesIzquierda[indiceAnimacion] );
            contadorIteraciones = 0;
        } else {
            contadorIteraciones++;
        }
    }  
   
    public void act() 
    {
        identificarTeclaYMover();
    }    
}
