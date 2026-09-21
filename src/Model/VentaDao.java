package Model;

import java.util.ArrayList;
import java.util.List;


public class VentaDao {

    public class VentaDAO {

        private static final List<Venta> listaVentas = new ArrayList<>();
        private static int contadorVentas = 1;

        // Iniciar una nueva venta con su número único asignado
        public Venta nuevaVenta() {
            return new Venta(contadorVentas++);
        }

        // Agregar un producto al carrito/venta validando stock
        public boolean agregarProductoAVenta(Venta venta, Producto producto, int cantidad) {
            if (producto == null) {
                return false;
            }

            // 1. Verificar si hay stock suficiente
            if (producto.getStock() < cantidad) {
                return false; // No hay stock suficiente
            }

            // 2. Agregar al detalle de la venta
            DescripcionVenta detalle = new DescripcionVenta(producto, cantidad);
            venta.getDetalle().add(detalle);

            // 3. Recalcular el total
            venta.calcularTotal();
            return true;
        }

        // Confirmar y registrar la venta (Descuenta el inventario automáticamente)
        public boolean registrarVenta(Venta venta) {
            if (venta.getDetalle().isEmpty()) {
                return false; // No se puede registrar una venta vacía
            }

            // Descontar inventario de cada producto incluido
            for (DescripcionVenta detalle : venta.getDetalle()) {
                Producto p = detalle.getProducto();
                int nuevoStock = p.getStock() - detalle.getCantidad();
                p.setStock(nuevoStock);
            }

            // Guardar la venta en la lista global
            return listaVentas.add(venta);
        }

        // Consultar todas las ventas registradas
        public List<Venta> listarVentas() {
            return listaVentas;
        }

        // Consultar una venta específica por su número
        public Venta buscarPorNumero(int numeroVenta) {
            for (Venta v : listaVentas) {
                if (v.getNumeroVenta() == numeroVenta) {
                    return v;
                }
            }
            return null;
        }
    }
}
