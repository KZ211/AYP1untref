import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Anuncio extends Actor {
    private Boton anuncio_;
    private GreenfootImage imagenOriginal;

    /**
     * Constructor de la clase Anuncio.
     * Crea un actor que muestra un anuncio de turno con una imagen predefinida y la escala a la mitad.
     */
    public Anuncio() {
        setImage(new GreenfootImage("anuncioTurno.png"));
        this.imagenOriginal = new GreenfootImage(getImage());
        this.imagenOriginal.scale(this.imagenOriginal.getWidth() / 2, this.imagenOriginal.getHeight() / 2);
    }
}
