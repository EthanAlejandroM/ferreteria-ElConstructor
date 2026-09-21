package Model;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private int id;
    private String codigo;
    private String nombre;
    private String Categoria;
    private double precio;
    private int stock;

    private static List<Producto> ProductoLista = new ArrayList<>();

    public Producto(int id, String codigo, String nombre, String categoria, double precio, int stock) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        Categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static List<Producto> getProductoLista() {
        return ProductoLista;
    }

    public static void setProductoLista(List<Producto> productoLista) {
        ProductoLista = productoLista;
    }

    // Registrar producto
    public static boolean registrarProducto(Producto p) {
        return ProductoLista.add(p);
    }

    // Consultar productos
    // Consultar / Buscar producto por CÓDIGO
    public static Producto buscarPorCodigo(String codigo) {
        for (Producto p : ProductoLista) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p; 
            }
        }
        return null; 
    }

    //ver productos

    public static List<Producto> obtenerProductos() {
        return ProductoLista;
    }
    

    // Actualizar producto
    public static boolean actualizarProducto(Producto productoEditado) {
        for (int i = 0; i < ProductoLista.size(); i++) {
            if (ProductoLista.get(i).getId() == productoEditado.getId()) {
                ProductoLista.set(i, productoEditado);
                return true;
            }
        }
        return false;
    }

    // Eliminar producto por ID
    public static boolean eliminarProducto(int id) {
        return ProductoLista.removeIf(p -> p.getId() == id);
    }
}

