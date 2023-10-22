import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PikachuEnemigo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SargentoEnrico extends Criatura
{   

    public SargentoEnrico(String nombre, boolean imagenEspejada) {
        super(
            nombre,
            60,
            new String[] { "-Machetazo  -", "- No me dolió -","- Grito de Guerra -", "- Reprimir -" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Te cura pero disminuye tu ataque y defensa", "Hace daño y aumenta tu defensa", "Hace daño y aumenta muy poco tu ataque y defensa a cambio de un poco de tu vida" },
            new int[] {25, 55,3});
    }

    public  SargentoEnrico(String nombre) {
        this(nombre, true);
    }

    public void atacar1(Criatura otro) {
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque1En(Criatura otro) {
        return true;
    }

    public void atacar2(Criatura otro) {
        this.estadisticas[1] /= 1.25;
        this.estadisticas[2] /= 1.25;
        super.curacion(otro);

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
    }

    public void atacar3(Criatura otro) {
        this.estadisticas[1]+= 4;
        otro.recibirDaño(this);
               
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) {
        this.estadisticas[0]+=5;
        this.estadisticas[1]+=5;

        otro.recibirDaño(this);
        this.vida -= this.getVidaMaxima()*0.10;
        uiInfoCriatura.actualizar();
    }
    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}
