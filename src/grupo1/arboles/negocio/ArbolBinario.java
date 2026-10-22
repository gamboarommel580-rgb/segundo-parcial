package arboles.negocio;

import arboles.modelo.Nodo;

public class ArbolBinario<T> {

    private Nodo<T> raiz;

    public ArbolBinario() { this.raiz = null; }

    public boolean esVacio() { return raiz == null; }

    public Nodo<T> getRaiz() { return raiz; }

    public Nodo<T> crearRaiz(T dato) {
        if (raiz != null) throw new IllegalStateException("el árbol ya tiene raíz");
        raiz = new Nodo<>(dato);
        return raiz;
    }

    public Nodo<T> agregarIzquierdo(Nodo<T> padre, T dato) {
        if (padre == null) throw new IllegalArgumentException("el padre no puede ser null");
        if (padre.getIzquierdo() != null)
            throw new IllegalStateException("el lugar izquierdo de " + padre.getDato() + " ya está ocupado");
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setIzquierdo(nuevo);
        return nuevo;
    }

    public Nodo<T> agregarDerecho(Nodo<T> padre, T dato) {
        if (padre == null) throw new IllegalArgumentException("el padre no puede ser null");
        if (padre.getDerecho() != null)
            throw new IllegalStateException("el lugar derecho de " + padre.getDato() + " ya está ocupado");
        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setDerecho(nuevo);
        return nuevo;
    }

    public int contarNodos() { return contarNodos(raiz); }
    public int contarHojas() { return contarHojas(raiz); }
    public int altura() { return altura(raiz); }

    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null) return 0;
        if (nodo.esHoja()) return 1;
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    private int altura(Nodo<T> nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }
}