import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
<<<<<<< HEAD

=======
import greenfoot.GreenfootSound;
>>>>>>> 6855468c6d3bb8095fcb43895b0ed150c7c38a74
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
<<<<<<< HEAD
=======
    private GifImage icono;
    private GreenfootSound sound;
>>>>>>> 6855468c6d3bb8095fcb43895b0ed150c7c38a74
    
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
<<<<<<< HEAD
        
    }

    public void click(Boton c){
        Greenfoot.setWorld(mundoDuelo);
=======
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
>>>>>>> 6855468c6d3bb8095fcb43895b0ed150c7c38a74
    }

    public void hover(Boton c) {
        if (hoverObjetivo == c) {
            return;
        }

        hoverObjetivo = c;
    }

}
