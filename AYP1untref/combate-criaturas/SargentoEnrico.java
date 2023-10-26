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
            2000,
            new String[] { "-Machetazo  -", "- No me dolió -","- Grito de Guerra -", "- Reprimir -" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Aumenta la defensa base x2", "Aumenta las estadisticas bases", "Causa un daño moderado y aumenta la armadura base" },
            new int[] {10,175,3});
    }

    public  SargentoEnrico(String nombre) {
        this(nombre, true);
    }

    public void atacar1(Criatura otro) {
        this.estadisticas[0] += 500;

        otro.recibirDaño(this);
        super.imprimirMensaje(otro,0);
    }

    public boolean puedeRealizarAtaque1En(Criatura otro) {
        return true;
    }

    public void atacar2(Criatura otro) {
        this.estadisticas[1]*=2;
        otro.recibirDaño(this);
        super.imprimirMensaje(otro,1);

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
    }

    public void atacar3(Criatura otro) {

        this.estadisticas[1]+=30;
        this.estadisticas[2]+=10;
        super.curacion(otro);        

        
        super.imprimirMensaje2(otro,2);

    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) {
        this.estadisticas[0]+=30;
        this.estadisticas[1]+=50;

        otro.recibirDaño(this);

        uiInfoCriatura.actualizar();
        super.imprimirMensaje(otro,3);
    }
    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}
