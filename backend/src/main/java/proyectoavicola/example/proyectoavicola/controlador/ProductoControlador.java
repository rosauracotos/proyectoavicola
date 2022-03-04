package proyectoavicola.example.proyectoavicola.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectoavicola.example.proyectoavicola.entidad.Producto;
import proyectoavicola.example.proyectoavicola.servicio.ProductoServicio;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/producto")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping(value = "/listar")
    public List<Producto> obtenerProducto (){
        return productoServicio.obtenerProducto();
    }

    @GetMapping(value = "/{id}")
    public Producto obtenerProducto (@PathVariable("id") Long id){
        return productoServicio.buscarPorId(id);
    }


    public Producto eliminarProducto (HttpServletRequest request, @PathVariable("id") Long id){
        return productoServicio.eliminarProducto(id);
    }

}


