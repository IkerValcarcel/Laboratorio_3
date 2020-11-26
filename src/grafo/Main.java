package grafo;

import GestionWeb.CargadorDeFicheros;
import GestionWeb.CatalogoWebs;
import GestionWeb.Web;
import LinkedList.UnorderedListADT;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //Con lista entera de webs
        //CargadorDeFicheros.getCargadorDeFicheros().cargar("words.txt","index.txt","pld-arcs-1-N.txt");

        //Con lista pequeña de pruebas
        CatalogoWebs listaWebs = CatalogoWebs.getCatalogoWebs();
        listaWebs.anadirWeb(new Web("0","hello.com"));
        listaWebs.anadirWeb(new Web("1","world.com"));
        listaWebs.anadirWeb(new Web("2","hello.net"));
        listaWebs.anadirWeb(new Web("3","world.net"));
        listaWebs.anadirWeb(new Web("4","hello.org"));
        listaWebs.anadirWeb(new Web("5","world.org"));
        listaWebs.anadirWeb(new Web("6","hello.eus"));
        listaWebs.anadirWeb(new Web("7","world.eus"));

        UnorderedListADT<Web> arcos = new UnorderedListADT<Web>();
        arcos.addToRear(listaWebs.buscarWebPorIndice(1));
        arcos.addToRear(listaWebs.buscarWebPorIndice(3));
        arcos.addToRear(listaWebs.buscarWebPorIndice(5));
        arcos.addToRear(listaWebs.buscarWebPorIndice(7));
        listaWebs.buscarWebPorIndice(0).setEnlaces(arcos);

        arcos = new UnorderedListADT<Web>();
        arcos.addToRear(listaWebs.buscarWebPorIndice(2));
        listaWebs.buscarWebPorIndice(1).setEnlaces(arcos);

        arcos = new UnorderedListADT<Web>();
        listaWebs.buscarWebPorIndice(2).setEnlaces(arcos);

        arcos = new UnorderedListADT<Web>();
        arcos.addToRear(listaWebs.buscarWebPorIndice(2));
        arcos.addToRear(listaWebs.buscarWebPorIndice(4));
        arcos.addToRear(listaWebs.buscarWebPorIndice(6));
        arcos.addToRear(listaWebs.buscarWebPorIndice(7));
        listaWebs.buscarWebPorIndice(3).setEnlaces(arcos);

        arcos = new UnorderedListADT<Web>();
        arcos.addToRear(listaWebs.buscarWebPorIndice(0));
        arcos.addToRear(listaWebs.buscarWebPorIndice(1));
        arcos.addToRear(listaWebs.buscarWebPorIndice(2));
        arcos.addToRear(listaWebs.buscarWebPorIndice(3));
        arcos.addToRear(listaWebs.buscarWebPorIndice(5));
        listaWebs.buscarWebPorIndice(4).setEnlaces(arcos);

        arcos = new UnorderedListADT<Web>();
        arcos.addToRear(listaWebs.buscarWebPorIndice(0));
        arcos.addToRear(listaWebs.buscarWebPorIndice(1));
        arcos.addToRear(listaWebs.buscarWebPorIndice(2));
        arcos.addToRear(listaWebs.buscarWebPorIndice(3));
        arcos.addToRear(listaWebs.buscarWebPorIndice(6));
        arcos.addToRear(listaWebs.buscarWebPorIndice(7));
        listaWebs.buscarWebPorIndice(5).setEnlaces(arcos);

        arcos = new UnorderedListADT<Web>();
        arcos.addToRear(listaWebs.buscarWebPorIndice(2));
        arcos.addToRear(listaWebs.buscarWebPorIndice(3));
        arcos.addToRear(listaWebs.buscarWebPorIndice(7));
        listaWebs.buscarWebPorIndice(6).setEnlaces(arcos);

        arcos = new UnorderedListADT<Web>();
        listaWebs.buscarWebPorIndice(7).setEnlaces(arcos);

        Graph grafo = new Graph();
        grafo.crearGrafo(listaWebs);
        System.out.println("El resultado deberia de ser True y es:");
        if (grafo.estanConectados("hello.com","hello.eus")) System.out.println("true");
        else System.out.println("false");

        System.out.println("El resultado deberia de ser False y es:");
        if (grafo.estanConectados("world.eus","hello.com")) System.out.println("true");
        else System.out.println("false");

        System.out.println("El resultado deberia de ser True y es:");
        if (grafo.estanConectados("world.net","hello.eus")) System.out.println("true");
        else System.out.println("false");

        System.out.println("El resultado deberia de ser False y es:");
        if (grafo.estanConectados("hello.org","hello.org")) System.out.println("true");
        else System.out.println("false");

        System.out.println("El resultado deberia de ser False y es:");
        if (grafo.estanConectados("hello.net","hello.com")) System.out.println("true");
        else System.out.println("false");

        ArrayList<String> camino = grafo.comoEstanConectados("hello.com","hello.eus");
        System.out.println("El camino es:");
        for (int i = 0; i < camino.size(); i++) {
            System.out.print(camino.get(i) + " ");
        }
        System.out.println();
        System.out.println("El camino es:");
        camino = grafo.comoEstanConectados("hello.com","world.org");
        for (int i = 0; i < camino.size(); i++) {
            System.out.print(camino.get(i) + " ");
        }
        System.out.println();
        System.out.println("El camino es:");
        camino = grafo.comoEstanConectados("hello.net","hello.com");
        if (!camino.isEmpty()) {
            for (int i = 0; i < camino.size(); i++) {
                System.out.print(camino.get(i) + " ");
            }
        }else System.out.println("No hay camino");

    }
}
