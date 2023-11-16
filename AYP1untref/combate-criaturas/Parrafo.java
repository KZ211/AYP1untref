import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;

public class Parrafo extends Actor {
    private static final int MARGIN_X = 10;


    private static final String MONOSPACED_FONT_FAMILY = "Monospaced";

    private String originalText;
    private int fontSize;
    private Color fontColor;

    private int width;
    private int height;

    private int charWidth;
    private String wrappedText;

    /**
     * Constructor de la clase Parrafo.
     * 
     * @param text   Texto que se muestra en el párrafo.
     * @param size   Tamaño de la fuente del párrafo.
     * @param color  Color del texto del párrafo.
     * @param width  Ancho del área del párrafo.
     * @param height Alto del área del párrafo.
     */
    public Parrafo(String text, int size, Color color, int width, int height) {
        this.fontColor = color;
        this.width = width;
        this.height = height;
        
        this.originalText = text;
        setSize(size);
    }

    /**
     * Establece el tamaño de la fuente y recalcula el texto envuelto.
     * 
     * @param size Tamaño de la fuente a establecer.
     */
    public void setSize(int size) {
        this.fontSize = size;

        // Calcular el ancho de un carácter en fuente monoespaciada
        java.awt.Font font = new java.awt.Font(MONOSPACED_FONT_FAMILY, java.awt.Font.PLAIN, this.fontSize);
        java.awt.Canvas placeholder = new java.awt.Canvas();
        java.awt.FontMetrics fm = placeholder.getFontMetrics(font);
        this.charWidth = fm.charWidth('a');
        
        wrapText();
        render();
    }

    /**
     * Establece el texto a mostrar y recalcula el texto envuelto.
     * 
     * @param text Texto a establecer.
     */
    public void setText(String text) {
        this.originalText = text;

        wrapText();
        render();
    }

    /**
     * Método interno para envolver el texto según el ancho establecido.
     */
    protected void wrapText() {
        int maxChars = (width - MARGIN_X * 2) / charWidth;

        String finalText = "";
        String[] lines = this.originalText.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split(" ");
            String line = "";
            for (int j = 0; j < words.length; j++) {
                if (line.equals("")) {
                    line = words[j];
                } else {
                    if (line.length() + words[j].length() >= maxChars) {
                        finalText += line + "\n";
                        line = words[j];
                    } else {
                        line += " " + words[j];
                    }
                }
            }
            finalText += line + "\n";
        }
        this.wrappedText = finalText;
    }

    /**
     * Método interno para renderizar el texto en la imagen del actor.
     */
    private void render() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(fontColor);
        img.setFont(new Font(MONOSPACED_FONT_FAMILY, false, false, fontSize));
        img.drawString(wrappedText, MARGIN_X, 30);
        setImage(img);
    }
}
