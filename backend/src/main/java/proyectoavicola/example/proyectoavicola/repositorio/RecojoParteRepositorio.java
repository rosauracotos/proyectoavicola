package proyectoavicola.example.proyectoavicola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyectoavicola.example.proyectoavicola.entidad.RecojoParte;

public interface RecojoParteRepositorio  extends JpaRepository <RecojoParte, Long> {

    @Query(value = "select TOP 1 * from PARTE order by parte_cod DESC", nativeQuery = true)
    RecojoParte obtenerUltimoRegistro();

}
