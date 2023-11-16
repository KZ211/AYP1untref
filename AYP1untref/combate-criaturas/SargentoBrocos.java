/**
 * La clase SargentoBrocos representa a una criatura específica con habilidades de ataque variadas.
 */
public class SargentoBrocos extends Criatura {

    /**
     * Constructor para la clase SargentoBrocos que inicializa sus atributos con valores predeterminados.
     * @param nombre Nombre de la criatura.
     * @param imagenEspejada Booleano que indica si la imagen está espejada.
     */
    public SargentoBrocos(String nombre, boolean imagenEspejada) {
        super(
            nombre,
            35,
            new String[] { "Patada de guerra", "Entrenamiento militar", "Disparo Perforante", "Robo de vitalidad" },
            imagenEspejada,
            new String[] { 
                "Causa un daño moderado a un enemigo", 
                "Aumenta mucho tu ataque", 
                "Daña y disminuye la defensa del enemigo", 
                "Intercambia la vida de un enemigo y la tuya, tu ataque pasa a ser 1 (si la vida de ambos está al máximo no funcionará)" 
            },
            new int[] { 150, 55, 3 },
            "tierra"
        );
    }

    /**
     * Constructor alternativo para la clase SargentoBrocos que inicializa sus atributos con valores predeterminados y con imagen espejada.
     * @param nombre Nombre de la criatura.
     */
    public SargentoBrocos(String nombre) {
        this(nombre, true);
    }

    /**
     * Ataque de tipo 1 de SargentoBrocos que causa daño a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar1(Criatura otro) {
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
    }

    /**
     * Ataque de tipo 2 de SargentoBrocos que aumenta mucho su ataque.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar2(Criatura otro) {
        this.criaturaAtaco = true;
        this.estadisticas[0] += 8;
    }

    /**
     * Ataque de tipo 3 de SargentoBrocos que daña y disminuye la defensa del enemigo.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar3(Criatura otro) {
        this.criaturaAtaco = true;
        otro.estadisticas[1] -= 4;
        otro.recibirDaño(this);
    }

    /**
     * Ataque de tipo 4 de SargentoBrocos que intercambia la vida de un enemigo y la tuya.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar4(Criatura otro) {
        this.criaturaAtaco = true;
        int vidaEnemigo = otro.vida;
        if(otro.vida == otro.getVidaMaxima() || this.vida == this.getVidaMaxima()) {
            this.vida = this.vida;
            otro.vida = otro.vida;
        } else {
            otro.vida = this.vida;
            this.vida = vidaEnemigo;
        }
        this.estadisticas[0] = 1;
        this.uiInfoCriatura.actualizar();
        otro.uiInfoCriatura.actualizar();
    }
}
