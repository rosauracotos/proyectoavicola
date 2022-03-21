package proyectoavicola.example.proyectoavicola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyectoavicola.example.proyectoavicola.entidad.Producto;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository <Producto, Long> {

    @Query("select p from Producto  p where p.linea = '01'")
    List<Producto> listarProductosAgregables();
}
