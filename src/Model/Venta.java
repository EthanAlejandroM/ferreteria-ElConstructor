package Model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    
    private int numeroVenta;
    private LocalDate fecha;
    private double total;
    private List<DescripcionVenta> detalle; 

    public Venta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
        this.fecha = LocalDate.now();
        this.detalle = new ArrayList<>();
        this.total = 0.0;

    }

    public int getNumeroVenta() {
        return numeroVenta;
    }


    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }


    public List<DescripcionVenta> getDetalle() {
        return detalle;
    }


    public void setDetalle(List<DescripcionVenta> detalle) {
        this.detalle = detalle;
    }

     // Recompone y calcula el total de la venta sumando los subtotales
    public void calcularTotal() {
        this.total = 0.0;
        for (DescripcionVenta detalle : detalle) {
            this.total += detalle.getSubtotal();
        }
    }

}