public class PilaAritmetica {

    // Valida si los paréntesis están bien
    public boolean validarExpresion(String expresion) {

        PilaDinamica pila = new PilaDinamica();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(') {
                pila.push(new Token("("));
            }

            else if (c == ')') {
                if (pila.estaVacia()) {
                    return false;
                }
                pila.pop();
            }
        }

        return pila.estaVacia();
    }

    // Prioridad básica de operadores
    private int prioridad(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // Convierte de infijo a postfijo
    public String convertirPostfijo(String expresion) {

        PilaDinamica pila = new PilaDinamica();
        String resultado = "";

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si es numero o letra lo agrega directo
            if (Character.isLetterOrDigit(c)) {
                resultado += c;
            }

            // Si abre paréntesis
            else if (c == '(') {
                pila.push(new Token("("));
            }

            // Si cierra paréntesis
            else if (c == ')') {
                while (!pila.estaVacia() && !pila.peek().getValor().equals("(")) {
                    resultado += pila.pop().getValor();
                }
                pila.pop(); // quita el (
            }

            // Operadores
            else {
                while (!pila.estaVacia() &&
                        prioridad(pila.peek().getValor().charAt(0)) >= prioridad(c)) {

                    resultado += pila.pop().getValor();
                }
                pila.push(new Token(String.valueOf(c)));
            }
        }

        // Vaciar pila
        while (!pila.estaVacia()) {
            resultado += pila.pop().getValor();
        }

        return resultado;
    }
}