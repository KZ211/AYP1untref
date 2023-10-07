import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PikachuEnemigo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RicardoBazooka extends Criatura
{
    public RicardoBazooka(String nombre, boolean imagenEspejada) {
        super(
        nombre, 
        1000,
        new String[] { "- Puño -", "- Patada -","- Granada -", "- Sniper -" },
        imagenEspejada,
        new String[] { "Causa un daño moderado a un enemigo", "-", "-", "-" },
        new int[] {10,100,3});
    }

    public RicardoBazooka(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        atacar1(otro);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return false;
    }

    public void atacar3(Criatura otro) {
        atacar1(otro);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return false;
    }

    public void atacar4(Criatura otro) {
        atacar1(otro);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return false;
    }
}
