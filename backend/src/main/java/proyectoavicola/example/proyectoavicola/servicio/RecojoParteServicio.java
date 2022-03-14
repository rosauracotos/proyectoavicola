package proyectoavicola.example.proyectoavicola.servicio;

import proyectoavicola.example.proyectoavicola.dto.RecojoProductos;
import proyectoavicola.example.proyectoavicola.entidad.RecojoParte;

import java.util.List;

public interface RecojoParteServicio {

    public List<RecojoParte> obtenerRecojoParte();

    public RecojoParte buscarPorId (Long id);

    public RecojoParte crearRecojoParte (RecojoParte recojoParte);

    public RecojoParte crearRecojoParteDesdeDTO(RecojoProductos recojoProductosDTO);

    public RecojoParte modificarRecojoParte (Long id, RecojoParte recojoParte);

    public RecojoParte eliminarRecojoParte(Long id);

}
