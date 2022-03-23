package proyectoavicola.example.proyectoavicola.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import proyectoavicola.example.proyectoavicola.entidad.Usuario;
import proyectoavicola.example.proyectoavicola.repositorio.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailCustomService  implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails userDet;
        List<GrantedAuthority> roles;

        roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("user"));
        Usuario usuario = usuarioRepositorio.findById(username)
                .orElse(new Usuario());

        return new User(usuario.getUsuario(), usuario.getClave(), roles);
    }
}
