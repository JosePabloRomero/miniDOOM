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
    
    
    private GreenfootImage[] imagenesMovimiento;
    private GreenfootImage[] imagenesAtaque;
    
    private int indiceAnimacion;
    private int contadorIteraciones;
    private int direccion;  
    
    
    public DemonBoss()
    {
        imagenesMovimiento = new GreenfootImage[NUMERO_IMAGENES];
        imagenesAtaque = new GreenfootImage[NUMERO_IMAGENES_ATAQUE];
        
        for(int i = 0; i < NUMERO_IMAGENES; i++)
        {
            imagenesMovimiento[i] = new GreenfootImage("Demon1Move" + i + ".png" );
            imagenesAtaque[i] = new GreenfootImage("Demon1Attack" + i + ".png" );
        }        
        
        indiceAnimacion = 0;
        contadorIteraciones = 0;
        setImage(imagenesMovimiento[0]);        
       
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
   
    
    public void act() 
    {
        animarMovimiento();
        
    }    
}
