import greenfoot.*;

public class PantallaDuelo extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private Criatura[] criaturas = new Criatura[4];

    private int ronda = 0;
    private int turno = 0;
    private int personaje = -1;


    public PantallaDuelo() {
        super(800, 500, 1);

        agregarCriaturas();

        turnoTexto = new Texto("Ronda 1 | Turno 1", 20, Color.BLACK, Color.WHITE);
        addObject(turnoTexto, turnoTexto.getImage().getWidth() / 2, turnoTexto.getImage().getHeight() / 2);

        uiAtaques = new UIAtaques(criaturas);
        addObject(uiAtaques, 400, 350);

        GreenfootImage imagenFondo = new GreenfootImage("elmejorbackground.jpg");
        getBackground().drawImage(imagenFondo, 45, 0);

        ronda();
    }

    private void agregarCriaturas() {
        criaturas[0] = new JuanSlug("Juan Slug");
        criaturas[1] = new MartaSlug("Marta Slug");
        criaturas[2] = new SargentoEnrico("Sargento Enrico", true);
        criaturas[3] = new RicardoBazooka("Ricardo Bazooka", true);

        addObject(criaturas[0], 150, 80);
        addObject(criaturas[1], 290, 80);
        addObject(criaturas[2], 510, 80);
        addObject(criaturas[3], 650, 80);
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
            System.out.println("Primero haz un ataque para avanzar el turno");
        }else{
            criaturas[this.personaje].criaturaAtaco = false;
            if(c != criaturas[this.personaje]) {
            if(criaturas[0].vida==0 && criaturas[1].vida==0 || 
                criaturas[2].vida==0 && criaturas[3].vida==0){
                System.out.println("Felicidades, ganaste");
            }else{
                turno();
            }
        }}
    }

    public void hover(Criatura c) {
            uiAtaques.hover(c);
    }
}
