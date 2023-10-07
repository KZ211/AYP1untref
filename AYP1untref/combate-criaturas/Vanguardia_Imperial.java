import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PikachuEnemigo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vanguardia_Imperial extends Criatura
{   

    public Vanguardia_Imperial(String nombre, boolean imagenEspejada) {
        super(
            nombre,
            2000,
            new String[] { "-Machetazo  -", "- No me dolió -","- Grito de Guerra -", "- Reprimir -" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Aumenta la defensa base x2", "Aumenta las estadisticas bases", "Causa un daño moderado y aumenta la armadura base" },
            new int[] {10,175,3});
    }

    public  Vanguardia_Imperial(String nombre) {
        this(nombre, true);
    }

    public void atacar1(Criatura otro) {
        this.estadisticas[0] += 20;

        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque1En(Criatura otro) {
        return true;
    }

    public void atacar2(Criatura otro) {
        this.estadisticas[1]*=2;
        otro.recibirDaño(this);

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
    }

    public void atacar3(Criatura otro) {

        this.estadisticas[1]+=30;
        this.estadisticas[2]+=10;
        this.vida+=20* super.rand();

        otro.recibirDaño(this);
        if(this.vida>this.vidaMaxima){
            this.vida=this.vidaMaxima;
        }
        uiInfoCriatura.actualizar();

    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) {
        this.estadisticas[0]+=30;
        this.estadisticas[1]+=50;

        otro.recibirDaño(this);

        uiInfoCriatura.actualizar();
    }
    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}
