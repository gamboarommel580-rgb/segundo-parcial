package grupo3.app;

import grupo3.enums.TipoUnidad;
import grupo3.modelo.UnidadAcademica;
import grupo3.negocio.ArbolOrganizacional;
import grupo3.negocio.NodoUnidad;

/**
 * RETO GRUPO 3 - Empresa tecnológica
 * Autor: Rommel Gamboa (Grupo 5)
 *
 * 1) Reconstruye el árbol general de la imagen SOLO con arbolGeneral.agregar("Padre", hijo).
 * 2) Lo transforma a binario con la técnica hijo izquierdo - hermano derecho.
 *
 * Árbol general:            A
 *                      /    |    \
 *                     B     C     D
 *                    / \    |    / \
 *                   E   F   G   H   I
 *                   |       |
 *                   J       K
 *
 * Nota: TipoUnidad solo permite el tipo siguiente como hijo, por eso:
 * A = UNIVERSIDAD, B-D = FACULTAD, E-I = CARRERA, J-K = NIVEL.
 */
public class Main {

    public static void main(String[] args) {

        // Raíz del árbol general
        ArbolOrganizacional arbolGeneral = new ArbolOrganizacional(
                new UnidadAcademica("A", "Empresa tecnológica", TipoUnidad.UNIVERSIDAD));

        // Nivel 1: departamentos (el orden define quién será el hijo izquierdo)
        arbolGeneral.agregar("A", new UnidadAcademica("B", "Departamento B", TipoUnidad.FACULTAD));
        arbolGeneral.agregar("A", new UnidadAcademica("C", "Departamento C", TipoUnidad.FACULTAD));
        arbolGeneral.agregar("A", new UnidadAcademica("D", "Departamento D", TipoUnidad.FACULTAD));

        // Nivel 2: equipos
        arbolGeneral.agregar("B", new UnidadAcademica("E", "Equipo E", TipoUnidad.CARRERA));
        arbolGeneral.agregar("B", new UnidadAcademica("F", "Equipo F", TipoUnidad.CARRERA));
        arbolGeneral.agregar("C", new UnidadAcademica("G", "Equipo G", TipoUnidad.CARRERA));
        arbolGeneral.agregar("D", new UnidadAcademica("H", "Equipo H", TipoUnidad.CARRERA));
        arbolGeneral.agregar("D", new UnidadAcademica("I", "Equipo I", TipoUnidad.CARRERA));

        // Nivel 3: trabajadores
        arbolGeneral.agregar("E", new UnidadAcademica("J", "Trabajador J", TipoUnidad.NIVEL));
        arbolGeneral.agregar("G", new UnidadAcademica("K", "Trabajador K", TipoUnidad.NIVEL));

        System.out.println("=== RETO GRUPO 3: EMPRESA TECNOLÓGICA - Rommel Gamboa ===");

        System.out.println("\n--- 1. Árbol general (jerarquía) ---");
        System.out.println(arbolGeneral.mostrarJerarquia());
        System.out.println("\nAltura: " + arbolGeneral.altura()
                + " | Hojas: " + arbolGeneral.contarHojas()
                + " | Grado de A: " + arbolGeneral.grado("A"));

        System.out.println("\n--- 2. Transformación con el método del grupo (A6) ---");
        System.out.println(arbolGeneral.transformarABinario());

        System.out.println("\n--- 3. Árbol binario obtenido (izq = primer hijo, der = siguiente hermano) ---");
        StringBuilder sb = new StringBuilder();
        mostrarBinario(arbolGeneral.getRaiz(), null, 0, "RAIZ", sb);
        System.out.print(sb);

        StringBuilder pre = new StringBuilder();
        preordenBinario(arbolGeneral.getRaiz(), null, pre);
        System.out.println("\nPreorden del binario: " + pre.toString().trim());
    }

    /**
     * Muestra el árbol binario hijo izquierdo - hermano derecho.
     * hijo izquierdo  = primer hijo del nodo en el árbol general.
     * hermano derecho = siguiente hijo del mismo padre.
     */
    private static void mostrarBinario(NodoUnidad nodo, NodoUnidad padre, int nivel,
                                       String etiqueta, StringBuilder sb) {
        if (nodo == null) {
            return;                                                  // caso base
        }
        sb.append("  ".repeat(nivel)).append(etiqueta).append(": ")
          .append(nodo.getDato().getCodigo()).append(System.lineSeparator());

        mostrarBinario(primerHijo(nodo), nodo, nivel + 1, "Izq", sb);       // enlace izquierdo
        mostrarBinario(siguienteHermano(nodo, padre), padre, nivel + 1, "Der", sb); // enlace derecho
    }

    /** Preorden del árbol binario: nodo, izquierdo, derecho. */
    private static void preordenBinario(NodoUnidad nodo, NodoUnidad padre, StringBuilder sb) {
        if (nodo == null) {
            return;                                                  // caso base
        }
        sb.append(nodo.getDato().getCodigo()).append(' ');
        preordenBinario(primerHijo(nodo), nodo, sb);
        preordenBinario(siguienteHermano(nodo, padre), padre, sb);
    }

    private static NodoUnidad primerHijo(NodoUnidad nodo) {
        return nodo.esHoja() ? null : nodo.getHijos().get(0);
    }

    private static NodoUnidad siguienteHermano(NodoUnidad nodo, NodoUnidad padre) {
        if (padre == null) {
            return null;                                             // la raíz no tiene hermanos
        }
        int i = padre.getHijos().indexOf(nodo);
        return (i + 1 < padre.getHijos().size()) ? padre.getHijos().get(i + 1) : null;
    }
}
