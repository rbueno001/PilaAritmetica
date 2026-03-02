public class PilaDinamica {

    // Atributos
    private Nodo cima;

    // Constructor
    public PilaDinamica() {
        this.cima = null;
    }

    // Métodos

    public boolean estaVacia() {
        return cima == null;
    }

    public void push(Token dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public Token pop() {
        if (estaVacia()) {
            System.out.println("Lo sentimos, la pila está vacía.");
            return null;
        }
        Token temp = cima.getDato();
        cima = cima.getSiguiente();
        return temp;
    }

    public Token peek() {
        if (estaVacia()) {
            System.out.println("Lo sentimos, la pila está vacía.");
            return null;
        }
        return cima.getDato();
    }
}