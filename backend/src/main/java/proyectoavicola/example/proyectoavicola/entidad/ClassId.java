package proyectoavicola.example.proyectoavicola.entidad;

import java.io.Serializable;
import java.util.Objects;

public class ClassId  implements Serializable {

    private String codigo;
    private String parprodItem;

    public ClassId(){
    }

    public ClassId (String codigo , String parprodItem){
        this.codigo = codigo;
        this.parprodItem = parprodItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassId classId = (ClassId) o;
        return codigo.equals(classId.codigo) &&
                parprodItem.equals(classId.parprodItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, parprodItem);
    }
}
