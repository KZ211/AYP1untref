import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class Texto extends Actor {
    String texto;
    int tam;
    Color colorFrente;
    Color colorFondo;
    Color colorBorde;

    /**
     * Constructor de la clase Texto que muestra texto con colores específicos.
     * 
     * @param texto       El texto a mostrar.
     * @param tam         Tamaño del texto.
     * @param colorFrente Color del texto.
     * @param colorFondo  Color de fondo del texto.
     */
    public Texto(String texto, int tam, Color colorFrente, Color colorFondo) {
        this(texto, tam, colorFrente, colorFondo, null);
    }

    /**
     * Constructor de la clase Texto que muestra texto con colores específicos, incluyendo el color del borde.
     * 
     * @param texto       El texto a mostrar.
     * @param tam         Tamaño del texto.
     * @param colorFrente Color del texto.
     * @param colorFondo  Color de fondo del texto.
     * @param colorBorde  Color del borde del texto.
     */
    public Texto(String texto, int tam, Color colorFrente, Color colorFondo, Color colorBorde) {
        this.texto = texto;
        this.tam = tam;
        this.colorFrente = colorFrente;
        this.colorFondo = colorFondo;
        this.colorBorde = colorBorde;

        render();
    }

    /**
     * Actualiza el texto mostrado.
     * 
     * @param texto El nuevo texto a mostrar.
     */
    public void actualizarTexto(String texto) {
        this.texto = texto;

        render();
    }

    /**
     * Método interno para renderizar el texto en la imagen del actor.
     */
    private void render() {
        GreenfootImage txtImg = new GreenfootImage(" " + texto + " ", tam, colorFrente, colorFondo, colorBorde);

        setImage(txtImg);
    }
}
