import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Anuncio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Anuncio extends Actor
{
    /**
     * Act - do whatever the Comenzar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Boton anuncio_;
    GreenfootImage imagenOriginal;
    public Anuncio(){
        setImage(new GreenfootImage("anuncioTurno.png"));
        this.imagenOriginal = new GreenfootImage(getImage());
        this.imagenOriginal.scale(this.imagenOriginal.getWidth()/2,this.imagenOriginal.getHeight()/2);
        
    }

    public void act(){    
        
    }   

}
