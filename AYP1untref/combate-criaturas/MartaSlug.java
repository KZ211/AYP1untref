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
<<<<<<< HEAD
            1000,
            new String[] { "- Puño -", "- Patada -","- Granada -", "- Sniper -" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "-", "-", "-" },
            new int[] {10,100,3});
=======
            40,
            new String[] { "- Puñetazo -", "-golpe rejuvenecedor-","-Descanso-", "-!!!MEDICO¡¡¡-" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "daña y te cura un poco de vida", "Aumenta un poco tu ataque y defensa, ademas de curarte ", "Cura a un aliado a cambio de un poco de tu vida" },
            new int[] {38,30,3});
>>>>>>> cd386784124023289aa9c20282096f50e323046a
    }

    public MartaSlug(String nombre) {
        this(nombre, false);
    }
<<<<<<< HEAD

    public void atacar1(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,0);
    }

    public void atacar2(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,1);
=======
    
    public void atacar1(Criatura otro){
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
>>>>>>> cd386784124023289aa9c20282096f50e323046a
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
<<<<<<< HEAD
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
=======
        this.criaturaAtaco = true;
        this.estadisticas[0] += 3;
        this.estadisticas[1] += 3;
        if(this.vida == this.getVidaMaxima()){
            this.vida = this.vida;
        }else{
            this.vida+= otro.recibirDaño(this);
        }
        uiInfoCriatura.actualizar();
    }

    public void atacar4(Criatura otro) {
        this.criaturaAtaco = true;
         if(otro.vida == otro.getVidaMaxima()){
            otro.vida = otro.vida;
        }else{
             otro.vida += 25;
        }
        this.vida *= 0.80;
        this.uiInfoCriatura.actualizar();
        otro.uiInfoCriatura.actualizar();
>>>>>>> cd386784124023289aa9c20282096f50e323046a
    }
}
