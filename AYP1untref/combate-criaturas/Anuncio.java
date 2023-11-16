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

    /**
     * Método act que se ejecuta constantemente en el mundo.
     * No realiza ninguna acción en este caso.
     */
    public void act() {
        // No realiza ninguna acción en este caso.
    }
}
