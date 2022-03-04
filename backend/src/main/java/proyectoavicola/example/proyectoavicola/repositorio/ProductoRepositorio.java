package proyectoavicola.example.proyectoavicola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectoavicola.example.proyectoavicola.entidad.Producto;

public interface ProductoRepositorio extends JpaRepository <Producto, Long> {
}
