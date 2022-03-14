package proyectoavicola.example.proyectoavicola.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "PARTE")
public class RecojoParte {


    @Id
    @Column(name = "parte_cod", nullable = false)
    private String codigo;

    @Column(name = "emp_cod")
    private String empresa;

    @Column(name = "alma_cod")
    private String almacen;

    @Column(name = "parte_fecha")
    private Calendar fecha;

    @Column(name = "oper_cod")
    private String operacion;

    @Column(name = "parte_anulado")
    private Boolean estado;

    @Column(name = "moneda_cod")
    private String moneda;

    @Column(name = "parte_obs")
    private String observacion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
