import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

public class PantallaPrincipal extends World {
    Boton hoverObjetivo = null;
    private Comenzar comenzar;
    private GifImage icono;
    private GreenfootSound sound;
    
    private PantallaDuelo mundoDuelo;

    /**
     * Constructor de la clase PantallaPrincipal.
     * Crea una pantalla principal del juego con una imagen de fondo, un botón para comenzar,
     * una animación (GIF) y música de fondo.
     */
    public PantallaPrincipal() {    
        // Crea un nuevo mundo con celdas de 800x600 y tamaño de celda de 1x1 píxeles.
        super(800, 600, 1); 

        GreenfootImage imagenFondo = new GreenfootImage("PantallaPrincipal.jpg");
        getBackground().drawImage(imagenFondo, 0, 0);
        
        mundoDuelo = new PantallaDuelo();
        comenzar = new Comenzar("", null);
        addObject(comenzar, 480, 550);
        addTropaGif();
        addMusicPantallaPrincipal();
    }
    
    /**
     * Agrega una animación (GIF) al mundo.
     */
    private void addTropaGif() {
        GifLoop gifLoop0 = new GifLoop("Tropa.gif");
        addObject(gifLoop0, getWidth() - 400, getHeight() - 350);
    }
    
    /**
     * Agrega música de fondo a la pantalla principal.
     */
    private void addMusicPantallaPrincipal() {
        this.sound = new GreenfootSound("MetalSlug2PrehistoricSite.mp3");
        sound.playLoop();
    }
    
    /**
     * Detiene la música de fondo en la pantalla principal.
     */
    private void stopMusicPantallaPrincipal() {
        this.sound.stop();
    }
    
    /**
     * Agrega música de fondo a la pantalla de juego (PantallaDuelo).
     */
    private void addMusicPantallaDuelo() {
        GreenfootSound sound = new GreenfootSound("MetalSlug2Judgment.mp3");
        sound.playLoop();
    }
    
    /**
     * Método para manejar el clic en el botón para comenzar el juego.
     * Cambia el mundo a la pantalla de juego (PantallaDuelo), detiene la música de la pantalla principal
     * y agrega música de fondo a la pantalla de juego.
     * @param c El botón en el que se hizo clic.
     */
    public void click(Boton c) {
        Greenfoot.setWorld(mundoDuelo);
        stopMusicPantallaPrincipal();
        addMusicPantallaDuelo();
    }

    /**
     * Método para manejar el evento de pasar el mouse sobre un botón en la pantalla principal.
     * @param c El botón sobre el que se pasa el mouse.
     */
    public void hover(Boton c) {
        if (hoverObjetivo == c) {
            return;
        }
        hoverObjetivo = c;
    }
}
