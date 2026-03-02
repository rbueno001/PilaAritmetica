public class Nodo {

    // Atributos
    private Token dato;
    private Nodo siguiente;

    // Constructor
    public Nodo(Token dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Getters
    public Token getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    // Setters
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}