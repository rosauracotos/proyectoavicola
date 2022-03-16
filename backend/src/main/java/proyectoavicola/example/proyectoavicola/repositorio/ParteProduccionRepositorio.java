package proyectoavicola.example.proyectoavicola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyectoavicola.example.proyectoavicola.entidad.ParteProduccion;

public interface ParteProduccionRepositorio extends JpaRepository<ParteProduccion, Long> {

    @Query(value = "select TOP 1 * from PARTE_PRODUCCION order by parte_cod DESC", nativeQuery = true)
    ParteProduccion obtenerUltimoRegistro();
}
