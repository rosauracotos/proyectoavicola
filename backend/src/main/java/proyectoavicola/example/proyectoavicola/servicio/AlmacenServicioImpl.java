package proyectoavicola.example.proyectoavicola.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoavicola.example.proyectoavicola.entidad.Almacen;
import proyectoavicola.example.proyectoavicola.repositorio.AlmacenRepositorio;

import java.util.List;

@Service
public class AlmacenServicioImpl implements AlmacenServicio{

    @Autowired
    private AlmacenRepositorio almacenRepositorio;

    @Override
    public List<Almacen> listar() {
        return almacenRepositorio.findAll();
    }


}
