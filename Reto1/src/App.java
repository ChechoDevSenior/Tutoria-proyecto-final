import java.util.Random;
import java.util.Scanner;

public class App {
    
    //Variables globales.
    static Scanner scanner = new Scanner (System.in);
    static String[] planetas = {"Marte","Jupiter","Saturno"};
    static double[] distancias = { 123.0, 890.2, 1300};//Distancia en millones de km
    static String [] naves = {"Navegador","Transportador","Rayo Veloz"};
    static double [] velocidades = {34000.0, 28000.0, 54000};
    static double [] consumoCombustible ={100, 150, 160}; //consumo de combustible en millones de km
    static int naveSeleccionada; //apunta a la posición de la nave en listado, más no en nombre.
    static int planetaSeleccionado; //Indica la posición del planeta seleccionado en planetas
    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                     seleccionarPlaneta();
                    break;
                case 2:
                    seleccionarNaveEspacial();
                    break;
                case 3:
                    simulacionViaje();
                    break;
                
            
                default:
                    break;
            }
        } while (opcion !=4);
    }
    public static void mostrarMenu() {
        System.out.println("-----Menu Principal-----");
        System.out.println("1. Seleccionar planeta de destino.");
        System.out.println("2. Seleccionar una nave espacial.");
        System.out.println("3. Iniciar simulación de viaje.");
        System.out.println("4. Salir.");
        System.out.println("Por favor elija una opción.");
    }
    public static void seleccionarPlaneta(){
        System.out.println("---Selección del Planeta-----");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println("Planeta: "+(i+1)+". "+planetas[i]+ " - Distancia " + distancias[i]);
        }
        System.out.print("Selecciona un planeta: ");
        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= planetas.length) {
            System.out.println("Has seleccionado el planeta "+planetas[seleccion-1]);
            planetaSeleccionado = seleccion -1;
        } else {
            System.out.println("Selección invalida. Intenta de nuevo.");
        }
    }
    public static void seleccionarNaveEspacial(){
        System.out.println(" ");
        System.out.println("---Selección de una aeronave-----");
        for (int i = 0; i < naves.length; i++) {
            System.out.println("Nave: "+(i+1)+". "+naves[i]+ "- Velocidad " + velocidades[i]);
        }
        System.out.print("Selecciona una nave: ");
        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= naves.length) {
            System.out.println("Has seleccionado la nave "+naves[seleccion-1]);
            naveSeleccionada = seleccion -1;
        } else {
            System.out.println("Selección invalida. Intenta de nuevo.");
        }
    }
    public static void simulacionViaje(){
        System.out.println("----Iniciando viaje ------");
        Random random = new Random();
        for (int progreso = 0; progreso <= 100; progreso+=10) {
            System.out.println("Progreso: "+progreso+"%.");
            if (progreso == 50) {
                System.out.println("Mitad del camino alcanzado.");
            }

            if (random.nextInt(10)<3) {
                System.out.println("Evento inesperado! Realizando ajustes.");
            }
            try{//intentalo hacer 
                Thread.sleep(500);  
            }catch(InterruptedException e){
                System.out.println("Erro de la simulación.");
            }
        }
        System.out.println("Llegada exitosa al destino.");
    }
    public static void calcularRecursos (){
        double combustible = consumoCombustible [naveSeleccionada];
        double oxigeno = distancias[planetaSeleccionado] * 100; // unidades de oxigeno por cada millon de km, se necesita 100 unidades de Oxigeno.
        System.out.println("El combustible necesario es: "+combustible);
        System.out.println("La cantidad de unidades de oxigeno necesario es: " + oxigeno);    
    }
    
}
