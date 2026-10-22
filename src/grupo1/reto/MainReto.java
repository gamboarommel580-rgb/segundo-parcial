package reto;

import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;
import arboles.app.VistaArbol;

public class MainReto {

    public static void main(String[] args) {
        ArbolBinario<String> arbolA = new ArbolBinario<>();

        // ===== Parte 1: construir el árbol A =====
        titulo("Parte 1: árbol A");
        Nodo<String> ltx = arbolA.crearRaiz("LTX");
        Nodo<String> atf = arbolA.agregarIzquierdo(ltx, "ATF");
        Nodo<String> mch = arbolA.agregarDerecho(ltx, "MCH");
        arbolA.agregarIzquierdo(atf, "TUA");
        arbolA.agregarDerecho(atf, "IBB");
        Nodo<String> snc = arbolA.agregarIzquierdo(mch, "SNC");
        arbolA.agregarDerecho(mch, "OCC");
        arbolA.agregarIzquierdo(snc, "LGQ");
        VistaArbol.mostrar(arbolA);

        // ===== Parte 2: consultar el árbol A =====
        titulo("Parte 2: consultas del árbol A");
        System.out.println("Raíz              -> " + arbolA.getRaiz().getDato());
        System.out.println("Cantidad de nodos -> " + arbolA.contarNodos());
        System.out.println("Cantidad de hojas -> " + arbolA.contarHojas());
        System.out.println("Altura            -> " + arbolA.altura());
        System.out.println("Grado de LTX      -> " + ltx.grado());
        System.out.println("Grado de SNC      -> " + snc.grado());

        // ===== Parte 3: construir el árbol B =====
        ArbolBinario<String> arbolB = new ArbolBinario<>();
        titulo("Parte 3: árbol B");
        Nodo<String> gps = arbolB.crearRaiz("GPS");
        Nodo<String> scy = arbolB.agregarDerecho(gps, "SCY");
        Nodo<String> mrr = arbolB.agregarDerecho(scy, "MRR");
        Nodo<String> ptz = arbolB.agregarDerecho(mrr, "PTZ");
        arbolB.agregarDerecho(ptz, "TPN");
        VistaArbol.mostrar(arbolB);

        // ===== Parte 3: probar esCadena con A y B =====
        titulo("Parte 3: ¿es cadena?");
        System.out.println("esCadena(A) -> " + esCadena(arbolA)
                + "  (altura " + arbolA.altura() + ", nodos " + arbolA.contarNodos() + ")");
        System.out.println("esCadena(B) -> " + esCadena(arbolB)
                + "  (altura " + arbolB.altura() + ", nodos " + arbolB.contarNodos() + ")");

        titulo("Respuesta");
        System.out.println("El árbol B se parece a una lista: cada nodo tiene un solo hijo.");
        System.out.println("Al buscar un dato habría que recorrer nodo por nodo desde GPS;");
        System.out.println("en el peor caso (TPN o un dato que no existe) se revisan los 5 nodos,");
        System.out.println("igual que en una lista enlazada. En A, en cambio, el camino más largo");
        System.out.println("desde la raíz es de solo 3 niveles para 8 nodos.");

        // ===== Casos límite =====
        titulo("Casos límite");
        ArbolBinario<String> vacio = new ArbolBinario<>();
        System.out.println("Árbol vacío      -> esCadena: " + esCadena(vacio));

        ArbolBinario<String> unNodo = new ArbolBinario<>();
        unNodo.crearRaiz("UIO");
        System.out.println("Árbol de un nodo -> esCadena: " + esCadena(unNodo));

        System.out.println("Agregar un hijo izquierdo a LTX (ya tiene ATF):");
        try {
            arbolA.agregarIzquierdo(ltx, "XXX");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("El programa sigue; nodos de A: " + arbolA.contarNodos());

        // ===== Extra: camino I, D, I desde la raíz de A =====
        titulo("Extra: camino I, D, I en el árbol A");
        Nodo<String> paso1 = arbolA.getRaiz().getIzquierdo();   // I -> ATF
        Nodo<String> paso2 = paso1.getDerecho();                // D -> IBB
        Nodo<String> paso3 = paso2.getIzquierdo();              // I -> ?
        System.out.println("I -> " + paso1.getDato());
        System.out.println("D -> " + paso2.getDato());
        if (paso3 == null) {
            System.out.println("I -> null: " + paso2.getDato()
                    + " es hoja, no hay aeropuerto en ese lugar.");
        } else {
            System.out.println("I -> " + paso3.getDato());
        }
    }

    static boolean esCadena(ArbolBinario<String> arbol) {
        if (arbol.esVacio()) {
            return false;
        }
        return arbol.altura() == arbol.contarNodos() - 1;
    }

    private static void titulo(String texto) {
        System.out.println();
        System.out.println("== " + texto + " ==");
    }
}