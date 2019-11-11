/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveling;

import java.util.*;

public class Grafo {

    int[][] grafo;
    char[] nodos;
int min = 1000;
    Grafo(String serieNodos) {
        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }

    // asigna el tamaño de la arista entre dos nodos
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2] = distancia;
        grafo[n2][n1] = distancia;
    }

    // retorna la posición en el arreglo de un nodo específico
    private int posicionNodo(char nodo) {
        for (int i = 0; i < nodos.length; i++) {
            if (nodos[i] == nodo) {
                return i;
            }
        }
        return -1;
    }

    // encuentra la ruta mínima entre dos nodos del grafo
    public void encontrarRutaMinimaFuerzaBruta(char inicio, char fin) {
        int p1 = posicionNodo(inicio);
        int p2 = posicionNodo(fin);
        // cola para almacenar cada ruta que está siendo evaluada
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }

    // recorre recursivamente las rutas entre un nodo inicial y un nodo final
    // almacenando en una cola cada nodo visitado
    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        int aux = 0;

        

        // si el nodo inicial es igual al final se muestra y evalúa la ruta en revisión
        if (nodoI == nodoF) {

            if (resultado.size() == 10 ) {

                for (int x : resultado) {
                    aux++;
                    System.out.print(nodos[x] + " ");
                }
                int val= evaluar(resultado);
                if ( val< min) {
                    min = val;
                }
                System.out.print(": " + evaluar(resultado) + " ");
                System.out.println();
            }

            return;

        }
        // Si el nodoInicial no es igual al final se crea una lista con todos los nodos
        // adyacentes al nodo inicial que no estén en la ruta en evaluación
        List<Integer> lista = new Vector<Integer>();
        for (int i = 0; i < grafo.length; i++) {
            if (grafo[nodoI][i] != 0 && !resultado.contains(i)) {
                lista.add(i);
            }
        }
        // se recorren todas las rutas formadas con los nodos adyacentes al inicial
        for (int nodo : lista) {
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
        

    }

    public void rutaMasCorta() {
    }

    // evaluar la longitud de una ruta
    public int evaluar(Stack<Integer> resultado) {
        int resp = 0;
        int[] r = new int[resultado.size()];
        int i = 0;
        for (int x : resultado) {
            r[i++] = x;
        }
        for (i = 1; i < r.length; i++) {
            resp += grafo[r[i]][r[i - 1]];
        }
        return resp + 39;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo("abcdefghij");
        g.agregarRuta('a', 'b', 13);
        g.agregarRuta('a', 'c', 33);
        g.agregarRuta('a', 'd', 28);
        g.agregarRuta('a', 'e', 37);
        g.agregarRuta('a', 'f', 7);
        g.agregarRuta('a', 'g', 32);
        g.agregarRuta('a', 'h', 40);
        g.agregarRuta('a', 'i', 80);
        g.agregarRuta('a', 'j', 26);

        g.agregarRuta('b', 'a', 13);
        g.agregarRuta('b', 'c', 39);
        g.agregarRuta('b', 'd', 83);
        g.agregarRuta('b', 'e', 50);
        g.agregarRuta('b', 'f', 68);
        g.agregarRuta('b', 'g', 16);
        g.agregarRuta('b', 'h', 98);
        g.agregarRuta('b', 'i', 81);
        g.agregarRuta('b', 'j', 55);

        g.agregarRuta('c', 'a', 33);
        g.agregarRuta('c', 'b', 39);
        g.agregarRuta('c', 'd', 80);
        g.agregarRuta('c', 'e', 88);
        g.agregarRuta('c', 'f', 49);
        g.agregarRuta('c', 'g', 53);
        g.agregarRuta('c', 'h', 75);
        g.agregarRuta('c', 'i', 63);
        g.agregarRuta('c', 'j', 55);

        g.agregarRuta('d', 'a', 28);
        g.agregarRuta('d', 'b', 83);
        g.agregarRuta('d', 'c', 80);
        g.agregarRuta('d', 'e', 94);
        g.agregarRuta('d', 'f', 4);
        g.agregarRuta('d', 'g', 20);
        g.agregarRuta('d', 'h', 6);
        g.agregarRuta('d', 'i', 59);
        g.agregarRuta('d', 'j', 76);

        g.agregarRuta('e', 'a', 37);
        g.agregarRuta('e', 'b', 50);
        g.agregarRuta('e', 'c', 88);
        g.agregarRuta('e', 'd', 94);
        g.agregarRuta('e', 'f', 81);
        g.agregarRuta('e', 'g', 87);
        g.agregarRuta('e', 'h', 85);
        g.agregarRuta('e', 'i', 4);
        g.agregarRuta('e', 'j', 19);

        g.agregarRuta('f', 'a', 7);
        g.agregarRuta('f', 'b', 68);
        g.agregarRuta('f', 'c', 49);
        g.agregarRuta('f', 'd', 4);
        g.agregarRuta('f', 'e', 81);
        g.agregarRuta('f', 'g', 96);
        g.agregarRuta('f', 'h', 53);
        g.agregarRuta('f', 'i', 40);
        g.agregarRuta('f', 'j', 37);

        g.agregarRuta('g', 'a', 32);
        g.agregarRuta('g', 'b', 16);
        g.agregarRuta('g', 'c', 53);
        g.agregarRuta('g', 'd', 20);
        g.agregarRuta('g', 'e', 87);
        g.agregarRuta('g', 'f', 96);
        g.agregarRuta('g', 'h', 80);
        g.agregarRuta('g', 'i', 57);
        g.agregarRuta('g', 'j', 68);

        g.agregarRuta('h', 'a', 40);
        g.agregarRuta('h', 'b', 98);
        g.agregarRuta('h', 'c', 75);
        g.agregarRuta('h', 'd', 6);
        g.agregarRuta('h', 'e', 85);
        g.agregarRuta('h', 'f', 53);
        g.agregarRuta('h', 'g', 80);
        g.agregarRuta('h', 'i', 65);
        g.agregarRuta('h', 'j', 41);

        g.agregarRuta('i', 'a', 80);
        g.agregarRuta('i', 'b', 81);
        g.agregarRuta('i', 'c', 63);
        g.agregarRuta('i', 'd', 59);
        g.agregarRuta('i', 'e', 4);
        g.agregarRuta('i', 'f', 40);
        g.agregarRuta('i', 'g', 57);
        g.agregarRuta('i', 'h', 65);
        g.agregarRuta('i', 'j', 97);

        g.agregarRuta('j', 'a', 26);
        g.agregarRuta('j', 'b', 55);
        g.agregarRuta('j', 'c', 55);
        g.agregarRuta('j', 'd', 76);
        g.agregarRuta('j', 'e', 19);
        g.agregarRuta('j', 'f', 37);
        g.agregarRuta('j', 'g', 68);
        g.agregarRuta('j', 'h', 41);
        g.agregarRuta('j', 'i', 97);
        // g.agregarRuta('e','f', 12);
        char inicio = 'c';
        char fin = 'b';
        g.encontrarRutaMinimaFuerzaBruta(inicio, fin);
        System.out.println(g.min);
    }
}
