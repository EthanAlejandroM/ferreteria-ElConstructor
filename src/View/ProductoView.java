
package View;

import Controller.ProductoController;
import Model.Producto;

import java.util.List;
import java.util.Scanner;

public class ProductoView {

    private Scanner scanner;
    private ProductoController controller;

    public ProductoView() {
        scanner = new Scanner(System.in);
        controller = new ProductoController();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("GESTION DE PRODUCTOS");
            System.out.println("------------------------");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto por codigo");
            System.out.println("3. Listar productos");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    registrarProducto();
                    break;

                case 2:
                    buscarProducto();
                    break;

                case 3:
                    listarProductos();
                    break;

                case 4:
                    actualizarProducto();
                    break;

                case 5:
                    eliminarProducto();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 6);
    }

    private void registrarProducto() {

        System.out.println("\n REGISTRAR PRODUCTO");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto producto = new Producto(
                id,
                codigo,
                nombre,
                categoria,
                precio,
                stock
        );

        boolean registrado = controller.registrarProducto(producto);

        if (registrado) {
            System.out.println("Producto registrado!");
        } else {
            System.out.println("No se pudo registrar el producto.");
        }
    }

    private void buscarProducto() {

        System.out.println("\n BUSCAR PRODUCTO");

        System.out.print("Ingrese el codigo: ");
        String codigo = scanner.nextLine();

        Producto producto = controller.buscarPorCodigo(codigo);

        if (producto != null) {
            System.out.println("\nProducto encontrado:");
            mostrarProducto(producto);
        } else {
            System.out.println("No hay ningun producto con ese código.");
        }
    }

    private void listarProductos() {

        System.out.println("\n LISTA DE PRODUCTOS REGISTRADOS");

        List<Producto> productos = controller.obtenerProductos();

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : productos) {
            mostrarProducto(producto);
            System.out.println("-------------------------------");
        }
    }

    private void actualizarProducto() {

        System.out.println("\n ACTUALIZAR PRODUCTO");

        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Producto producto = null;

        for (Producto p : controller.obtenerProductos()) {
            if (p.getId() == id) {
                producto = p;
                break;
            }
        }

        if (producto == null) {
            System.out.println("No se encontro el producto.");
            return;
        }

        System.out.print("Nuevo codigo: ");
        String codigo = scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nueva categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Nuevo stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Producto productoEditado = new Producto(
                id,
                codigo,
                nombre,
                categoria,
                precio,
                stock
        );

        boolean actualizado = controller.actualizarProducto(productoEditado);

        if (actualizado) {
            System.out.println("Producto actualizado!");
        } else {
            System.out.println("No se pudo actualizar el producto :(");
        }
    }

    private void eliminarProducto() {

        System.out.println("\n  ELIMINAR PRODUCTO ");

        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = controller.eliminarProducto(id);

        if (eliminado) {
            System.out.println("Producto eliminado!");
        } else {
            System.out.println("No se encontro ningún producto con ese ID :(");
        }
    }

    private void mostrarProducto(Producto producto) {

        System.out.println("ID: " + producto.getId());
        System.out.println("Código: " + producto.getCodigo());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Categoría: " + producto.getCategoria());
        System.out.println("Precio: " + producto.getPrecio());
        System.out.println("Stock: " + producto.getStock());
    }
}

