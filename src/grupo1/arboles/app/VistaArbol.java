package arboles.app;

import arboles.modelo.Nodo;
import arboles.negocio.ArbolBinario;

public class VistaArbol {

    private static final boolean UNICODE = false;

    private static final String RAMA = UNICODE ? "├─ " : "+-- ";
    private static final String ULTIMA = UNICODE ? "└─ " : "`-- ";
    private static final String BARRA = UNICODE ? "│  " : "|   ";
    private static final String ESPACIO = UNICODE ? "   " : "    ";

    public static <T> void mostrar(ArbolBinario<T> arbol) {
        if (arbol.esVacio()) {
            System.out.println("(árbol vacío)");
            return;
        }
        System.out.println(arbol.getRaiz().getDato());
        dibujarHijos(arbol.getRaiz(), "");
    }

    private static <T> void dibujarHijos(Nodo<T> nodo, String prefijo) {
        Nodo<T> izquierdo = nodo.getIzquierdo();
        Nodo<T> derecho = nodo.getDerecho();
        if (izquierdo != null) {
            boolean ultimo = derecho == null;
            System.out.println(prefijo + (ultimo ? ULTIMA : RAMA) + "I: " + izquierdo.getDato());
            dibujarHijos(izquierdo, prefijo + (ultimo ? ESPACIO : BARRA));
        }
        if (derecho != null) {
            System.out.println(prefijo + ULTIMA + "D: " + derecho.getDato());
            dibujarHijos(derecho, prefijo + ESPACIO);
        }
    }

    public static <T> void mostrarGrafico(ArbolBinario<T> arbol) {
        if (arbol.esVacio()) {
            System.out.println("(árbol vacío)");
            return;
        }
        int ancho = anchoTotal(arbol.getRaiz());
        int alto = 2 * (arbol.altura() + 1) - 1;
        char[][] lienzo = new char[alto][ancho];
        for (char[] fila : lienzo) {
            java.util.Arrays.fill(fila, ' ');
        }
        dibujarGrafico(arbol.getRaiz(), 0, new int[] {0}, lienzo);
        for (char[] fila : lienzo) {
            System.out.println(new String(fila).stripTrailing());
        }
    }

    private static <T> int anchoTotal(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return String.valueOf(nodo.getDato()).length() + 2
                + anchoTotal(nodo.getIzquierdo()) + anchoTotal(nodo.getDerecho());
    }

    private static <T> int dibujarGrafico(Nodo<T> nodo, int nivel, int[] cursor, char[][] lienzo) {
        if (nodo == null) {
            return -1;
        }
        int izquierdo = dibujarGrafico(nodo.getIzquierdo(), nivel + 1, cursor, lienzo);
        String texto = String.valueOf(nodo.getDato());
        int inicio = cursor[0];
        cursor[0] += texto.length() + 2;
        int derecho = dibujarGrafico(nodo.getDerecho(), nivel + 1, cursor, lienzo);
        int fila = 2 * nivel;
        for (int i = 0; i < texto.length(); i++) {
            lienzo[fila][inicio + i] = texto.charAt(i);
        }
        if (izquierdo >= 0) {
            for (int c = izquierdo + 2; c < inicio; c++) {
                lienzo[fila][c] = '_';
            }
            lienzo[fila + 1][izquierdo + 1] = '/';
        }
        if (derecho >= 0) {
            for (int c = inicio + texto.length(); c <= derecho - 2; c++) {
                lienzo[fila][c] = '_';
            }
            lienzo[fila + 1][derecho - 1] = '\\';
        }
        return inicio + texto.length() / 2;
    }
}

