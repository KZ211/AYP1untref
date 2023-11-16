import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class UIInfoCriatura extends Actor {
    private static final int MARGIN = 8;
    Criatura criatura;
    int width = 120;

    /**
     * Constructor de la interfaz de información de la criatura.
     * 
     * @param criatura La criatura asociada a esta interfaz.
     */
    public UIInfoCriatura(Criatura criatura) {
        this.criatura = criatura;
    }

    /**
     * Método llamado cuando se agrega al mundo la interfaz.
     * Actualiza la información visual de la criatura.
     * 
     * @param world El mundo al que se agrega la interfaz.
     */
    @Override
    protected void addedToWorld(World world) {
        actualizar();
    }

    /**
     * Actualiza la información visual de la interfaz según los datos de la criatura.
     */
    public void actualizar() {
        // Crea una imagen para el nombre de la criatura
        GreenfootImage imagenNombre = new GreenfootImage(criatura.toString(), 20, Color.BLACK, null);

        // Crea una imagen para la visualización de la vida de la criatura
        GreenfootImage imagenVida = new GreenfootImage(
                " " + criatura.getVida() + " / " + criatura.getVidaMaxima() + " ", 20, Color.BLACK, null);

        // Calcula el ancho de la barra de vida
        double barraWidth = width - MARGIN * 2.5;
        GreenfootImage imagenBarra = new GreenfootImage(width - MARGIN * 2, 12);
        imagenBarra.setColor(Color.RED);

        // Dibuja la barra de vida proporcional al porcentaje de vida de la criatura
        imagenBarra.fillRect(0, 0, (int) (criatura.vida * 100 / criatura.vidaMaxima), 11);
        imagenBarra.setColor(Color.BLACK);
        imagenBarra.drawRect(0, 0, (int) barraWidth - 1, 11);

        int height = imagenNombre.getHeight() + imagenBarra.getHeight() + imagenVida.getHeight();

        // Crea la imagen final para la interfaz con los componentes
        GreenfootImage imagen = new GreenfootImage(width, height);
        imagen.setColor(criatura.esEquipo1() ? Color.PINK : Color.BLUE);
        imagen.fill();

        // Coloca los componentes en la imagen final
        imagen.drawImage(imagenNombre, (width - imagenNombre.getWidth()) / 2, 0);
        imagen.drawImage(imagenBarra, MARGIN, imagenNombre.getHeight());
        imagen.drawImage(imagenVida, (width - imagenVida.getWidth()) / 2,
            imagenNombre.getHeight() + imagenBarra.getHeight());

        // Establece la imagen como el contenido de la interfaz
        setImage(imagen);
    }
}
