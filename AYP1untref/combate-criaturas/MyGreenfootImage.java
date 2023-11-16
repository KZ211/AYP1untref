import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * Es una subclase de GreenfootImage que proporciona métodos adicionales para manipular y configurar imágenes.
 */
public class MyGreenfootImage extends GreenfootImage {
    // Colores predeterminados para los efectos
    private static final Color HIGHLIGHT_COLOR = new Color(30, 200, 200);
    private static final Color SILHOUETTE_COLOR = new Color(30, 30, 30);
    private static final Color SHADOW_COLOR = new Color(30, 30, 30, 100);

    // Constructores

    /**
     * Crea una instancia de MyGreenfootImage utilizando otra GreenfootImage como base.
     * 
     * @param image La imagen sobre la cual se basará esta instancia.
     * @throws IllegalArgumentException si la imagen es nula.
     */
    public MyGreenfootImage(GreenfootImage image) throws IllegalArgumentException {
        super(image);
        configurar();
    }

    /**
     * Crea una instancia de MyGreenfootImage con el ancho y alto especificados.
     * 
     * @param width Ancho de la imagen.
     * @param height Alto de la imagen.
     */
    public MyGreenfootImage(int width, int height) {
        super(width, height);
        configurar();
    }

    // Métodos

    /**
     * Crea una copia de esta MyGreenfootImage.
     * 
     * @return Una copia exacta de esta imagen.
     */
    public MyGreenfootImage clone() {
        return new MyGreenfootImage(this);
    }

    /**
     * Método que permite extender el comportamiento de la configuración de la imagen.
     */
    public void configurar() {
    }

    /**
     * Aplica un efecto de sombra a la imagen.
     * 
     * Se escala la imagen, se dibuja una elipse con color de sombra y se vuelve a dibujar la imagen original sobre ella.
     */
    public void shadow() {
        // Implementación del efecto de sombra
        MyGreenfootImage copy = clone();

        clear();
        scale(getWidth(), (int) (getHeight() * 9.0 / 8.0));

        setColor(SHADOW_COLOR);
        fillOval((int) (getWidth() * 0.1), (int) (3.5 * copy.getHeight() / 4), (int) (getWidth() * 0.8),
            getHeight() / 5);

        drawImage(copy, 0, 0);
    }

    /**
     * Aplica un efecto de silueta a la imagen.
     * 
     * Transforma todos los colores de la imagen a un tono oscuro.
     */
    public void silhouette() {
        // Implementación del efecto de silueta
        Color shade = SILHOUETTE_COLOR;
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color color = getColorAt(x, y);
                setColorAt(x, y, new Color(shade.getRed(), shade.getGreen(), shade.getBlue(), color.getAlpha()));
            }
        }
    }

    /**
     * Aplica un efecto de resaltado a la imagen con el color predeterminado.
     */
    public void highlight() {
        highlight(HIGHLIGHT_COLOR);
    }

    /**
     * Aplica un efecto de resaltado a la imagen con un color específico.
     * 
     * @param highlight El color de resaltado a aplicar.
     */
    public void highlight(Color highlight) {
        // Implementación del efecto de resaltado
        MyGreenfootImage copy = clone();

        final int DELTA = 3;

        for(int i = 0; i < DELTA; i++) {
            MyGreenfootImage x = this.clone();
            drawImage(x, 0, -1);
            drawImage(x, 1, 0);
            drawImage(x, -1, 0);
            drawImage(x, 0, 1);
        }

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color colorHere = getColorAt(x, y);
                setColorAt(x, y,
                    new Color(highlight.getRed(), highlight.getGreen(), highlight.getBlue(), colorHere.getAlpha()));
            }
        }

        // Y se vuelve a pintar la imagen original encima
        drawImage(copy, 0, 0);
    }

    /**
     * Convierte la imagen a una escala de grises.
     */
    public void grayscale() {
        // Implementación de la conversión a escala de grises
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color colorHere = getColorAt(x, y);
                int brightness = (colorHere.getRed() + colorHere.getGreen() + colorHere.getBlue()) / 3;
                setColorAt(x, y, new Color(brightness, brightness, brightness, colorHere.getAlpha()));
            }
        }
    }

    /**
     * Voltea horizontalmente la imagen.
     */
    public void flipHorizontally() {
        mirrorHorizontally();
    }

    /**
     * Escala la imagen a un ancho y alto específicos.
     * 
     * @param width El nuevo ancho de la imagen.
     * @param height El nuevo alto de la imagen.
     */
    public void scaleTo(int width, int height) {
        // Implementación del escalado a dimensiones específicas
        scale(width, height);
    }

    /**
     * Escala la imagen a una proporción específica.
     * 
     * @param ratio El ratio por el que se escalará la imagen.
     */
    public void scaleToRatio(double ratio) {
        // Implementación del escalado según una proporción específica
        scale((int) (getWidth() * ratio), (int) (getHeight() * ratio));
    }

    /**
     * Aplica un cambio de tonalidad a la imagen con un color específico.
     * 
     * @param color El color para aplicar la tonalidad.
     */
    public void applyHue(Color color) {
        // Implementación de la aplicación de tonalidad
        float colorHue = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[0];
        applyHue(colorHue);
    }

    private void applyHue(float hueEquipo) {
        // Implementación adicional de la aplicación de tonalidad
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                Color color = getColorAt(x, y);

                float[] hsb = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                java.awt.Color colorEquipoHue = new java.awt.Color(java.awt.Color.HSBtoRGB(hueEquipo, hsb[1], hsb[2]));

                setColorAt(x, y, new Color(colorEquipoHue.getRed(), colorEquipoHue.getGreen(), colorEquipoHue.getBlue(),
                        color.getAlpha()));
            }
        }
    }
}
