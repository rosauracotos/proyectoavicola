package proyectoavicola.example.proyectoavicola.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import proyectoavicola.example.proyectoavicola.dto.LoginDTO;
import proyectoavicola.example.proyectoavicola.dto.LoginResponse;
import proyectoavicola.example.proyectoavicola.entidad.Usuario;
import proyectoavicola.example.proyectoavicola.repositorio.UsuarioRepositorio;
import proyectoavicola.example.proyectoavicola.servicio.UserDetailCustomService;
import proyectoavicola.example.proyectoavicola.util.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AuthControlador {

    @Autowired
    private UserDetailCustomService userDetailsService;

    @Autowired
    private  JwtTokenUtil jwtTokenUtil;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @RequestMapping(value = "/logeo", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(HttpServletRequest request, @RequestBody LoginDTO credenciales) {

        UserDetails userDetails;
        Usuario usuario;
        LoginResponse loginResponse;
        String token;

        try {
            autenticar(credenciales.getUsuario().toUpperCase().trim(), credenciales.getPassword());
            userDetails = userDetailsService
                    .loadUserByUsername(credenciales.getUsuario());


            // Si llega hasta acá es porque las credenciales son correctas
            usuario = usuarioRepositorio.findById(credenciales.getUsuario()).orElse(null);


            token = jwtTokenUtil.generateToken(userDetails);
            loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setUsuario(usuario.getUsuario());
            loginResponse.setNombre(usuario.getNombre());
            return ResponseEntity.ok(loginResponse);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("El usuario y/o la contraseña no son correctos", HttpStatus.UNAUTHORIZED);
        } catch (Exception e){
            return new ResponseEntity<>("Error al conectarse al servidor", HttpStatus.UNAUTHORIZED);
        }

    }
    private void autenticar(String username, String password)  {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
