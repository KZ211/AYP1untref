import greenfoot.*;
import javax.swing.JOptionPane;

    /**
      * constructor: de la clase PantallaFinal.
      * Post:Inicializa la pantalla de juego, agrega criaturas, UI 
      * de ataques y comienza la primera ronda.
      */
public class PantallaDuelo extends World {
        private Texto turnoTexto;
        private UIAtaques uiAtaques;
        private Criatura[] criaturas = new Criatura[4];
        private GifLoop[] gifLoop = new GifLoop[5];
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
    
    /**
     * post:Agrega las criaturas al mundo del juego.
     */
    private void agregarCriaturas() {
        criaturas[0] = new JuanSlug("Juan Slug");
        criaturas[1] = new MartaSlug("Marta Slug");
        criaturas[2] = new SargentoEnrico("Sargento Enrico", true);
        criaturas[3] = new SargentoBrocos("Sargento Brocos", true);
        

        addGif();
        addObject(criaturas[0], 150, 220);
        addObject(criaturas[1], 380, 220);
        addObject(criaturas[2], 650, 220);
        addObject(criaturas[3], 850, 220);
    }
    
     /**
     * post:Agrega imágenes animadas (GIFs) de las criaturas al 
     *      mundo del juego.
     */
     public void addGif(){
        gifLoop[0] = new GifLoop("juanSlugMov.gif");
        gifLoop[1] = new GifLoop("MartaSluMov.gif");
        gifLoop[2] = new GifLoop("SargentoEnricom.gif");
        gifLoop[3] = new GifLoop("SargentoBrocos.gif");
        
        addObject(gifLoop[0], 150, 210);
        addObject(gifLoop[1], 380, 210);
        addObject(gifLoop[2], 650, 215);
        addObject(gifLoop[3], 850, 230);
    }
    
    /**
     * post:Avanza a la siguiente ronda del juego.
     */
    private void ronda() {
        ronda++;
        turno();
    }
    
     /**
     * post:Gestiona el turno actual del juego, saltando a la siguiente 
     *      criatura si el actual está muerto.
     */
    public void turno() {
        turno++;
        personaje++;
        int personajesMuertos = 0;
        
        //Cuando alcanza el maximo de jugadores comienza otra ronda
        if(personaje >= (criaturas.length-personajesMuertos)){
        personaje = -1;
        turno = 0;
        ronda();
        }
        //Cuando el jugador esta muerto lo saltea y si es el ultimo
        //inicia otra ronda
        if(criaturas[personaje].vida == 0){
                if((criaturas[1].vida == 0 && criaturas[2].vida == 0)){
                    personaje+=2;
                }else{
                    personaje++;
                }
            if (personaje >= criaturas.length) {
                personaje = -1;
                turno = 0;
                ronda();
            }
        }
        
        for (int i = 0; i < criaturas.length; i++) {
            criaturas[i].setVisualSeleccionado(false);
            if(criaturas[i].vida == 0){
            System.out.println("Muerte: "+criaturas[i].nombre + " Murio!");
            removeObject(this.criaturas[i]);
            removeObject(this.gifLoop[i]);
            personajesMuertos++;
            }
        }
        
        turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turno);
        System.out.println("********************************");
        System.out.println("******Ronda: "+ ronda +" | Turno: " + turno + "*******");
        System.out.println("********************************");
        System.out.println(".");
        uiAtaques.asignarCriaturaActual(criaturas[personaje]);
        }
        
    /**
     * parametro: c es la Criatura en la que se hizo clic.
     * post:Maneja el evento de clic en una criatura durante el juego, pasando al siguiente turno solo si la criatura ejecuto una
     *      accion, siendo tambien la condicion de victoria, que los 2 integrantes de un equipo tengan su vida en 0, aparte de escuchar
     *      si los estados estan activos.
     */
    public void click(Criatura c){
        uiAtaques.click(c);
        if(criaturas[this.personaje].getCriaturaAtaco() == false){
            // se agrega un anuncio flotante que indica que hay que realizar una acción.
            addObject(anuncio_, 520,330);
        }else{
            criaturas[this.personaje].criaturaAtaco = false;
            
            for(int i=0;i<criaturas.length;i++){
                criaturas[i].quemadura();
                criaturas[i].curacion();
            }
            
            if(c != criaturas[this.personaje]) {
            if(criaturas[0].vida==0 && criaturas[1].vida==0 || 
                criaturas[2].vida==0 && criaturas[3].vida==0){
                Greenfoot.setWorld(new PantallaFinal());    
            }else{
                turno();
                // Luego de cada turno, se remueve el anuncio de accion
                removeObject(anuncio_);
            }
        }
        }
    }
    
    /**
     * c es la Criatura sobre la que se pasa el mouse.
     * post:Maneja el evento de pasar el mouse sobre una criatura durante 
     *      el juego.
     */
    public void hover(Criatura c) {
            uiAtaques.hover(c);
    }
}
