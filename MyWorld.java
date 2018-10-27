import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int x;
    private int y;
    private int tiempoGeneracionDemonioBoss;
    private int tiempoGeneracionDemonioSkull;
    private int tiempoAumentarNivel;
    private SimpleTimer tiempo;
    private SimpleTimer tiempoDemonioSkull;
    private SimpleTimer tiempoNivel;
    private DemonBoss demonioBoss;
    private Dante dante;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        //Inicializar objetos
        dante = new Dante();        
        tiempo = new SimpleTimer();
        tiempoDemonioSkull = new SimpleTimer();
        tiempoNivel = new SimpleTimer();
        //Posicionar personajes inicialmente
        x = getWidth();
        y = getHeight();
        
        x = x / 2;
        y = y / 2; 
        addObject( dante, x, y );        
        //Iniciar contador de generación de demonios
        tiempo.mark();
        tiempoDemonioSkull.mark();
        tiempoNivel.mark();
        tiempoGeneracionDemonioBoss = 20000;
        tiempoGeneracionDemonioSkull =10000;
        tiempoAumentarNivel = 10000;
    }
    
    public void generarDemonioBoss()
    {
        if( tiempo.millisElapsed() >= tiempoGeneracionDemonioBoss )
        {
            tiempo.mark();
            int y = Greenfoot.getRandomNumber( getHeight() - 5 + 1 ) -5; 
            int x = Greenfoot.getRandomNumber( getWidth() - 5 + 1 ) -5;
            demonioBoss = new DemonBoss();
            addObject (demonioBoss, x, y);          
        }
    }
    
    public void generarDemonioSkull()
    {                   
        if( tiempoDemonioSkull.millisElapsed() >= tiempoGeneracionDemonioSkull )
        {            
            tiempoDemonioSkull.mark();
            int y = Greenfoot.getRandomNumber( getHeight() - 5 + 1 ) -5; 
            int x = Greenfoot.getRandomNumber( getWidth() - 5 + 1 ) -5;
            DemonSkull demonSkull = new DemonSkull(dante);
            addObject (demonSkull, x, y);          
        }
    }
    
    public void aumentarNivel()
    {
        if( tiempoNivel.millisElapsed() >= tiempoAumentarNivel )
        {
            tiempoNivel.mark();
            if( tiempoGeneracionDemonioBoss >= 500 && tiempoGeneracionDemonioSkull >= 500 )
            {                
                tiempoGeneracionDemonioBoss = tiempoGeneracionDemonioBoss - 500;
                tiempoGeneracionDemonioSkull = tiempoGeneracionDemonioSkull - 300;
            }             
        }
    }
    
    public void act()
    {
        generarDemonioBoss();
        generarDemonioSkull();
        aumentarNivel();
    }
}
