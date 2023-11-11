import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PantallaFinal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PantallaFinal extends World
{
    private Final final_;
    public PantallaFinal(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        GreenfootImage imagenFondo = new GreenfootImage("escenario_final.jpg");
        getBackground().drawImage(imagenFondo, 0, 0);
        
    }
    
    public void act(){ 
        // setImage( background.getCurrentImage() );
        final_ = new Final(final_);
        addObject(final_,180,550);         
    }
}
