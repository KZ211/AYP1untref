   import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class UIAtaques extends Actor {
    Criatura criaturaActual;
    Texto tituloAtaques;
    Boton b1, b2, b3, b4;
    Criatura[] criaturas;
    Boton botonSeleccionado;
    Parrafo descripcion;
<<<<<<< HEAD
=======
    TextoConsola consola;
>>>>>>> ecd1e18032a2c28d8cdaec8f1da5126199f16612
    Runnable ataque = null;
    Criatura ataqueObjetivo = null;
    Criatura hoverObjetivo = null;

<<<<<<< HEAD
    public UIAtaques(Criatura[] criaturas) {
        this.criaturas = criaturas;

        b1 = new Boton("", null, 25, Color.BLACK, 320, 30);
        b2 = new Boton("", null, 25, Color.BLACK, 320, 30);
        b3 = new Boton("", null, 25, Color.BLACK, 320, 30);
        b4 = new Boton("", null, 30, Color.BLACK, 320, 36);
        descripcion = new Parrafo("Ataque", 20, Color.BLACK, 344, 192);
        tituloAtaques = new Texto("Ataques", 30, Color.BLACK, null);
    }

    @Override
    protected void addedToWorld(World world) {
        getWorld().addObject(tituloAtaques, 170, 225);
        getWorld().addObject(b1, 176, 265);
        getWorld().addObject(b2, 176, 300);
        getWorld().addObject(b3, 176, 335);
        getWorld().addObject(b4, 176, 373);
        getWorld().addObject(descripcion, 352 + 344 / 2, 300);
    }

    public void asignarCriaturaActual(Criatura criaturaActual) {
        this.criaturaActual = criaturaActual;

        tituloAtaques.actualizarTexto(criaturaActual.toString());
        descripcion.setText("");
        botonSeleccionado = null;
        ataque = null;
        resetColorBotones();
        criaturaActual.setVisualSeleccionado(true);

        dibujarFondo();

        Boton[] botones = { b1, b2, b3, b4 };

        for (int i = 0; i < botones.length; i++) {
            new BotonReactor(botones[i], this, criaturaActual, i + 1);
        }
    }

    public void click(Criatura c) {
        ataqueObjetivo = c;
        if (botonSeleccionado == null) {
            descripcion.setText(c.getStats());
        }
        if (ataque != null ) {
            ataque.run();
        }
    }

    public void hover(Criatura c) {
        if (hoverObjetivo == c) {
            return;
        }

        hoverObjetivo = c;
        if (botonSeleccionado == null) {
            // descripcion.actualizarTexto(c.toString());
        }
    }

    void resetColorBotones() {
        b1.actualizar(Color.LIGHT_GRAY);
        b2.actualizar(Color.LIGHT_GRAY);
        b3.actualizar(Color.LIGHT_GRAY);
        b4.actualizar(Color.LIGHT_GRAY);
    }

    private void dibujarFondo() {
        GreenfootImage imagenBarra = new GreenfootImage(700, 200);
        imagenBarra.setColor(Color.BLACK);
        imagenBarra.fill();
        imagenBarra.setColor(criaturaActual.esEquipo1() ? Color.RED : Color.BLUE);
        imagenBarra.fillRect(4, 4, 344, 192);
        imagenBarra.setColor(Color.LIGHT_GRAY);
        imagenBarra.fillRect(352, 4, 344, 192);
        setImage(imagenBarra);
    }
=======
    /**
     * Constructor de la interfaz gráfica para mostrar ataques y detalles de criaturas.
     * 
     * @param criaturas Un arreglo de criaturas disponibles.
     */
    public UIAtaques(Criatura[] criaturas) {
        this.criaturas = criaturas;

        // Inicialización de componentes
        b1 = new Boton("", null, 25, Color.BLACK, 200, 30);
        b2 = new Boton("", null, 25, Color.BLACK, 200, 30);
        b3 = new Boton("", null, 25, Color.BLACK, 200, 30);
        b4 = new Boton("", null, 30, Color.BLACK, 200, 36);
        descripcion = new Parrafo("Ataque", 20, Color.BLACK, 344, 192);
        tituloAtaques = new Texto("Ataques", 30, Color.BLACK, null);
        consola = new TextoConsola("", 20, Color.WHITE, 370, 210);
    }

    /**
     * Método llamado cuando el actor se agrega al mundo.
     * 
     * @param world El mundo al que se ha agregado el actor.
     */
    @Override
    protected void addedToWorld(World world) {
        // Agregando los componentes al mundo
        getWorld().addObject(tituloAtaques, 500, 375);
        getWorld().addObject(b1, 140, 415);
        getWorld().addObject(b2, 500, 415);
        getWorld().addObject(b3, 850, 415);
        getWorld().addObject(b4, 500, 470);
        getWorld().addObject(descripcion, 344 / 2, 600);
        getWorld().addObject(consola, 1400 / 2, 605);
    }

    /**
     * Asigna la criatura actual para mostrar sus ataques y detalles.
     * 
     * @param criaturaActual La criatura seleccionada actualmente.
     */
    public void asignarCriaturaActual(Criatura criaturaActual) {
        this.criaturaActual = criaturaActual;

        // Actualiza el texto del título con el nombre de la criatura actual
        tituloAtaques.actualizarTexto(criaturaActual.toString());

        // Limpia el texto de descripción
        descripcion.setText("");

        // Restablece el botón seleccionado y la lógica de ataque
        botonSeleccionado = null;
        ataque = null;

        // Restablece los colores de los botones a un estado predeterminado
        resetColorBotones();

        // Marca visualmente la criatura seleccionada
        criaturaActual.setVisualSeleccionado(true);

        // Dibuja el fondo y los botones de ataque disponibles
        dibujarFondo();

        // Agrega controladores de eventos a los botones para activar los ataques
        Boton[] botones = { b1, b2, b3, b4 };
        for (int i = 0; i < botones.length; i++) {
            new BotonReactor(botones[i], this, criaturaActual, i + 1);
        }
    }

    /**
     * Controla el evento de clic en una criatura para un ataque.
     * 
     * @param c La criatura objetivo seleccionada para el ataque.
     */
    public void click(Criatura c) {
        ataqueObjetivo = c;

        // Si no hay ningún botón seleccionado, muestra las estadísticas de la criatura objetivo
        if (botonSeleccionado == null) {
            descripcion.setText(c.getStats());
        }
>>>>>>> ecd1e18032a2c28d8cdaec8f1da5126199f16612

        // Ejecuta el ataque si está disponible
        if (ataque != null) {
            ataque.run();
        }
    }

    /**
     * Controla el evento de pasar el cursor sobre una criatura.
     * 
     * @param c La criatura objetivo sobre la que se posiciona el cursor.
     */
    public void hover(Criatura c) {
        // Si la criatura objetivo es la misma que ya está en enfoque, no hace nada
        if (hoverObjetivo == c) {
            return;
        }

        // Actualiza la criatura objetivo en enfoque
        hoverObjetivo = c;

        // Si no hay botón seleccionado, se puede mostrar información sobre la criatura
        if (botonSeleccionado == null) {
            // descripcion.actualizarTexto(c.toString());
        }
    }

    /**
     * Restablece los colores de los botones de ataque a un estado predeterminado.
     */
    void resetColorBotones() {
        b1.actualizar(Color.LIGHT_GRAY);
        b2.actualizar(Color.LIGHT_GRAY);
        b3.actualizar(Color.LIGHT_GRAY);
        b4.actualizar(Color.LIGHT_GRAY);
    }

    /**
     * Dibuja el fondo de la interfaz con la información de la criatura actual.
     */
    private void dibujarFondo() {
        GreenfootImage imagenBarra = new GreenfootImage(1190, 350);
        imagenBarra.setColor(Color.BLACK);
        imagenBarra.fill();

        // Colorea la barra superior con el color del equipo de la criatura actual
        imagenBarra.setColor(criaturaActual.esEquipo1() ? Color.RED : Color.BLUE);
        imagenBarra.fillRect(4, 4, 1190, 150);

        // Dibuja un área gris para descripciones y detalles
        imagenBarra.setColor(Color.LIGHT_GRAY);
        imagenBarra.fillRect(4, 160, 710, 180);

        // Establece la imagen como el fondo de la interfaz
        setImage(imagenBarra);
    }
}
