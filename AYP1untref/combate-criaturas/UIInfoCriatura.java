import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class UIInfoCriatura extends Actor {
    private static final int MARGIN = 8;
    Criatura criatura;
    int width = 120;

    public UIInfoCriatura(Criatura criatura) {
        this.criatura = criatura;
    }

    @Override
    protected void addedToWorld(World world) {
        actualizar();
    }

    public void actualizar() {
        GreenfootImage imagenNombre = new GreenfootImage(criatura.toString(), 20, Color.BLACK, null);
        GreenfootImage imagenVida = new GreenfootImage(
                " " + criatura.getVida() + " / " + criatura.getVidaMaxima() + " ", 20, Color.BLACK, null);

        double barraWidth = width - MARGIN * 2.5;
        GreenfootImage imagenBarra = new GreenfootImage(width - MARGIN * 2, 12);
        imagenBarra.setColor(Color.RED);

<<<<<<< HEAD
        imagenBarra.fillRect(0, 0, (int) (criatura.getVida() * 100/criatura.getVidaMaxima()), 11);
=======
        //Barra de vida modificada en base al porcentaje de vida de cada bichito
        imagenBarra.fillRect(0, 0, (int) (criatura.vida*100/criatura.vidaMaxima), 11);
>>>>>>> dcc8707d01f92c8b72f5bc0c9d75afc33a7fc9f0
        imagenBarra.setColor(Color.BLACK);
        imagenBarra.drawRect(0, 0, (int) barraWidth - 1, 11);

        int height = imagenNombre.getHeight() + imagenBarra.getHeight() + imagenVida.getHeight();

        GreenfootImage imagen = new GreenfootImage(width, height);

        imagen.setColor(criatura.esEquipo1() ? Color.PINK : Color.BLUE);
        imagen.fill();

        imagen.drawImage(imagenNombre, (width - imagenNombre.getWidth()) / 2, 0);
        imagen.drawImage(imagenBarra, MARGIN, imagenNombre.getHeight());
        imagen.drawImage(imagenVida, (width - imagenVida.getWidth()) / 2,
<<<<<<< HEAD
                imagenNombre.getHeight() + imagenBarra.getHeight());
=======
            imagenNombre.getHeight() + imagenBarra.getHeight());
>>>>>>> dcc8707d01f92c8b72f5bc0c9d75afc33a7fc9f0

        setImage(imagen);
    }
}
