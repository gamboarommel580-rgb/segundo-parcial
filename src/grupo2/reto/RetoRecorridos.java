package grupo2.reto;

import grupo2.modelo.Estudiante;
import grupo2.negocio.NodoEstudiante;

/**
 * Responsable: Monica - Rama: Sara-Tacuri
 * Para que: plantilla del reto que el curso completa en parejas (se sube a
 * Moodle).
 *
 * RETO: Recorridos recursivos con traza (paralelo SW-N3-A, Software, FISEI)
 *
 * Enunciado:
 * El paralelo SW-N3-A esta vacio. Se matriculan, en este orden, los
 * estudiantes con matricula 45, 25, 70, 10, 30, 60, 90, 27, 65.
 *
 * 1. Dibuja en papel el arbol binario de busqueda que resulta.
 * 2. Predice en papel el preorden, el inorden y el posorden.
 * 3. Completa los tres metodos de abajo (// TODO) de forma RECURSIVA.
 * Cada uno imprime una traza con la sangria que recibe:
 * "entra <matricula>" al llegar a un nodo
 * "null -> regresa" en el caso base
 * "VISITA <matricula>" cuando el nodo se procesa; ademas agrega la
 * matricula a salida con: salida.append(m).append(' ')
 * Lo unico que cambia entre los tres recorridos es DONDE va la visita.
 * La sangria crece 2 espacios por nivel: es la pila de llamadas.
 * "entra", "VISITA" y "null -> regresa" usan la sangria que recibe el metodo.
 * 4. Compara lo que imprime tu codigo con tu prediccion del paso 2.
 * 5. Prueba tambien (el main ya los ejecuta): arbol vacio, un solo nodo,
 * la cadena 10, 20, 30, 40 y un repetido (20, 30, 30, 10: el segundo 30 se
 * ignora).
 * 6. EXTRA (si te sobra tiempo): altura(nodo), medida en aristas
 * (una hoja vale 0 y un arbol vacio vale -1).
 *
 * Tiempo sugerido: 5 min dibujar y predecir, 10 min codificar, 5 min comparar.
 *
 * Reglas: solo recursion (sin ordenar listas ni usar bucles para recorrer),
 * caso base nodo == null y una llamada recursiva por cada hijo.
 */
public class RetoRecorridos {

    // Inserta una matricula en el ABB (ignora repetidos). Ya viene hecho.
    static NodoEstudiante insertar(NodoEstudiante nodo, int matricula) {
        if (nodo == null) { // caso base: lugar libre
            return new NodoEstudiante(new Estudiante(matricula,
                    String.format("18%08d", matricula),
                    "Estudiante " + matricula, 8));
        }
        int actual = nodo.getDato().getMatricula();
        if (matricula < actual) { // caso recursivo: izquierda
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), matricula));
        } else if (matricula > actual) { // caso recursivo: derecha
            nodo.setDerecho(insertar(nodo.getDerecho(), matricula));
        }
        return nodo;
    }

    // TODO 1: PREORDEN = visita el nodo, luego izquierda, luego derecha
    static void preorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {                                  // caso base
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + m);
        System.out.println(sangria + "VISITA " + m);         // visita ANTES de los hijos
        salida.append(m).append(' ');
        preorden(nodo.getIzquierdo(), sangria + "  ", salida);
        preorden(nodo.getDerecho(), sangria + "  ", salida);
    }

    // TODO 2: INORDEN = izquierda, luego visita el nodo, luego derecha
    static void inorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + m);
        inorden(nodo.getIzquierdo(), sangria + "  ", salida);
        System.out.println(sangria + "VISITA " + m);         // visita ENTRE los hijos
        salida.append(m).append(' ');
        inorden(nodo.getDerecho(), sangria + "  ", salida);
    }

    // TODO 3: POSORDEN = izquierda, luego derecha, luego visita el nodo
    static void posorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            System.out.println(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        System.out.println(sangria + "entra " + m);
        posorden(nodo.getIzquierdo(), sangria + "  ", salida);
        posorden(nodo.getDerecho(), sangria + "  ", salida);
        System.out.println(sangria + "VISITA " + m);         // visita DESPUES de los hijos
        salida.append(m).append(' ');
    }

    // TODO 4 (EXTRA): altura en aristas (1 + la mayor altura de sus dos lados)
    static int altura(NodoEstudiante nodo) {
        if (nodo == null) return -1;                          // arbol vacio: -1, hoja: 0
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }

    static NodoEstudiante construir(int[] matriculas) {
        NodoEstudiante raiz = null;
        for (int m : matriculas) {
            raiz = insertar(raiz, m);
        }
        return raiz;
    }

    static void ejecutar(String titulo, int[] matriculas) {
        System.out.println("=== " + titulo + " ===");
        NodoEstudiante raiz = construir(matriculas);
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder pos = new StringBuilder();
        System.out.println("-- traza PREORDEN");
        preorden(raiz, "", pre);
        System.out.println("-- traza INORDEN");
        inorden(raiz, "", in);
        System.out.println("-- traza POSORDEN");
        posorden(raiz, "", pos);
        System.out.println("Preorden: " + pre.toString().trim());
        System.out.println("Inorden:  " + in.toString().trim());
        System.out.println("Posorden: " + pos.toString().trim());
        System.out.println("Altura (extra): " + altura(raiz));
        System.out.println();
    }

    public static void main(String[] args) {
        ejecutar("Reto SW-N3-A", new int[] { 45, 25, 70, 10, 30, 60, 90, 27, 65 });
        ejecutar("Caso limite: arbol vacio", new int[] {});
        ejecutar("Caso limite: un solo nodo", new int[] { 50 });
        ejecutar("Caso limite: cadena", new int[] { 10, 20, 30, 40 });
        ejecutar("Caso limite: repetido (30 dos veces)", new int[] { 20, 30, 30, 10 });
    }
}