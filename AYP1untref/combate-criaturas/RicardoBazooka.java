import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PikachuEnemigo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RicardoBazooka extends Criatura
{   

    public RicardoBazooka(String nombre, boolean imagenEspejada) {
        super(
<<<<<<< HEAD
            nombre, 
            1000,
            new String[] { "- Puño -", "- Patada -","- Granada -", "- Sniper -" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "-", "-", "-" },
            new int[] {10,100,3});
=======
            nombre,
            45,
            new String[] { "-Bazookazo-", "-Entrenamiento militar-","-rompeguardia-", "-Intercambio equivalente-" },
            imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Aumenta mucho tu ataque", "daña y disminuye la defensa del enemigo", "intercambia la vida de un enemigo y la tuya, tu ataque pasa a ser 1 (si la vida de ambos esta al maximo no funcionara)" },
            new int[] {45, 20,3});
>>>>>>> cd386784124023289aa9c20282096f50e323046a
    }

    public  RicardoBazooka(String nombre) {
        this(nombre, true);
    }

    public void atacar1(Criatura otro) {
        this.criaturaAtaco = true;
        otro.recibirDaño(this);
    }

    public void atacar1(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,0);
    }

    public void atacar2(Criatura otro) {
<<<<<<< HEAD
        atacar1(otro);
        super.imprimirMensaje(otro,1);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return false;
    }

    public void atacar3(Criatura otro) {
        atacar1(otro);
        super.imprimirMensaje(otro,2);
    }
=======
        this.criaturaAtaco = true;
        this.estadisticas[0] += 8;
    }

    public void atacar3(Criatura otro) {
        this.criaturaAtaco = true;
        otro.estadisticas[1]-= 4;
        otro.recibirDaño(this);
>>>>>>> cd386784124023289aa9c20282096f50e323046a

    }

    public void atacar4(Criatura otro) {
<<<<<<< HEAD
        atacar1(otro);
        super.imprimirMensaje(otro,3);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return false;
=======
        this.criaturaAtaco = true;
        int vidaEnm = otro.vida;
        if(otro.vida == otro.getVidaMaxima() || this.vida == this.getVidaMaxima()){
            this.vida = this.vida;
            otro.vida = otro.vida;
        }else{
            otro.vida = this.vida;
            this.vida = vidaEnm;
        }
        this.estadisticas[0] = 1;
        this.uiInfoCriatura.actualizar();
        otro.uiInfoCriatura.actualizar();
>>>>>>> cd386784124023289aa9c20282096f50e323046a
    }
}
