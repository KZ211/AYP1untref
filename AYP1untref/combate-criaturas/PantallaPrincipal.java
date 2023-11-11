import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PantallaPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PantallaPrincipal extends World
{
    Boton hoverObjetivo = null;
    private Comenzar comenzar;
    
    private PantallaDuelo mundoDuelo;
    public PantallaPrincipal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        GreenfootImage imagenFondo = new GreenfootImage("PantallaPrincipal.jpg");
        getBackground().drawImage(imagenFondo, 0, 0);
        mundoDuelo = new PantallaDuelo();
        comenzar = new Comenzar("", null);
        addObject(comenzar,480,550);
        
    }

    public void click(Boton c){
        Greenfoot.setWorld(mundoDuelo);
    }

    public void hover(Boton c) {
        if (hoverObjetivo == c) {
            return;
        }

        hoverObjetivo = c;
    }

}
