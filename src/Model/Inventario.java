package Model;

public class Inventario {

    private String codigo;
    private String nombreProducto;
    private int stock;
    private double precio;

    public Inventario() {}

    public Inventario(String codigo, String nombreProducto, int stock, double precio) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}