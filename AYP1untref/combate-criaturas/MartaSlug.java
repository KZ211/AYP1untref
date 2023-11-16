/**
 * La clase MartaSlug representa a una criatura específica con habilidades de ataque variadas.
 */
public class MartaSlug extends Criatura {
    
    /**
     * Constructor para la clase MartaSlug que inicializa sus atributos con valores predeterminados.
     * @param nombre Nombre de la criatura.
     * @param imagenEspejada Booleano que indica si la imagen está espejada.
     */
    public MartaSlug(String nombre, boolean imagenEspejada) {
        super(
            nombre,
            50,
            new String[] { "Culatazo", "Golpe de Adrenalina", "Revitalidad", "!APOYO¡" },
            imagenEspejada,
            new String[] { 
                "Causa un daño moderado a un enemigo", 
                "Daña al enemigo y te cura un porcentaje de vida", 
                "Aumenta tu ataque y tu defensa en una pequeña proporción, además de curarte", 
                "Cura a un aliado a cambio de un porcentaje de tu vida" 
            },
            new int[] { 150, 40, 3 },
            "agua"
        );
    }

    /**
     * Constructor alternativo para la clase MartaSlug que inicializa sus atributos con valores predeterminados y sin imagen espejada.
     * @param nombre Nombre de la criatura.
     */
    public MartaSlug(String nombre) {
        this(nombre, false);
    }
    
    /**
     * Ataque de tipo 1 de MartaSlug que causa daño a otra criatura.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar1(Criatura otro){
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
    }
    
    /**
     * Ataque de tipo 2 de MartaSlug que daña a otra criatura y se cura en cierto porcentaje.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar2(Criatura otro) {
        int controlador;
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
        if(this.vida == this.getVidaMaxima()){
            this.vida = this.vida;
        }else{
            controlador = otro.recibirDaño(this);
            this.vida += controlador;
            System.out.println(this.nombre + " se curo, regenerando (" + controlador + ") de su vida");
        }
        uiInfoCriatura.actualizar();
    }

    /**
     * Ataque de tipo 3 de MartaSlug que aumenta su ataque y defensa y se cura en cierto porcentaje.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar3(Criatura otro) {
        int controlador;
        this.criaturaAtaco = true;
        this.estadisticas[0] += 3;
        this.estadisticas[1] += 3;
        if(this.vida == this.getVidaMaxima()){
            this.vida = this.vida;
        }else{
            controlador = otro.recibirDaño(this);
            this.vida += controlador;
            System.out.println(this.nombre + " se curo, regenerando (" + controlador + ") de su vida");
        }
        uiInfoCriatura.actualizar();
    }

    /**
     * Ataque de tipo 4 de MartaSlug que cura a otra criatura aliada a cambio de perder vida.
     * @param otro Criatura objetivo del ataque.
     */
    public void atacar4(Criatura otro) {
        int controlador;
        this.criaturaAtaco = true;
        if(otro.vida == otro.getVidaMaxima()){
            otro.vida = otro.vida;
        }else{
            controlador = 25;
            otro.vida += controlador;
            System.out.println(this.nombre + " curo a " + otro.nombre + " regenerandole (" + controlador + ") de su vida");
        }
        this.vida *= 0.80;
        this.uiInfoCriatura.actualizar();
        otro.uiInfoCriatura.actualizar();
    }
    
    /**
     * Determina si MartaSlug puede realizar el ataque 4 en una criatura aliada.
     * @param otro Criatura objetivo del ataque.
     * @return Verdadero si MartaSlug puede realizar el ataque 4 en la criatura especificada, falso en caso contrario.
     */
    public boolean puedeRealizarAtaque4En(Criatura otro){
       return esDelMismoEquipoQue(otro);
    }
}
