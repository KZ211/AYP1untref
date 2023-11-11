import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Comenzar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Final extends Actor
{
    /**
     * Act - do whatever the Comenzar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Final comenzar;
    private Final comenzar_;

    private final MyGreenfootImage imagenOriginal;

    private boolean visualHover;
    private boolean visualSeleccionado;
    public Final(Final fnl){
        setImage(new GreenfootImage("Metal_Slug_logo.png"));
        this.comenzar_=fnl;

        this.imagenOriginal = new MyGreenfootImage(getImage());
        this.imagenOriginal.scaleTo(250,250);
    }

    public void act(){    
        
    }   


}


