package proyectoavicola.example.proyectoavicola.servicio;

import proyectoavicola.example.proyectoavicola.dto.RecojoDetalleDTO;
import proyectoavicola.example.proyectoavicola.entidad.ParteProduccion;
import proyectoavicola.example.proyectoavicola.entidad.RecojoParte;

import java.util.List;

public interface ParteProduccionServicio {

    public List<ParteProduccion> obtenerParteProduccion();

    public ParteProduccion buscarPorId (Long id);

    public ParteProduccion crearParteProduccion (ParteProduccion parteProduccion);

    public ParteProduccion modificarParteProduccion (Long id, ParteProduccion parteProduccion);

    public ParteProduccion eliminarParteProduccion(Long id);
}
