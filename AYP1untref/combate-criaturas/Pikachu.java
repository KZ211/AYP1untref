public class Pikachu extends Criatura {
    public Pikachu(String nombre, boolean imagenEspejada) {
        super(
        nombre, 
        1000, 
        new String[] { "Placaje", "- Vacío -","- Vacío -", "- Vacío -" }, 
        imagenEspejada,
        new String[] { "Causa un daño moderado a un enemigo", "-", "-", "-" },
        new int[] {10,10,3});
    }

    public Pikachu(String nombre) {
        this(nombre, false);
    }

    public void atacar1(Criatura otro) {
        otro.recibirDaño(this);
    }
    
    public void atacar2(Criatura otro) {
        this.estadisticas[0] *= 2;
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
    }

    public void atacar3(Criatura otro) {
        this.estadisticas[0] = otro.vida / 2;
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) {
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
    
    public String getStats() {
        return nombre + " (" + this.getClass().getSimpleName() + ")\n" +
        " - Ataque: " + estadisticas[0] + "\n" +
        " - Defensa: " + estadisticas[1] + "\n" +
        " - Velocidad: " + estadisticas[2] + "\n"
        ;
    }
}
