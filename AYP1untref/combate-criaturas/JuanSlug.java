//Franco Paragua

public class JuanSlug extends Criatura {
    public JuanSlug(String nombre, boolean imagenEspejada) {
        super(
            nombre, 
            55, 
            new String[] { "- Puñetazo -", "- Patada -","- Granada -", "- Sniper -" }, 
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", 
                "Golpea y aumenta el ataque, pero resta defensa"
            ,
                "daña y aumenta tu defensa",
                "hay probablidades de que falle y hacerte daño o causar daño verdadero igual a la mitad de tu ataque a un enemigo" },
            new int[] {50,35,3});
    }

    public JuanSlug(String nombre) {
        this(nombre, false);
        
    }

    public void atacar1(Criatura otro) {
<<<<<<< HEAD
        otro.recibirDaño(this);
        super.imprimirMensaje(otro,0);
        
    }
    
    public void atacar2(Criatura otro) {
        this.estadisticas[0] *= 2;
        this.estadisticas[1] -= 10;
=======
        this.criaturaAtaco = true;
>>>>>>> cd386784124023289aa9c20282096f50e323046a
        otro.recibirDaño(this);
        super.imprimirMensaje(otro,1);
    }

    public void atacar2(Criatura otro) {
        this.criaturaAtaco = true;
        this.estadisticas[0] *= 1.25;
        this.estadisticas[1] -= 5;
        otro.recibirDaño(this);
    }

    public void atacar3(Criatura otro) {
        this.criaturaAtaco = true;
        this.estadisticas[1] += 7;
        otro.recibirDaño(this);
        super.imprimirMensaje(otro,2);
    }

    public void atacar4(Criatura otro) {
<<<<<<< HEAD
        this.vida -= 500;
        uiInfoCriatura.actualizar();
        this.estadisticas[0] = otro.vida * 30;
        otro.recibirDaño(this);
        super.imprimirMensaje(otro,3);
=======
        this.criaturaAtaco = true;
        double numero = Math.random();
        int dañoFormula = (this.estadisticas[0]/2);
        if(numero > 0.65){
            otro.vida -= dañoFormula;
            otro.recibirDaño(this);
        }else{
            this.vida -= this.getVidaMaxima()*0.15;
            uiInfoCriatura.actualizar();
        }
>>>>>>> cd386784124023289aa9c20282096f50e323046a
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }

}
