import greenfoot.*;

public class PantallaDuelo extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private Criatura[] criaturas = new Criatura[4];

    private int ronda = 0;
    private int turno = 0;


    public PantallaDuelo() {
        super(700, 400, 1);

        agregarCriaturas();

        turnoTexto = new Texto("Ronda 1 | Turno 1", 20, Color.BLACK, Color.WHITE);
        addObject(turnoTexto, turnoTexto.getImage().getWidth() / 2, turnoTexto.getImage().getHeight() / 2);

        uiAtaques = new UIAtaques(criaturas);
        addObject(uiAtaques, 350, 300);

        GreenfootImage imagenFondo = new GreenfootImage("elmejorbackground.jpg");
        getBackground().drawImage(imagenFondo, 0, 0);

        ronda();
    }

    private void agregarCriaturas() {
        criaturas[0] = new JuanSlug("Juan Slug");
        criaturas[1] = new MartaSlug("Marta Slug");
        criaturas[2] = new RicardoParagua("Ricardo Paragua", true);
        criaturas[3] = new RicardoBazooka("Ricardo Bazooka", true);

        addObject(criaturas[0], 100, 80);
        addObject(criaturas[1], 240, 80);
        addObject(criaturas[2], 460, 80);
        addObject(criaturas[3], 600, 80);
    }

    private void ronda() {
        ronda++;
        turno();
    }

    //aumenta turno en 1 y valida que turno no sea mayor al numero de jugadores
    //en ese caso resetea turno a 0 e inicia una nueva ronda
    public void turno() {
        turno++;
        
        if (turno > criaturas.length) {
            turno = 0;
            ronda();
        }
        
        for (int i = 0; i < criaturas.length; i++) {
            criaturas[i].setVisualSeleccionado(false);
        }
        
        turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turno);
        uiAtaques.asignarCriaturaActual(criaturas[turno-1]);
    }
    
    //cuando clikee una criatura va al siguiente turno
    public void click(Criatura c) {
        uiAtaques.click(c);
        if(c != criaturas[turno-1]) {
            turno();
        }
    }

    public void hover(Criatura c) {
            uiAtaques.hover(c);
    }
}
