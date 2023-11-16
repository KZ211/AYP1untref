import greenfoot.*;

public class GifLoop extends Actor {
    private GifImage gifImage;

    /**
     * Constructor de la clase GifLoop.
     * Inicializa la imagen GIF y establece la imagen actual del GIF como la imagen del actor.
     * 
     * @param gifFileName Nombre del archivo GIF a utilizar.
     */
    public GifLoop(String gifFileName) {
        gifImage = new GifImage(gifFileName);
        setImage(gifImage.getCurrentImage());
    }
    
    /**
     * Método act: se ejecuta en cada ciclo de actuar del mundo.
     * Actualiza la imagen que se muestra si el GIF está en ejecución.
     */
    public void act() {
        if (gifImage.isRunning()) {
            setImage(gifImage.getCurrentImage());
        }
    }
}
