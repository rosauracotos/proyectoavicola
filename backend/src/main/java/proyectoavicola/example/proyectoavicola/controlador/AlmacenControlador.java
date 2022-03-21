package proyectoavicola.example.proyectoavicola.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectoavicola.example.proyectoavicola.entidad.Almacen;
import proyectoavicola.example.proyectoavicola.servicio.AlmacenServicio;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/almacen")
public class AlmacenControlador {

    @Autowired
    private AlmacenServicio almacenServicio;

    @GetMapping(value = "/listar")
    public List<Almacen> obtenerProducto (){
        return almacenServicio.listar();
    }


}


