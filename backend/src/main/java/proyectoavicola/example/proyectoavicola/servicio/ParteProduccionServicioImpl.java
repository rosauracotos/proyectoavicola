package proyectoavicola.example.proyectoavicola.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoavicola.example.proyectoavicola.entidad.ParteProduccion;
import proyectoavicola.example.proyectoavicola.repositorio.ParteProduccionRepositorio;

import java.util.List;

@Service
public class ParteProduccionServicioImpl implements ParteProduccionServicio {

    @Autowired
    private ParteProduccionRepositorio parteProduccionRepositorio;

    @Override
    public List<ParteProduccion> obtenerParteProduccion() {
        return parteProduccionRepositorio.findAll();
    }

    @Override
    public ParteProduccion buscarPorId(Long id) {
        return parteProduccionRepositorio.findById(id).orElse(null);
    }

    @Override
    public ParteProduccion crearParteProduccion(ParteProduccion parteProduccion) {
        return null ;
    }

    @Override
    public ParteProduccion modificarParteProduccion(Long id, ParteProduccion parteProduccion) {
        ParteProduccion parteProduccionActualizar = buscarPorId(id);
        parteProduccionActualizar = parteProduccionRepositorio.save(parteProduccion);
        return parteProduccionActualizar;
    }

    @Override
    public ParteProduccion eliminarParteProduccion(Long id) {
        ParteProduccion parteProduccionEliminar = buscarPorId(id);
        parteProduccionRepositorio.delete(parteProduccionEliminar);
        return null;
    }
}
