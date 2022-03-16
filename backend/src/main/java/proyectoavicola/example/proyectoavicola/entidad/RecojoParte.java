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
    private String parteCod;

    @Column(name = "emp_cod")
    private String empresa;

    @Column(name = "alma_cod")
    private String almacenCod;

    @Column(name = "parte_fecha")
    private Calendar fecha;

    @Column(name = "oper_cod")
    private String operacion;

    @Column(name = "parte_anulado")
    private Boolean parteAnulado;

    @Column(name = "moneda_cod")
    private String moneda;

    @Column(name = "parte_obs")
    private String observacion;

    @Column(name = "fecha_insert")
    private Calendar fechaInsert;

    @Column(name = "pc_insert")
    private String pcInsert;

    @Column(name = "num_parte")
    private String numParte;

    @Column(name = "user_insert")
    private String userInsert;

    public String getParteCod() {
        return parteCod;
    }

    public void setParteCod(String parteCod) {
        this.parteCod = parteCod;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getAlmacenCod() {
        return almacenCod;
    }

    public void setAlmacenCod(String almacenCod) {
        this.almacenCod = almacenCod;
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

    public Boolean getParteAnulado() {
        return parteAnulado;
    }

    public void setParteAnulado(Boolean parteAnulado) {
        this.parteAnulado = parteAnulado;
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

    public Calendar getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Calendar fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    public String getPcInsert() {
        return pcInsert;
    }

    public void setPcInsert(String pcInsert) {
        this.pcInsert = pcInsert;
    }

    public String getNumParte() {
        return numParte;
    }

    public void setNumParte(String numParte) {
        this.numParte = numParte;
    }

    public String getUserInsert() {
        return userInsert;
    }

    public void setUserInsert(String userInsert) {
        this.userInsert = userInsert;
    }
}
