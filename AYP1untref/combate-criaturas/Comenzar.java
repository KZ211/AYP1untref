import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Comenzar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comenzar extends Actor
{
    /**
     * Act - do whatever the Comenzar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Boton comenzar;
    private Boton comenzar_;

    private final MyGreenfootImage imagenOriginal;

    private boolean visualHover;
    private boolean visualSeleccionado;
    public Comenzar(String image, Boton comenzar){
        setImage(new GreenfootImage("comenzar.png"));
        this.comenzar_=comenzar;

        this.imagenOriginal = new MyGreenfootImage(getImage());
        
    }

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
