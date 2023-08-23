package grafo.aydacencia;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner leer = new Scanner(System.in);
	        GrafoAdcia grafo = new GrafoAdcia(20);
	        Recorrido_Profundidad dfs = new Recorrido_Profundidad(grafo);
	        int opcion;
	        do {
	        System.out.println("\nMenú de Opciones:");
            System.out.println("1. Agregar un nuevo vértice");
            System.out.println("2. Agregar un nuevo arco");
            System.out.println("3. Realizar Recorrido en Profundidad");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); 

            switch (opcion) {
                case 1:
                	System.out.print("Ingrese la cantidad de vértices a agregar: ");
                    int cantidadVertices = leer.nextInt();
                    leer.nextLine(); 

                    for (int i = 0; i < cantidadVertices; i++) {
                        System.out.print("Ingrese el nombre del vértice " + (i + 1) + ": ");
                        String nombreVertice = leer.nextLine();
                        grafo.nuevoVertice(nombreVertice);
                        System.out.println("Vértice agregado: " + nombreVertice);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del vértice origen: ");
                    String origen = leer.nextLine();
                    System.out.print("Ingrese el nombre del vértice destino: ");
                    String destino = leer.nextLine();
                    grafo.nuevoArco(origen, destino);
                    System.out.println("Arco agregado entre " + origen + " y " + destino);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del vértice de inicio para el DFS: ");
                    String inicioDFS = leer.nextLine();
                    System.out.print("Recorrido en Profundidad (DFS): ");
                    dfs.DFS(inicioDFS);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("ha salido del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
	        }while(opcion!=4);
	}

}
