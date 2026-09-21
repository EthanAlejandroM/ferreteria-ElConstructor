package View;

import java.util.Scanner;

public class MainView {

    private Scanner scanner;
    private ProductoView productoView;
    private VentaView ventaView;

    public MainView() {
        scanner = new Scanner(System.in);
        productoView = new ProductoView();
        ventaView = new VentaView();
    }

    public void iniciar() {
        int opcion;

        System.out.println("\n Bienvenido a la Ferreteria El Constructor! :D");

        do {
            System.out.println();
            System.out.println("\n FERRETERIA EL CONSTRUCTOR");
            System.out.println("-----------------------------");
            System.out.println("1. Gestion de productos");
            System.out.println("2. Gestion de ventas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    productoView.mostrarMenu();
                    break;

                case 2:
                    ventaView.mostrarMenu();
                    break;

                case 3:
                    System.out.println("Gracias por utilizarnos ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 3);
    }
}

