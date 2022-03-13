package proyectoavicola.example.proyectoavicola.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import proyectoavicola.example.proyectoavicola.dto.RecojoProductos;

public class RecojoControlador {

    @PostMapping(value = "/guardar")
    public ResponseEntity<?> registrarRecojo(@RequestBody RecojoProductos recojo){
        return null;
    }
}
