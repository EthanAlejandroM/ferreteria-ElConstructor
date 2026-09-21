package View;

import Controller.VentaController;
import Model.Producto;
import Model.Venta;

import java.util.List;
import java.util.Scanner;

public class VentaView {

    private Scanner scanner;
    private VentaController controller;

    public VentaView() {
        scanner = new Scanner(System.in);
        controller = new VentaController();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n  GESTION DE VENTAS");
            System.out.println("------------------------");
            System.out.println("1. Registrar venta");
            System.out.println("2. Listar ventas");
            System.out.println("3. Buscar venta por número");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    registrarVenta();
                    break;

                case 2:
                    listarVentas();
                    break;

                case 3:
                    buscarVenta();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 4);
    }

    private void registrarVenta() {

        System.out.println("\n--- REGISTRAR VENTA ---");

        Venta venta = controller.nuevaVenta();

        System.out.println("Número de venta: " + venta.getNumeroVenta());
        System.out.println("Fecha: " + venta.getFecha());

        String continuar;

        do {

            System.out.print("\nIngrese el código del producto: ");
            String codigo = scanner.nextLine();

            Producto producto = Producto.buscarPorCodigo(codigo);

            if (producto == null) {
                System.out.println("No se encontró el producto.");
            } else {

                System.out.println("Producto: " + producto.getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Stock disponible: " + producto.getStock());

                System.out.print("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                boolean agregado = controller.agregarProductoAVenta(
                        venta,
                        producto,
                        cantidad
                );

                if (agregado) {
                    System.out.println("Producto agregado a la venta.");
                    System.out.println("Total actual: $" + venta.getTotal());
                } else {
                    System.out.println(
                            "No se pudo agregar el producto. "
                            + "Verifique el stock."
                    );
                }
            }

            System.out.print("\n¿Desea agregar otro producto? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        if (venta.getDetalle().isEmpty()) {
            System.out.println("La venta no tiene productos.");
            return;
        }

        venta.calcularTotal();

        System.out.println("\n==============================");
        System.out.println("       RESUMEN DE VENTA");
        System.out.println("==============================");
        System.out.println("Número: " + venta.getNumeroVenta());
        System.out.println("Fecha: " + venta.getFecha());
        System.out.println("Total: $" + venta.getTotal());

        System.out.print("\n¿Desea confirmar la venta? (s/n): ");
        String confirmar = scanner.nextLine();

        if (confirmar.equalsIgnoreCase("s")) {

            boolean registrada = controller.registrarVenta(venta);

            if (registrada) {
                System.out.println("Venta registrada correctamente.");
            } else {
                System.out.println("No se pudo registrar la venta.");
            }

        } else {
            System.out.println("Venta cancelada.");
        }
    }

    private void listarVentas() {

        System.out.println("\n--- LISTA DE VENTAS ---");

        List<Venta> ventas = controller.listarVentas();

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        for (Venta venta : ventas) {

            System.out.println("------------------------------");
            System.out.println("Número de venta: "
                    + venta.getNumeroVenta());

            System.out.println("Fecha: "
                    + venta.getFecha());

            System.out.println("Total: $"
                    + venta.getTotal());

            System.out.println("------------------------------");
        }
    }

    private void buscarVenta() {

        System.out.println("\n--- BUSCAR VENTA ---");

        System.out.print("Ingrese el número de venta: ");
        int numeroVenta = scanner.nextInt();
        scanner.nextLine();

        Venta venta = controller.buscarPorNumero(numeroVenta);

        if (venta == null) {
            System.out.println("No se encontró la venta.");
            return;
        }

        System.out.println("\nVenta encontrada:");
        System.out.println("Número: " + venta.getNumeroVenta());
        System.out.println("Fecha: " + venta.getFecha());
        System.out.println("Total: $" + venta.getTotal());
    }
}
