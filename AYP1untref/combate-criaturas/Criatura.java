import java.util.List;

import greenfoot.*;

/**
 * Clase abstracta que representa una Criatura en el juego.
 */
public abstract class Criatura extends Actor {
    // Atributos de la criatura
    protected final String nombre;
    protected final int vidaMaxima;

    protected final String[] nombresAtaque;
    protected final String[] detallesAtaque;
    protected final int[]    estadisticas;

    protected final boolean equipo1;

    protected int vida;
    protected int tiempoDeEfecto;
    protected int tiempoDeEfectoQuemadura;
    protected double dañoFormula;
    protected double dañoHecho;
    protected boolean criaturaAtaco;
    protected boolean puedeUtilizarAtaque;
    protected boolean quemaduraActiva;
    protected boolean curacionActiva;
    protected boolean fueCritico;

    protected UIInfoCriatura uiInfoCriatura;

    private boolean visualHover;
    private boolean visualSeleccionado;
    public boolean statsEstaActivado;

    private final MyGreenfootImage imagenOriginal;

    /**
     * Constructor de la clase Criatura.
     * @param nombre Nombre de la criatura.
     * @param vida Puntos de vida de la criatura.
     * @param nombresAtaque Nombres de los ataques de la criatura.
     * @param equipo1 Indica si la criatura pertenece al equipo 1 o no.
     * @param detallesAtaque Detalles de los ataques de la criatura.
     * @param estadisticas Estadísticas de la criatura (ataque, defensa, velocidad).
     */
    public Criatura(String nombre, int vida, String[] nombresAtaque, boolean equipo1, String[] detallesAtaque, int[] estadisticas) {
        // Inicialización de atributos
        this.nombre = nombre;

        this.vidaMaxima = vida;

        this.nombresAtaque = nombresAtaque;
        this.detallesAtaque = detallesAtaque;
        this.puedeUtilizarAtaque = true;
        this.quemaduraActiva = false;
        this.curacionActiva = false;
        this.fueCritico = false;
        this.tiempoDeEfecto = 3;
        this.tiempoDeEfectoQuemadura = 3;

        this.vida = vida;

        this.equipo1 = equipo1;

        this.imagenOriginal = new MyGreenfootImage(getImage());
        this.imagenOriginal.scale(150, 150);

        this.uiInfoCriatura = new UIInfoCriatura(this);
        this.estadisticas = estadisticas;
    }

    // Métodos abstractos y métodos de interacción de la criatura con el mundo
    @Override
    protected void addedToWorld(World world) {
        render();

        getWorld().addObject(uiInfoCriatura, getX(), getY());
        // Una vez en el mundo, actualizo segun su tamaño
        uiInfoCriatura.setLocation(getX(), getY() + getImage().getHeight() / 2 - /*Sombra*/ 10 + uiInfoCriatura.getImage().getHeight() / 2);
    }

    /**
     * Método que se ejecuta constantemente en el mundo.
     * Detecta interacciones del mouse y actualiza la representación visual de la criatura.
     */
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

    /**
     * Actualiza la representación visual de la criatura según su interacción con el mouse.
     */
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
    
    // Métodos para acciones de ataque, curación y cálculo de daño
    /**
     * Realiza un ataque de tipo 1 a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar1(Criatura otro){
        otro.recibirDaño(this);
    }
    
    /**
     * Realiza un ataque de tipo 2 a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar2(Criatura otro){
        otro.recibirDaño(this);
    }

    /**
     * Método abstracto para realizar un ataque de tipo 3 a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public abstract void atacar3(Criatura otro);

    /**
     * Método abstracto para realizar un ataque de tipo 4 a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public abstract void atacar4(Criatura otro);

    /**
     * Verifica si la criatura actual es del mismo equipo que la criatura proporcionada.
     * @param otro Criatura a comparar.
     * @return true si son del mismo equipo, de lo contrario false.
     */
    protected boolean esDelMismoEquipoQue(Criatura otro) {
        return this.equipo1 == otro.equipo1;
    }

    /**
     * Verifica si la criatura puede realizar un ataque de tipo 1 en la criatura proporcionada.
     * @param otro Criatura objetivo del ataque.
     * @return true si puede realizar el ataque, de lo contrario false.
     */
    public boolean puedeRealizarAtaque1En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    /**
     * Verifica si la criatura puede realizar un ataque de tipo 2 en la criatura proporcionada.
     * @param otro Criatura objetivo del ataque.
     * @return true si puede realizar el ataque, de lo contrario false.
     */
    public boolean puedeRealizarAtaque2En(Criatura otro){
        return !esDelMismoEquipoQue(otro);
    }

    /**
     * Verifica si la criatura puede realizar un ataque de tipo 3 en la criatura proporcionada.
     * @param otro Criatura objetivo del ataque.
     * @return true si puede realizar el ataque, de lo contrario false.
     */
    public boolean puedeRealizarAtaque3En(Criatura otro){
        return !esDelMismoEquipoQue(otro);
    }

    /**
     * Verifica si la criatura puede realizar un ataque de tipo 4 en la criatura proporcionada.
     * @param otro Criatura objetivo del ataque.
     * @return true si puede realizar el ataque, de lo contrario false.
     */
    public boolean puedeRealizarAtaque4En(Criatura otro){
        return !esDelMismoEquipoQue(otro);
    }

