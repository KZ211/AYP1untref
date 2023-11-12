import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
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
    private GifImage icono;
    private GreenfootSound sound;
    
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
        addTropaGif();
        addZombieGif();
        addMusicPantallaPrincipal();
    }
    
    private void addTropaGif(){
        GifLoop gifLoop0= new GifLoop("Tropa.gif");
        addObject(gifLoop0, getWidth() - 400, getHeight() - 350);
    }
    
    private void addZombieGif(){
        GifLoop gifLoop= new GifLoop("ricardoZombie.gif");
        addObject(gifLoop, getWidth() - 100, getHeight() - 230);
    }
    
    private void addMusicPantallaPrincipal(){
        this.sound = new GreenfootSound("MetalSlug2PrehistoricSite.mp3");
        sound.playLoop();
    }
    
    private void stopMusicPantallaPrincipal(){
        this.sound.stop();
    }
    
    private void addMusicPantallaDuelo(){
        GreenfootSound sound = new GreenfootSound("MetalSlug2Judgment.mp3");
        sound.playLoop();
    }
    
    public void click(Boton c){
        Greenfoot.setWorld(mundoDuelo);
        stopMusicPantallaPrincipal();
        addMusicPantallaDuelo();
    }

    public void hover(Boton c) {
        if (hoverObjetivo == c) {
            return;
        }

        hoverObjetivo = c;
    }

}
