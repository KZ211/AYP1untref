import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Actor que representa un botón de "Comenzar".
 */
public class Comenzar extends Actor {

    private Boton comenzar_;
    private final MyGreenfootImage imagenOriginal;
    private boolean visualHover;
    private boolean visualSeleccionado;

    /**
     * Constructor de la clase Comenzar.
     * @param image La imagen asociada al botón.
     * @param comenzar El botón que representa la acción de "Comenzar".
     */
    public Comenzar(String image, Boton comenzar){
        setImage(new GreenfootImage("comenzar.png"));
        this.comenzar_ = comenzar;
        this.imagenOriginal = new MyGreenfootImage(getImage());
    }

    /**
     * Método act que se ejecuta cuando se hace clic o pasa el mouse sobre el botón.
     * Actualiza la apariencia del botón según la interacción del usuario.
     */
    public void act(){    
        boolean _visualHover = visualHover;
        boolean _visualSeleccionado = visualSeleccionado;

        MouseInfo m = Greenfoot.getMouseInfo();

        if (m != null) {
            List<Actor> actor = getWorld().getObjectsAt(m.getX(), m.getY(), Actor.class);

            if (actor.size() > 0 && actor.get(0) == this) {
                visualHover = true;
                ((PantallaPrincipal)getWorld()).hover(this.comenzar_);
            } else {
                visualHover = false;
            }
        }

        if (Greenfoot.mouseClicked(this)) {
            ((PantallaPrincipal)getWorld()).click(this.comenzar_);
        }

        if (_visualHover != visualHover || _visualSeleccionado != visualSeleccionado) {
            render();
        }
    }   

    /**
     * Actualiza la representación visual del botón.
     */
    public void render() {
        MyGreenfootImage nuevaImagen = new MyGreenfootImage(imagenOriginal) {
            public void configurar() {
                if (visualHover) {
                    scaleToRatio(1.10);
                }
                if (visualSeleccionado) {
                    highlight();
                }
            }
        };

        setImage(nuevaImagen);
    }
}
