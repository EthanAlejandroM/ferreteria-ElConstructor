package Controller;

import Model.Producto;

public class ProductoController {
    

    public boolean registrarProducto(Producto producto) {
        return Producto.registrarProducto(producto);
    }

    public Producto buscarPorCodigo(String codigo) {
        return Producto.buscarPorCodigo(codigo);
    }

    public java.util.List<Producto> obtenerProductos() {
        return Producto.obtenerProductos();
    }

    public boolean actualizarProducto(Producto producto) {
        return Producto.actualizarProducto(producto);
    }

    public boolean eliminarProducto(int id) {
        return Producto.eliminarProducto(id);
    }
    
}
