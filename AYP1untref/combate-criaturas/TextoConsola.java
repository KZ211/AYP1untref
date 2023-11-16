import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;

public class TextoConsola extends Actor {
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
     * Constructor de la clase TextoConsola que muestra texto con estilo de fuente monoespaciada.
     * 
     * @param text   El texto a mostrar.
     * @param size   Tamaño del texto.
     * @param color  Color del texto.
     * @param width  Ancho máximo del texto.
     * @param height Altura del texto.
     */
    public TextoConsola(String text, int size, Color color, int width, int height) {
        this.fontColor = color;
        this.width = width;
        this.height = height;
        
        this.originalText = text;
        setSize(size);
    }

    /**
     * Establece el tamaño de la fuente.
     * 
     * @param size Tamaño del texto.
     */
    public void setSize(int size) {
        this.fontSize = size;

        // Calcula el ancho de cada carácter en la fuente monoespaciada
        java.awt.Font font = new java.awt.Font(MONOSPACED_FONT_FAMILY, java.awt.Font.PLAIN, this.fontSize);
        java.awt.Canvas placeholder = new java.awt.Canvas();
        java.awt.FontMetrics fm = placeholder.getFontMetrics(font);
        this.charWidth = fm.charWidth('a');
        
        wrapText();
        render();
    }

    /**
     * Establece el texto a mostrar.
     * 
     * @param text El nuevo texto a mostrar.
     */
    public void setText(String text) {
        this.originalText = text;

        wrapText();
        render();
    }

    /**
     * Método interno para ajustar el texto para que encaje dentro del ancho especificado.
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
