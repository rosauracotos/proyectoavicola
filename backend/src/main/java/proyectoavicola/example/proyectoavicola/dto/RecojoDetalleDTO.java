package proyectoavicola.example.proyectoavicola.dto;


import java.math.BigDecimal;

public class RecojoDetalleDTO {

    private String codProducto;

    private BigDecimal cantidad;

    public RecojoDetalleDTO() {
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

}
