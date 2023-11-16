import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PantallaFinal extends World {
    private Final final_;

    /**
     * Constructor de la clase PantallaFinal.
     * post:Crea una pantalla final del juego con una imagen de 
     *      fondo y agrega un objeto Final.
     */
    public PantallaFinal() {
        // Crea un nuevo mundo con celdas de 800x600 y tamaño de celda de 1x1 píxeles.
        super(800, 600, 1); 
        GreenfootImage imagenFondo = new GreenfootImage("escenario_final.jpg");
        getBackground().drawImage(imagenFondo, 0, 0);
    }
    
    /**
     * act: Método act que se ejecuta constantemente en el mundo.
     * post: Agrega un objeto Final al mundo en cada ciclo act.
     */
    public void act() { 
        // setImage( background.getCurrentImage() );
        final_ = new Final(final_);
        addObject(final_, 400, 300);         
    }
}
