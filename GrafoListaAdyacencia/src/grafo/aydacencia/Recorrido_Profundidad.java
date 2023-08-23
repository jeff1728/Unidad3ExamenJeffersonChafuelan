package grafo.aydacencia;
import java.util.Arrays;
import java.util.Stack;

public class Recorrido_Profundidad {
	 private GrafoAdcia grafo;
	    private boolean[] visitados;

	    public Recorrido_Profundidad(GrafoAdcia grafo) {
	        this.grafo = grafo;
	        visitados = new boolean[grafo.maxVerts];
	    }

	    public void DFS(String inicio) {
	        int inicioIdx = grafo.numVertice(inicio);
	        if (inicioIdx < 0) {
	            System.out.println("El vértice de inicio no existe en el grafo.");
	            return;
	        }

	        Arrays.fill(visitados, false);
	        DFSUtil(inicioIdx);
	    }

	    private void DFSUtil(int verticeIdx) {
	        visitados[verticeIdx] = true;
	        System.out.print(grafo.tablAdc[verticeIdx].nomVertice() + " ");

	        for (Object arcoObj : grafo.tablAdc[verticeIdx].lad) {
	            Arco arco = (Arco) arcoObj;
	            if (!visitados[arco.destino]) {
	                DFSUtil(arco.destino);
	            }
	        }
}
}
