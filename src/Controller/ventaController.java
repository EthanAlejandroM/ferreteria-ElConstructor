package Controller;

import Model.Producto;
import Model.Venta;
import Model.VentaDao;

import java.util.List;

public class VentaController {

    private VentaDao.VentaDAO ventaDAO;

    public VentaController() {
        ventaDAO = new VentaDao().new VentaDAO();
    }

    public Venta nuevaVenta() {
        return ventaDAO.nuevaVenta();
    }

    public boolean agregarProductoAVenta(
            Venta venta,
            Producto producto,
            int cantidad) {

        return ventaDAO.agregarProductoAVenta(
                venta,
                producto,
                cantidad
        );
    }

    public boolean registrarVenta(Venta venta) {
        return ventaDAO.registrarVenta(venta);
    }

    public List<Venta> listarVentas() {
        return ventaDAO.listarVentas();
    }

    public Venta buscarPorNumero(int numeroVenta) {
        return ventaDAO.buscarPorNumero(numeroVenta);
    }
}