    /**
     * Método que genera un número aleatorio entre 0.5 y 1.25.
     * @return Número aleatorio.
     */
    public double rand(){
        double numeroAleatorio = (double) (Math.random() * (1.25 - 0.5) + 0.5);
        return numeroAleatorio;
    }
    
    protected double golpeCritico(Criatura otro){
        double numero = Math.random();
        boolean fueCritico;
        double golpe = 4;
        if(numero > 0.85){
            this.fueCritico = true;
            System.out.println(otro.nombre + " genero un golpe CRITICO!");
            return golpe;
        }
        this.fueCritico = false;
        return 1;
    }
    
    /**
     * Calcula el ataque de la criatura teniendo en cuenta la defensa del objetivo.
     * @param defensa Defensa del objetivo.
     * @return Valor del ataque realizado.
     */
    protected int ataque(int defensa,Criatura otro){
        double dañoAtaque = 2*(1 + defensa/this.estadisticas[1])* 
            this.rand() * this.golpeCritico(otro);
        int dañoDelAtaque = (int) dañoAtaque;
        this.dañoFormula = (int) dañoAtaque;
        return dañoDelAtaque;
    }
    
    /**
     * Recibe daño de una criatura atacante.
     * @param atacante Criatura que realiza el ataque.
     * @return Valor del daño realizado.
     */
    protected int recibirDaño(Criatura atacante){
        int dañoFormula = (int) this.ataque(this.estadisticas[0], atacante);
        this.vida -= dañoFormula;
        uiInfoCriatura.actualizar();
        return dañoFormula;
    }
    
    /**
     * Realiza una curación a la criatura.
     * @param otro Criatura a la que se le realizará la curación.
     */
    protected void curacionInstantanea(Criatura otro){
        this.vida += 15 * rand();
        if(this.vida > this.vidaMaxima){
            this.vida = this.vidaMaxima;
        }
        uiInfoCriatura.actualizar();
    }
    
    protected void quemadura(){
        if(this.quemaduraActiva == true){
            this.vida -= 2;
            uiInfoCriatura.actualizar();
            this.tiempoDeEfectoQuemadura--;
            System.out.println(this.nombre + "Esta recibiendo (2) de daño por quemadura, tiempo restante del efecto: (" 
            + this.tiempoDeEfecto + ") turnos");
            if(this.tiempoDeEfecto == 0){
                this.quemaduraActiva = false;
            }
        }
    }
    
    protected void curacion(){
        if(this.curacionActiva == true){
            this.vida += 2;
            uiInfoCriatura.actualizar();
            this.tiempoDeEfecto--;
            System.out.println(this.nombre + "Esta recibiendo (2) de curacion, tiempo restante del efecto: (" 
            + this.tiempoDeEfecto + ") turnos");
            if(this.tiempoDeEfecto == 0){
                this.curacionActiva = false;
            }
        }
    }
    
    protected void activarQuemadura(){
        this.quemaduraActiva = true;
    }
    
    protected void activarCuracion(){
        this.curacionActiva = true;
        this.tiempoDeEfecto = 3;
    }
    
    protected boolean getEstadoQuemadura(){
        return this.quemaduraActiva;
    }
    
    /**
     * Obtiene la vida actual de la criatura.
     * @return Vida actual de la criatura.
     */
    public int getVida() {
        if(vida <= 0){  
            vida = 0;
        }
        return vida;
    }

    /**
     * Obtiene el valor máximo de vida de la criatura.
     * @return Valor máximo de vida de la criatura.
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * Verifica si la criatura ha atacado.
     * @return true si la criatura ha atacado, de lo contrario false.
     */
    public boolean getCriaturaAtaco(){
        return this.criaturaAtaco;
    }
    
    public boolean getFueCritico(){
        return this.fueCritico;
    }

    /**
     * Obtiene el valor del daño realizado por la criatura.
     * @return Valor del daño realizado.
     */
    public double getDañoHecho(){
        return this.dañoFormula;
    }

    /**
     * Verifica si la criatura pertenece al equipo 1.
     * @return true si la criatura pertenece al equipo 1, de lo contrario false.
     */
    public boolean esEquipo1() {
        return equipo1;
    }

    /**
     * Establece la selección visual de la criatura.
     * @param visualSeleccionado Estado de selección visual de la criatura.
     */
    public void setVisualSeleccionado(boolean visualSeleccionado) {
        this.visualSeleccionado = visualSeleccionado;
        render();
    }

    /**
     * Devuelve el nombre de la criatura como representación en texto.
     * @return Nombre de la criatura.
     */
    public String toString() {
        return nombre;
    }

    /**
     * Obtiene los nombres de los ataques disponibles de la criatura.
     * @return Arreglo con los nombres de los ataques.
     */
    public String[] getNombresAtaque() {
        return nombresAtaque;
    }

    /**
     * Obtiene los detalles de los ataques disponibles de la criatura.
     * @return Arreglo con los detalles de los ataques.
     */
    public String[] getDetallesAtaque() {
        return detallesAtaque;
    }

    /**
     * Obtiene las estadísticas de la criatura en forma de cadena de texto.
     * @return Estadísticas de la criatura.
     */
    public String getStats() {
        return nombre + " (" + this.getClass().getSimpleName() + ")\n" +
        " - Ataque: " + estadisticas[0] + "\n" +
        " - Defensa: " + estadisticas[1] + "\n" +
        " - Velocidad: " + estadisticas[2] + "\n";
    }
}
