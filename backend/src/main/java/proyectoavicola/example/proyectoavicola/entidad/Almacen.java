package proyectoavicola.example.proyectoavicola.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALMACEN")
public class Almacen {

    @Id
    @Column(name = "alma_cod")
    private String codigo;

    @Column(name = "alma_desc")
    private String nombre;

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
}
