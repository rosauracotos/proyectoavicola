package proyectoavicola.example.proyectoavicola.dto;

import java.util.Calendar;
import java.util.List;

public class RecojoProductos {

    private Calendar fecha;

    private String codigoAlmacen;

    private List<RecojoDetalleDTO> detalles;

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(String codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

    public List<RecojoDetalleDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<RecojoDetalleDTO> detalles) {
        this.detalles = detalles;
    }
}
