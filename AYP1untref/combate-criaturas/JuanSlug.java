public class JuanSlug extends Criatura {
    public JuanSlug(String nombre, boolean imagenEspejada) {
        super(
        nombre, 
        1000, 
        new String[] { "- Puño -", "- Patada -","- Granada -", "- Sniper -" }, 
        imagenEspejada,
        new String[] { "Causa un daño moderado a un enemigo", 
            "Golpea y aumenta el ataque x2, pero resta defensa"
            ,
            "Consume el 50% de la vida del enemigo para sumar tu ataque y atacar",
            "Elimina un enemigo de un golpe, pero te resta un 500 de vida" },
        new int[] {50,100,3});
    }

    public JuanSlug(String nombre) {
        this(nombre, false);
    }

    public void atacar1(Criatura otro) {
        otro.recibirDaño(this);
    }
    
    public void atacar2(Criatura otro) {
        this.estadisticas[0] *= 2;
        this.estadisticas[1] -= 10;
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
        this.vida -= 500;
        uiInfoCriatura.actualizar();
        this.estadisticas[0] = otro.vida * 30;
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
    
}
