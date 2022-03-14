package proyectoavicola.example.proyectoavicola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectoavicola.example.proyectoavicola.entidad.RecojoParte;

public interface RecojoParteRepositorio  extends JpaRepository <RecojoParte, Long> {
}
