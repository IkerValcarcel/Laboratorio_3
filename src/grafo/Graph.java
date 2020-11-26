package grafo;

import GestionWeb.CatalogoWebs;
import GestionWeb.Web;
import LinkedList.IteratorCLL;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Graph {
	
      HashMap<String, Integer> th;
      String[] keys;
      ArrayList<Integer>[] adjList;
	
	public void crearGrafo(CatalogoWebs lista){
		// Post: crea el grafo desde la lista de webs
		//       Los nodos son nombres de webs
		
            // Paso 1: llenar “th”
            // COMPLETAR CÓDIGO
		th = new HashMap<String, Integer>();
		for(int i = 0; i < lista.getNumeroDeWebs(); i++){
			th.put(lista.buscarWebPorIndice(i).getUrl(),i);
		}

            // Paso 2: llenar “keys”
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

            // Paso 3: llenar “adjList”
            // COMPLETAR CÓDIGO
		adjList = new ArrayList[lista.getNumeroDeWebs()];
		for (int i = 0; i < adjList.length; i++){
			adjList[i] = new ArrayList<Integer>();
			IteratorCLL<Web> itr = lista.buscarWebPorIndice(i).getEnlaces().iterator();
			while (itr.hasNext()){
				adjList[i].add(Integer.parseInt(itr.next().data().getIndex()));
			}
		}
	}
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean estanConectados(String a1, String a2){
		//pre: los URLs introducidos estan en la lista
		boolean enc = false;
		if (th.containsKey(a1) && th.containsKey(a2)) {
			int pos1 = th.get(a1);
			int pos2 = th.get(a2);
			boolean[] examinados = new boolean[th.size()];
			Stack<Integer> porExaminar = new Stack<Integer>();
			porExaminar.push(pos1);
			while (!enc && !porExaminar.isEmpty()) {
				int examinandose = porExaminar.pop();
				if (examinandose == pos2) {
					enc = true;
				} else {
					examinados[examinandose] = true;
					for (Integer enlace : adjList[examinandose]) {
						if (!examinados[enlace])
							porExaminar.push(enlace);
					}
				}
			}
		}
		return enc;

	}
	public ArrayList<String> comoEstanConectados(String a1, String a2){
		//pre: los URLs introducidos estan en la lista
		boolean enc = false;
		ArrayList<String> camino = new ArrayList<String>();
		if (th.containsKey(a1) && th.containsKey(a2)) {
			int pos1 = th.get(a1);
			int pos2 = th.get(a2);
			boolean[] examinados = new boolean[th.size()];
			Stack<Integer> porExaminar = new Stack<Integer>();
			Integer[] trayecto = new Integer[th.size()];
			porExaminar.push(pos1);
			while (!enc && !porExaminar.isEmpty()) {
				int examinandose = porExaminar.pop();
				if (examinandose == pos2) {
					enc = true;
				} else {
					examinados[examinandose] = true;
					for (Integer enlace : adjList[examinandose]) {
						if (!examinados[enlace]) {
							porExaminar.push(enlace);
							trayecto[enlace] = examinandose;
						}
					}
				}
			}
			if (enc) {
				Stack<Integer> invertir = new Stack<Integer>();
				int aux = pos2;
				invertir.push(pos2);
				while (aux != pos1) {
					aux = trayecto[aux];
					invertir.push(aux);
				}
				invertir.push(pos1);
				while (!invertir.isEmpty()) {
					camino.add(keys[invertir.pop()]);
				}
			}
		}
		return camino;
	}


}
