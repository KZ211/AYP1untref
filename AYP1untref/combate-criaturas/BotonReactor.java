import greenfoot.*;

public class BotonReactor {
    Boton boton;
    UIAtaques uiAtaques;
    Criatura criaturaActual;
    int numeroAtaque;

    /**
     * Constructor del controlador de los botones de ataque.
     * 
     * @param boton El botón asociado al controlador.
     * @param uiAtaques La interfaz de ataques relacionada.
     * @param criaturaActual La criatura asociada a la interfaz.
     * @param numeroAtaque El número del ataque controlado por este botón.
     */
    public BotonReactor(Boton boton, UIAtaques uiAtaques, Criatura criaturaActual, int numeroAtaque) {
        this.boton = boton;
        this.uiAtaques = uiAtaques;
        this.criaturaActual = criaturaActual;
        this.numeroAtaque = numeroAtaque;

        boton.actualizar(this);
    }

    /**
     * Ejecuta la lógica de respuesta al clic en el botón de ataque.
     */
    public void run() {
        if (uiAtaques.botonSeleccionado == boton) {
            // Si se clickea lo que está seleccionado, se des-selecciona
            uiAtaques.ataque = null;
            uiAtaques.resetColorBotones();
            uiAtaques.descripcion.setText("");
            uiAtaques.botonSeleccionado = null;
        } else {
            // Si se clickea algo NO seleccionado, se selecciona y se prepara el posible ataque
            uiAtaques.ataque = () -> {
                if (puedeAtacarlo(uiAtaques.ataqueObjetivo)) {
                    uiAtaques.consola.setText(criaturaActual + " Ataco a " + 
                    uiAtaques.ataqueObjetivo + " con su ataque " + boton.getTextoBoton()
                    + " generandole " + criaturaActual.getDañoHecho());
                    atacar(uiAtaques.ataqueObjetivo);
                        uiAtaques.consola.setText("Ataque: ["+criaturaActual + "] Ataco a (" + 
                        uiAtaques.ataqueObjetivo + ") con su ataque [" + boton.getTextoBoton() +
                        "] generandole (" + (uiAtaques.ataqueObjetivo.getDañoHecho())+ ") de daño");
                        System.out.println("Ataque: ["+criaturaActual + "] Ataco a [" + 
                        uiAtaques.ataqueObjetivo + "] con su ataque [" + boton.getTextoBoton() +
                        "] generandole (" + uiAtaques.ataqueObjetivo.getDañoHecho() + ") de daño");
                        System.out.println(".");
                }
            };
            uiAtaques.resetColorBotones();
            boton.actualizar(Color.YELLOW);
            uiAtaques.descripcion.setText(getDetalleAtaque(criaturaActual));
            uiAtaques.botonSeleccionado = boton;
        }
    }

    /**
     * Obtiene el nombre del ataque controlado por este botón.
     * 
     * @return El nombre del ataque.
     */
    public String getNombreAtaque() {
        return this.criaturaActual.getNombresAtaque()[this.numeroAtaque - 1];
    }

    /**
     * Obtiene el detalle del ataque asociado a la criatura.
     * 
     * @param c La criatura cuyo ataque se quiere describir.
     * @return El detalle del ataque.
     */
    public String getDetalleAtaque(Criatura c) {
        return this.criaturaActual.getDetallesAtaque()[this.numeroAtaque - 1];
    }

    /**
     * Verifica si la criatura puede atacar a otra con el ataque asociado a este botón.
     * 
     * @param otro La criatura objetivo del ataque.
     * @return true si la criatura puede realizar el ataque, false en caso contrario.
     */
    public boolean puedeAtacarlo(Criatura otro) {
        switch (this.numeroAtaque) {
            case 1:
                return this.criaturaActual.puedeRealizarAtaque1En(otro);
            case 2:
                return this.criaturaActual.puedeRealizarAtaque2En(otro);
            case 3:
                return this.criaturaActual.puedeRealizarAtaque3En(otro);
            case 4:
                return this.criaturaActual.puedeRealizarAtaque4En(otro);
        }
        return false;
    }

    /**
     * Realiza el ataque de la criatura actual sobre otra criatura.
     * 
     * @param otro La criatura objetivo del ataque.
     */
    public void atacar(Criatura otro) {
        switch (this.numeroAtaque) {
            case 1:
                this.criaturaActual.atacar1(otro);
                break;
            case 2:
                this.criaturaActual.atacar2(otro);
                break;
            case 3:
                this.criaturaActual.atacar3(otro);
                break;
            case 4:
                this.criaturaActual.atacar4(otro);
                break;
        }
    }
}
