package proyectoavicola.example.proyectoavicola.dto;


public class RecojoDetalleDTO {

    private String codProducto;

    private int cantidad;

    public RecojoDetalleDTO() {
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
