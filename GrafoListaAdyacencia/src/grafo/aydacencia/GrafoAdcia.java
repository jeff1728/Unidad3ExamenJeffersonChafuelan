package grafo.aydacencia;

import java.util.List;
import java.util.ArrayList;

public class GrafoAdcia {
	
	int numVerts;
	static int maxVerts = 20;
	VerticeAdy [] tablAdc;
	List <String> lista;
	
	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
	}
	
	
	// Agregar la m�todo que permite agregar un nuevo v�rtice
	/*
	 * A�ade un nuevo v�rtice a la lista directorio. Si el v�rtice ya est� en la tabla no hace nada, 
	 * devuelve control; si es nuevo, se asigna a continuaci�n del �ltimo. 
	 */
	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >= 0;
		if (!esta) {
			VerticeAdy v = new VerticeAdy(nom);
			v.asigVert(numVerts);
			tablAdc[numVerts++] = v;
		}
	}
	

	int numVertice(String vs) {
		VerticeAdy v = new VerticeAdy(vs);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;) {
			encontrado = tablAdc[i].equals(v);
			if (!encontrado)
				i++;
		}
		return (i < numVerts) ? i : -1;
	}
	
	
	//Agregar m�todo que permite agregar un nuevo arco
	/*
	 * Esta operaci�n da entrada a un arco del grafo. El m�todo tiene como entrada el v�rtice origen y el 
	 * v�rtice destino. El m�todo adyacente() determina si la arista ya est� en la lista de adyacencia, 
	 * y, por �ltimo, el Arco se inserta en la lista de adyacencia del nodo origen. 
	 * La inserci�n se hace como primer nodo para que el tiempo sea constante, O(1). 
	 * Otra versi�n del m�todo recibe, directamente, los n�meros de v�rtices que forman los extremos del arco. 
	 * ara a�adir una arista en un grafo valorado, se debe asignar el factor de peso al crear el Arco.
	 */
	
	public void nuevoArco(String a, String b) throws Exception {
	    int va, vb;
	    va = numVertice(a);
	    vb = numVertice(b);
	    if (va < 0 || vb < 0)
	        throw new Exception("Vértice no existe");

	    tablAdc[va].lad.add(new Arco(vb)); // Agregar arco a la lista de adyacencia del vértice va
	}
	
	
	//Agregar un m�todo que determina si dos v�rtices son adyacentes
	/*
	 * La operaci�n determina si dos v�rtices, v1 y v2, forman un arco. En definitiva, 
	 * si el v�rtice v2 est� en la lista de adyacencia de v1. 
	 * El m�todo buscarLista() devuelve la direcci�n del nodo que contiene al arco, si no est� devuelve null. 
	 */
	public List<Integer> adyacente(String a, String b) throws Exception {
	    int va, vb;
	    va = numVertice(a);
	    vb = numVertice(b);
	    if (va < 0 || vb < 0)
	        throw new Exception("Vértice no existe");

	    List<Integer> verticesAdyacentes = new ArrayList<>();
	    for (Object arcoObj : tablAdc[va].lad) {
	        Arco arco = (Arco) arcoObj;
	        if (arco.destino == vb) {
	            verticesAdyacentes.add(arco.destino);
	            break; // Puedes detener el bucle si encontraste el arco
	        }
	    }
	    return verticesAdyacentes;
	}

}
