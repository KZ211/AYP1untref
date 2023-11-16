/**
 * La clase JuanSlug representa a una criatura específica con habilidades de ataque variadas.
 */
public class JuanSlug extends Criatura {

    /**
     * Constructor para la clase JuanSlug que inicializa sus atributos con valores predeterminados.
     * @param nombre Nombre de la criatura.
     * @param imagenEspejada Booleano que indica si la imagen está espejada.
     */
    public JuanSlug(String nombre, boolean imagenEspejada) {
        super(
            nombre, 
            45, 
            new String[] { "Culatazo", "Disparo", "Granada", "Headshot" }, 
            imagenEspejada,
            new String[] { 
                "Causa un daño moderado a un enemigo", 
                "Golpea y aumenta tu ataque, pero te resta defensa",
                "Daña al enemigo, activandole un efecto de quemadura que le durara 3 turnos y aumenta tu defensa",
                "Hay una gran probabilidad de que falle y hacerte daño por el contrataque. Pero también puedes causar daño verdadero igual a la mitad de tu ataque a un enemigo" 
            },
            new int[] { 115, 80, 3 }
        );
    }

    /**
     * Constructor alternativo para la clase JuanSlug que inicializa sus atributos con valores predeterminados y sin imagen espejada.
     * @param nombre Nombre de la criatura.
     */
    public JuanSlug(String nombre) {
        this(nombre, false);
    }
    
    /**
     * Ataque de tipo 1 de JuanSlug que causa daño a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar1(Criatura otro){
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
    }
    
    /**
     * Ataque de tipo 2 de JuanSlug que aumenta el ataque y reduce la defensa de otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar2(Criatura otro) {
        this.criaturaAtaco = true;
        this.estadisticas[0] *= 1.25;
        this.estadisticas[1] -= 5;
        otro.recibirDaño(this);
    }

    /**
     * Ataque de tipo 3 de JuanSlug deja un efecto de quemadura en el enemigo.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar3(Criatura otro) {
        this.criaturaAtaco = true;
        otro.activarQuemadura();
        otro.recibirDaño(this);
    }

    /**
     * Ataque de tipo 4 de JuanSlug que puede causar daño variable a otra criatura o a sí mismo.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar4(Criatura otro) {
        this.criaturaAtaco = true;
        double numero = Math.random();
        int dañoFormula = (this.estadisticas[0] / 2);
        if (numero > 0.65){
            otro.vida -= dañoFormula;
            otro.recibirDaño(this);
        } else {
            this.vida -= this.getVidaMaxima() * 0.15;
            uiInfoCriatura.actualizar();
        }
    }
}
