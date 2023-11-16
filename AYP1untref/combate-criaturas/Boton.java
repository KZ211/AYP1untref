import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Boton extends Actor {
    private String texto;
    private int size;
    private Color color;
    private Color bgColor;
    
    private BotonReactor onClick;

    private int forceWidth;
    private int forceHeight;
    
    /**
     * Constructor de la clase Boton.
     * Crea un botón con un texto, tamaño, color, y acción a realizar al ser clickeado.
     * @param texto El texto que aparecerá en el botón.
     * @param onClick La acción a ejecutar al ser clickeado.
     * @param size El tamaño del texto del botón.
     * @param color El color del texto del botón.
     * @param width El ancho forzado del botón (0 si se calcula automáticamente).
     * @param height El alto forzado del botón (0 si se calcula automáticamente).
     */
    public Boton(String texto, BotonReactor onClick, int size, Color color, int width, int height) {
        this.texto = texto;
        this.onClick = onClick;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.forceWidth = width;
        this.forceHeight = height;
        render();
    }

    /**
     * Constructor de la clase Boton (versión simplificada).
     * Crea un botón con un texto y una acción a realizar al ser clickeado.
     * @param texto El texto que aparecerá en el botón.
     * @param onClick La acción a ejecutar al ser clickeado.
     */
    public Boton(String texto, BotonReactor onClick) {
        this(texto, onClick, 30, Color.BLACK, 0, 0);
    }
    
    /**
     * Obtiene el texto actual del botón.
     * @return El texto actual del botón.
     */
    public String getTextoBoton(){
        return this.texto;
    }

    /**
     * Método act que se ejecuta cuando se clickea el botón.
     * Ejecuta la acción asociada al botón.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            onClick.run();
        }
    }
    
    /**
     * Actualiza el botón con una nueva acción y texto.
     * @param onClick La nueva acción a asociar al botón.
     */
    public void actualizar(BotonReactor onClick) {
        this.texto = onClick.getNombreAtaque();
        this.onClick = onClick;
        render();
    }
    
    /**
     * Actualiza el botón con un nuevo texto, acción y color de fondo.
     * @param texto El nuevo texto a mostrar en el botón.
     * @param onClick La nueva acción a asociar al botón.
     * @param bgColor El nuevo color de fondo del botón.
     */
    public void actualizar(String texto, BotonReactor onClick, Color bgColor) {
        this.texto = texto;
        this.onClick = onClick;
        this.bgColor = bgColor;
        render();
    }
    
    /**
     * Actualiza el color de fondo del botón.
     * @param bgColor El nuevo color de fondo del botón.
     */
    public void actualizar(Color bgColor) {
        this.bgColor = bgColor;
        render();
    }
    
    
    private void render() {
        GreenfootImage txtImg = new GreenfootImage(" " + texto + " ", size, color, bgColor);
        int BORDER_X = 2;
        int BORDER_Y = 2;

        int height = forceHeight != 0 ? forceHeight : txtImg.getHeight() + 2 * BORDER_Y;
        int width = forceWidth != 0 ? forceWidth : txtImg.getWidth() + 2 * BORDER_X;

        GreenfootImage image = new GreenfootImage(width, height);

        image.setColor(Color.LIGHT_GRAY);
        image.fill();
        image.setColor(bgColor);
        image.fillRect(BORDER_X, BORDER_Y, width - BORDER_X * 2, height - BORDER_Y * 2);

        image.drawImage(txtImg, (width - txtImg.getWidth()) / 2, (height - txtImg.getHeight()) / 2);

        setImage(image);
    }
}
