import java.util.List;

import greenfoot.*;

public abstract class Criatura extends Actor {
    protected final String nombre;
    protected final int vidaMaxima;

    protected final String[] nombresAtaque;
    protected final String[] detallesAtaque;
    protected final int[]    estadisticas;

    protected final boolean equipo1;

    protected int vida;
    protected boolean criaturaAtaco;

    protected UIInfoCriatura uiInfoCriatura;

    private boolean visualHover;
    private boolean visualSeleccionado;
    public boolean statsEstaActivado;

    private final MyGreenfootImage imagenOriginal;

    public Criatura(String nombre, int vida, String[] nombresAtaque, boolean equipo1, String[] detallesAtaque, int[] estadisticas) {
        this.nombre = nombre;

        this.vidaMaxima = vida;

        this.nombresAtaque = nombresAtaque;
        this.detallesAtaque = detallesAtaque;

        this.vida = vida;

        this.equipo1 = equipo1;

        this.imagenOriginal = new MyGreenfootImage(getImage());
        this.imagenOriginal.scale(130, 130);

        this.uiInfoCriatura = new UIInfoCriatura(this);
        this.estadisticas = estadisticas;
    }

    @Override
    protected void addedToWorld(World world) {
        render();

        getWorld().addObject(uiInfoCriatura, getX(), getY());
        // Una vez en el mundo, actualizo segun su tamaño
        uiInfoCriatura.setLocation(getX(), getY() + getImage().getHeight() / 2 - /*Sombra*/ 10 + uiInfoCriatura.getImage().getHeight() / 2);
    }

    public void act() {
        boolean _visualHover = visualHover;
        boolean _visualSeleccionado = visualSeleccionado;

        MouseInfo m = Greenfoot.getMouseInfo();

        // TODO: detecta el mouse-over, no tocar
        if (m != null) {
            List<Actor> actor = getWorld().getObjectsAt(m.getX(), m.getY(), Actor.class);

            if (actor.size() > 0 && actor.get(0) == this) {
                visualHover = true;
                ((PantallaDuelo)getWorld()).hover(this);
            } else {
                visualHover = false;
            }
        }

        if (Greenfoot.mouseClicked(this)) {
            ((PantallaDuelo)getWorld()).click(this);
        }

        if (_visualHover != visualHover || _visualSeleccionado != visualSeleccionado) {
            render();
        }
    }

    public void render() {
        MyGreenfootImage nuevaImagen = new MyGreenfootImage(imagenOriginal) {
                public void configurar() {
                    if (!equipo1) {
                        flipHorizontally();
                    }
                    if (visualHover) {
                        scaleToRatio(1.15);
                    }
                    if (visualSeleccionado) {
                        highlight();
                    }
                    //silueta de muerte
                    if(vida==0){  
                        imagenOriginal.silhouette();
                        uiInfoCriatura.actualizar();
                    }
                    shadow();
                }
            };

        setImage(nuevaImagen);
    }

<<<<<<< HEAD
    protected void imprimirMensaje(Criatura otro, int i){
        System.out.println( this.nombre + " ataco con "  + nombresAtaque[i] + " a " + otro + " y causo " + otro.recibirDaño(this) );
    }

    protected void imprimirMensaje2(Criatura otro,int i){
        System.out.println(this.nombre + " activo " +nombresAtaque[i] + " y su salud se regenera a  " + this.vida);
    }

    public void atacar1(Criatura otro) {
=======
    public void atacar1(Criatura otro){
>>>>>>> cd386784124023289aa9c20282096f50e323046a
        otro.recibirDaño(this);

    }

    public void atacar2(Criatura otro){
        otro.recibirDaño(this);

    }

    public abstract void atacar3(Criatura otro);

    public abstract void atacar4(Criatura otro);

    protected boolean esDelMismoEquipoQue(Criatura otro) {
        return this.equipo1 == otro.equipo1;
    }

    public boolean puedeRealizarAtaque1En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro){
        return !esDelMismoEquipoQue(otro);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro){
        return !esDelMismoEquipoQue(otro);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro){
       return !esDelMismoEquipoQue(otro);
    }

    //Numero random para aleatoriedad del ataque
    protected double rand(){
        double numeroAleatorio = (double) (Math.random() * (1.25 - 0.5) + 0.5);
        return numeroAleatorio;
    }

    protected void curacion(Criatura otro){
        this.vida+=30* rand();
        if(this.vida>this.vidaMaxima){
            this.vida=this.vidaMaxima;
        }
        uiInfoCriatura.actualizar();

    }
    //Ataque, funciona con la formula en base a las estadisticas que agregue arriba
    //by: Alexis :D
<<<<<<< HEAD
    protected int recibirDaño(Criatura atacante) {
        int dañoFormula = 2*(atacante.estadisticas[0]/this.estadisticas[1])* 
            this.rand();
=======
    protected double recibirDaño(Criatura atacante) {
        double dañoFormula = 2*(1 + atacante.estadisticas[0]/this.estadisticas[1])* 
        this.rand();
>>>>>>> cd386784124023289aa9c20282096f50e323046a
        this.vida -= dañoFormula;
        uiInfoCriatura.actualizar();
        return dañoFormula;
    }

    public int getVida() {
        //para que la vida no baje de 0
        if(vida<=0){  
            vida=0;
        }
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public boolean esEquipo1() {
        return equipo1;
    }

    public void setVisualSeleccionado(boolean visualSeleccionado) {
        this.visualSeleccionado = visualSeleccionado;
        render();
    }

    public String toString() {
        return nombre;
    }

    public String[] getNombresAtaque() {
        return nombresAtaque;
    }

    public String[] getDetallesAtaque() {
        return detallesAtaque;
    }

    public String getStats() {
        return nombre + " (" + this.getClass().getSimpleName() + ")\n" +
        " - Ataque: " + estadisticas[0] + "\n" +
        " - Defensa: " + estadisticas[1] + "\n" +
        " - Velocidad: " + estadisticas[2] + "\n"
        ;
    }

}
