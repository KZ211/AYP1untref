import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PikachuEnemigo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RicardoParagua extends Criatura
{   
    
    public RicardoParagua(String nombre, boolean imagenEspejada) {
        super(
        nombre,
        1000,
        new String[] { "- Puño -", "- Patada -","- Granada -", "- Sniper -" },
        imagenEspejada,
        new String[] { "Causa un daño moderado a un enemigo", "-", "-", "-" },
        new int[] {10,100,3});
    }

    public RicardoParagua(String nombre) {
        this(nombre, true);
    }
    
    public void atacar1(Criatura otro) {
        this.estadisticas[0] *= 2000;
        this.estadisticas[1] -= 10;
        
        otro.recibirDaño(this);
    }
    
    public void atacar2(Criatura otro) {
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return false;
    }

    public void atacar3(Criatura otro) {
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return false;
    }

    public void atacar4(Criatura otro) {
        otro.recibirDaño(this);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return false;
    }
}
