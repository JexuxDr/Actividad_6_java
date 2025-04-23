import java.util.Scanner;

public class CalculadoraGeometrica2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Seleccione la unidad de medida:");
        System.out.println("1. Metros");
        System.out.println("2. Centímetros");
        System.out.println("3. Milímetros");
        System.out.print("Ingrese el número de la unidad (1-3): ");
        int unidadSeleccionada = obtenerOpcionValida(entrada, 1, 3);

        String unidad = "";
        switch (unidadSeleccionada) {
            case 1:
                unidad = "metros";
                break;
            case 2:
                unidad = "centímetros";
                break;
            case 3:
                unidad = "milímetros";
                break;
        }

        System.out.println("Calculadora de Área y Perímetro de Figuras Geométricas");
        System.out.println("Seleccione una figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.print("Ingrese el número de la figura (1-5): ");
        int figuraSeleccionada = obtenerOpcionValida(entrada, 1, 5);

        System.out.println("Seleccione la operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.print("Ingrese el número de la operación (1-2): ");
        int operacionSeleccionada = obtenerOpcionValida(entrada, 1, 2);

        double resultado = 0;
        switch (figuraSeleccionada) {
            case 1: 
                System.out.print("Ingrese el radio del círculo en " + unidad + ": ");
                double radioCirculo = entrada.nextDouble();
                if (operacionSeleccionada == 1) {
                    resultado = Math.PI * Math.pow(radioCirculo, 2); 
                } else if (operacionSeleccionada == 2) {
                    resultado = 2 * Math.PI * radioCirculo; 
                }
                break;
            case 2: 
                System.out.print("Ingrese la longitud del lado del cuadrado en " + unidad + ": ");
                double ladoCuadrado = entrada.nextDouble();
                if (operacionSeleccionada == 1) {
                    resultado = Math.pow(ladoCuadrado, 2); 
                } else if (operacionSeleccionada == 2) {
                    resultado = 4 * ladoCuadrado; 
                }
                break;
            case 3: 
                if (operacionSeleccionada == 1) {
                    System.out.print("Ingrese la base del triángulo en " + unidad + ": ");
                    double baseTriangulo = entrada.nextDouble();
                    System.out.print("Ingrese la altura del triángulo en " + unidad + ": ");
                    double alturaTriangulo = entrada.nextDouble();
                    resultado = 0.5 * baseTriangulo * alturaTriangulo; 
                } else if (operacionSeleccionada == 2) {
                    System.out.print("Ingrese la longitud del primer lado del triángulo en " + unidad + ": ");
                    double ladoTriangulo1 = entrada.nextDouble();
                    System.out.print("Ingrese la longitud del segundo lado del triángulo en " + unidad + ": ");
                    double ladoTriangulo2 = entrada.nextDouble();
                    System.out.print("Ingrese la longitud del tercer lado del triángulo en " + unidad + ": ");
                    double ladoTriangulo3 = entrada.nextDouble();
                    resultado = ladoTriangulo1 + ladoTriangulo2 + ladoTriangulo3; 
                }
                break;
            case 4: 
                System.out.print("Ingrese la longitud del rectángulo en " + unidad + ": ");
                double longitudRectangulo = entrada.nextDouble();
                System.out.print("Ingrese el ancho del rectángulo en " + unidad + ": ");
                double anchoRectangulo = entrada.nextDouble();
                if (operacionSeleccionada == 1) {
                    resultado = longitudRectangulo * anchoRectangulo; 
                } else if (operacionSeleccionada == 2) {
                    resultado = 2 * (longitudRectangulo + anchoRectangulo); 
                }
                break;
            case 5: 
                System.out.print("Ingrese la longitud del lado del pentágono en " + unidad + ": ");
                double ladoPentagono = entrada.nextDouble();
                if (operacionSeleccionada == 1) {
                    resultado = 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(ladoPentagono, 2); 
                } else if (operacionSeleccionada == 2) {
                    resultado = 5 * ladoPentagono; 
                }
                break;
            default:
                System.out.println("Opción de figura no válida.");
                break;
        }

        if (resultado != 0) {
            String operacion = (operacionSeleccionada == 1) ? "Área" : "Perímetro";
            System.out.println(operacion + " calculada: " + resultado + " " + unidad);
        }

        System.out.print("¿Desea realizar el cálculo de otra figura? (s/n): ");
        entrada.nextLine(); 
        String respuesta = entrada.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            main(args); 
        } else {
            System.out.println("Programa finalizado.");
        }

        entrada.close();
    }

    private static int obtenerOpcionValida(Scanner entrada, int min, int max) {
        int opcion;
        while (true) {
            opcion = entrada.nextInt();
            if (opcion >= min && opcion <= max) {
                break;
            } else {
                System.out.print("Opción no válida. Ingrese un número entre " + min + " y " + max + ": ");
            }
        }
        return opcion;
    }
}
