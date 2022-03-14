package proyectoavicola.example.proyectoavicola.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoavicola.example.proyectoavicola.dto.RecojoProductos;
import proyectoavicola.example.proyectoavicola.entidad.RecojoParte;
import proyectoavicola.example.proyectoavicola.repositorio.RecojoParteRepositorio;

import java.util.List;

@Service
public class RecojoParteServicioImpl  implements RecojoParteServicio{

    @Autowired
    private RecojoParteRepositorio recojoParteRepositorio;


    @Override
    public List<RecojoParte> obtenerRecojoParte() {
        return recojoParteRepositorio.findAll();
    }

    @Override
    public RecojoParte buscarPorId(Long id) {
        return recojoParteRepositorio.findById(id).orElse(null);
    }

    @Override
    public RecojoParte crearRecojoParte(RecojoParte recojoParte) {
        recojoParte.setMoneda("1");
        recojoParte.setEmpresa("10");
        recojoParte.setOperacion("91");
        recojoParte.setEstado(Boolean.FALSE);
        return recojoParteRepositorio.save(recojoParte);
    }

    @Override
    public RecojoParte crearRecojoParteDesdeDTO(RecojoProductos recojoProductosDTO) {
        RecojoParte recojoParte = new RecojoParte();
        // Valores por Defecto
        recojoParte.setMoneda("1");
        recojoParte.setEmpresa("10");
        recojoParte.setOperacion("91");
        recojoParte.setEstado(Boolean.FALSE);
        recojoParte.setObservacion("");
        // Tomar valores DTO
        recojoParte.setAlmacen(recojoProductosDTO.getCodigoAlmacen());
        recojoParte.setFecha(recojoProductosDTO.getFecha());

        return recojoParteRepositorio.save(recojoParte);
    }

    @Override
    public RecojoParte modificarRecojoParte(Long id, RecojoParte recojoParte) {
        RecojoParte recojoParteActualizar = buscarPorId(id);
        recojoParteActualizar = recojoParteRepositorio.save(recojoParte);
        return recojoParteActualizar;
    }

    @Override
    public RecojoParte eliminarRecojoParte(Long id) {
        RecojoParte recojoParte = buscarPorId(id);
        recojoParteRepositorio.delete(recojoParte);
        return null;
    }
}
