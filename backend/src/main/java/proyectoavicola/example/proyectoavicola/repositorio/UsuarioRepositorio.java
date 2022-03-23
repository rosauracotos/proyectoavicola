package proyectoavicola.example.proyectoavicola.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectoavicola.example.proyectoavicola.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository <Usuario, String> {
}
