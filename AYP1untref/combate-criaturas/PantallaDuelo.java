import greenfoot.*;
import javax.swing.JOptionPane;

public class PantallaDuelo extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private Criatura[] criaturas = new Criatura[4];
    private GreenfootImage anuncioTurno;
    private int ronda = 0;
    private int turno = 0;
    private int personaje = -1;
    private Anuncio anuncio_;
    private int tiempo = 5;
    public PantallaDuelo() {
        super(1000, 700, 1);

        agregarCriaturas();

        turnoTexto = new Texto("Ronda 1 | Turno 1", 20, Color.BLACK, Color.WHITE);
        addObject(turnoTexto, turnoTexto.getImage().getWidth() / 2, turnoTexto.getImage().getHeight() / 2);
        
        tiempo--;
        
        uiAtaques = new UIAtaques(criaturas);
        addObject(uiAtaques, 400, 530);
        anuncio_ = new Anuncio();
        GreenfootImage imagenFondo = new GreenfootImage("elmejorbackground.jpg");
        getBackground().drawImage(imagenFondo, 0, 0);
        
        
        ronda();
    }

    private void agregarCriaturas() {
        criaturas[0] = new JuanSlug("Juan Slug");
        criaturas[1] = new MartaSlug("Marta Slug");
        criaturas[2] = new SargentoEnrico("Sargento Enrico", true);
        criaturas[3] = new RicardoBazooka("Ricardo Bazooka", true);

        addGif();
        addObject(criaturas[0], 150, 220);
        addObject(criaturas[1], 380, 220);
        addObject(criaturas[2], 650, 220);
        addObject(criaturas[3], 850, 220);
    }
    
     public void addGif(){
        GifLoop gifLoop= new GifLoop("juanSlugMov.gif");
        GifLoop gifLoop0= new GifLoop("MartaSluMov.gif");
        GifLoop gifLoop1= new GifLoop("SargentoEnricom.gif");
        GifLoop gifLoop2= new GifLoop("RicardoMov.gif");
        
        addObject(gifLoop, 150, 210);
        addObject(gifLoop0, 380, 210);
        addObject(gifLoop1, 650, 215);
        addObject(gifLoop2, 850, 230);
    }

    private void ronda() {
        ronda++;
        turno();
    }

    //aumenta turno en 1 y valida que turno no sea mayor al numero de jugadores
    //en ese caso resetea turno a 0 e inicia una nueva ronda
    public void turno() {
        turno++;
        personaje++;
        
        if(personaje >= criaturas.length){
        personaje = -1;
        turno = 0;
        ronda();
        }
        
        while(criaturas[personaje].vida == 0) {
            personaje++;
            if (personaje >= criaturas.length) {
                personaje = -1;
                ronda();
            }
        }
        
        for (int i = 0; i < criaturas.length; i++) {
            criaturas[i].setVisualSeleccionado(false);
        }
        
        turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turno);
        uiAtaques.asignarCriaturaActual(criaturas[personaje]);
        }
        
    //cuando clikee una criatura va al siguiente turno
    public void click(Criatura c){
        uiAtaques.click(c);
        if(criaturas[this.personaje].getCriaturaAtaco() == false){
            // se agrega un anuncio flotante que indica que hay que realizar una acción.
            addObject(anuncio_, 520,330);
        }else{
            criaturas[this.personaje].criaturaAtaco = false;
            if(c != criaturas[this.personaje]) {
            if(criaturas[0].vida==0 && criaturas[1].vida==0 || 
                criaturas[2].vida==0 && criaturas[3].vida==0){
                Greenfoot.setWorld(new PantallaFinal());    
            }else{
                turno();
                // Luego de cada turno, se remueve el anuncio de accion
                removeObject(anuncio_);
            }
        }}
    }

    public void hover(Criatura c) {
            uiAtaques.hover(c);
    }
}
