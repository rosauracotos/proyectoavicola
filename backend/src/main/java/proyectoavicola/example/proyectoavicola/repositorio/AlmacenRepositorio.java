package proyectoavicola.example.proyectoavicola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectoavicola.example.proyectoavicola.entidad.Almacen;

public interface AlmacenRepositorio extends JpaRepository <Almacen, Long> {
}
