package proyectoavicola.example.proyectoavicola.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectoavicola.example.proyectoavicola.dto.RecojoProductos;
import proyectoavicola.example.proyectoavicola.entidad.RecojoParte;
import proyectoavicola.example.proyectoavicola.servicio.RecojoParteServicio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/recojo")
public class RecojoControlador {

    @Autowired
    RecojoParteServicio recojoParteServicio;

    @PostMapping(value = "/guardar")
    public RecojoParte registrarRecojo(@RequestBody RecojoProductos recojo)
    {
        return recojoParteServicio.crearRecojoParteDesdeDTO(recojo);
    }
}


