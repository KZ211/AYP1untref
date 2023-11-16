/**
 * La clase SargentoEnrico representa a una criatura específica con habilidades de ataque variadas.
 */
public class SargentoEnrico extends Criatura {

    /**
     * Constructor para la clase SargentoEnrico que inicializa sus atributos con valores predeterminados.
     * @param nombre Nombre de la criatura.
     * @param imagenEspejada Booleano que indica si la imagen está espejada.
     */
    public SargentoEnrico(String nombre, boolean imagenEspejada) {
        super(
            nombre,
            25,
            new String[] { "Puño limpio", "¨Solo son cosquillas¨", "Grito de Guerra", "Reprimir" },
            imagenEspejada,
            new String[] { 
                "Causa un daño moderado a un enemigo", 
                "Te cura pero disminuye tu ataque y defensa", 
                "Hace daño y aumenta tu defensa", 
                "Hace daño al enemigo, intercambiando tu vida por 1 o 2 puntos de ataque" 
            },
            new int[] { 100, 115, 3 },
            "agua"
        );
    }

    /**
     * Constructor alternativo para la clase SargentoEnrico que inicializa sus atributos con valores predeterminados y con imagen espejada.
     * @param nombre Nombre de la criatura.
     */
    public SargentoEnrico(String nombre) {
        this(nombre, true);
    }

    /**
     * Ataque de tipo 1 de SargentoEnrico que causa daño a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar1(Criatura otro) {
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
    }

    /**
     * Ataque de tipo 2 de SargentoEnrico que cura a lo largo de 3 turnos pero disminuye el ataque y defensa de la criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar2(Criatura otro) {
<<<<<<< HEAD
        this.estadisticas[1]*=2;
        otro.recibirDaño(this);

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        if(otro.esEquipo1()){
            return false;    
          }
        return true;
=======
        this.criaturaAtaco = true;
        this.estadisticas[1] /= 1.25;
        this.estadisticas[2] /= 1.25;
<<<<<<< HEAD
        super.curacion(otro);
>>>>>>> dcc8707d01f92c8b72f5bc0c9d75afc33a7fc9f0
=======
        this.activarCuracion();
>>>>>>> ecd1e18032a2c28d8cdaec8f1da5126199f16612
    }

    /**
     * Ataque de tipo 3 de SargentoEnrico que hace daño y aumenta la defensa.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar3(Criatura otro) {
        this.criaturaAtaco = true;
        this.estadisticas[1] += 4;
        otro.recibirDaño(this);
    }

    /**
     * Ataque de tipo 4 de SargentoEnrico que hace daño al enemigo intercambiando vida por puntos de ataque.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar4(Criatura otro) {
        this.criaturaAtaco = true;
        this.estadisticas[0] += 5;
        this.estadisticas[1] += 5;
        
        otro.recibirDaño(this);
        this.vida -= this.getVidaMaxima() * 0.10;
        uiInfoCriatura.actualizar();
    }
}
