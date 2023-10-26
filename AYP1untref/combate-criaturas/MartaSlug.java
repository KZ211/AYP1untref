import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pikachu2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MartaSlug extends Criatura{
    public MartaSlug(String nombre, boolean imagenEspejada) {
        super(
            nombre,
            40,
            new String[] { "- Puñetazo -", "-golpe rejuvenecedor-","-Descanso-", "-!!!MEDICO¡¡¡-" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "daña y te cura un poco de vida", "Aumenta un poco tu ataque y defensa, ademas de curarte ", "Cura a un aliado a cambio de un poco de tu vida" },
            new int[] {38,30,3});
    }

    public MartaSlug(String nombre) {
        this(nombre, false);
    }

    public void atacar1(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,0);
    }

    public void atacar2(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,1);
    }
    
    public void atacar2(Criatura otro) {
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
        if(this.vida == this.getVidaMaxima()){
            this.vida = this.vida;
        }else{
            this.vida+= otro.recibirDaño(this);
        }
        uiInfoCriatura.actualizar();
    }

    public void atacar3(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,2);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return false;
    }

    public void atacar4(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,3);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return false;
    }
}
