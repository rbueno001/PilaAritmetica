import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PilaAritmetica pila = new PilaAritmetica();
        String expresion = "";
        int opcion;

        // Menú
        do {
            System.out.println("\n==== Menú ====");
            System.out.println("1. Ingresar expresión");
            System.out.println("2. Validar expresión");
            System.out.println("3. Convertir a postfijo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción entre 1 y 4: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Ingrese la expresión:");
                    expresion = sc.nextLine();
                    break;

                case 2:
                    if (pila.validarExpresion(expresion))
                        System.out.println("La expresión es correcta.");
                    else
                        System.out.println("La expresión es incorrecta!");
                    break;

                case 3:
                    System.out.println("Postfijo: " + pila.convertirPostfijo(expresion));
                    break;

                case 4:
                    System.out.println("Usted ha salido del menú");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}