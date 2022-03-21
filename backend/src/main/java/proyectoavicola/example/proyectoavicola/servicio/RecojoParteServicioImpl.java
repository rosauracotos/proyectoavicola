package proyectoavicola.example.proyectoavicola.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoavicola.example.proyectoavicola.dto.RecojoDetalleDTO;
import proyectoavicola.example.proyectoavicola.dto.RecojoProductos;
import proyectoavicola.example.proyectoavicola.entidad.ParteProduccion;
import proyectoavicola.example.proyectoavicola.entidad.RecojoParte;
import proyectoavicola.example.proyectoavicola.repositorio.ParteProduccionRepositorio;
import proyectoavicola.example.proyectoavicola.repositorio.RecojoParteRepositorio;
import proyectoavicola.example.proyectoavicola.util.AvicolaUtil;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RecojoParteServicioImpl  implements RecojoParteServicio{

    @Autowired
    private RecojoParteRepositorio recojoParteRepositorio;

    @Autowired
    private ParteProduccionRepositorio parteProduccionRepositorio;

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
        return null;
    }

    @Override
    public RecojoParte crearRecojoParteDesdeDTO(RecojoProductos recojoProductosDTO) {
        String ultimoCodigoParte = recojoParteRepositorio.obtenerUltimoRegistro().getParteCod();
        Integer codigoActual = AvicolaUtil.convertirStringANumero(ultimoCodigoParte);
        String codigoNuevo = AvicolaUtil.obtenerSiguienteCodigo(codigoActual);
        RecojoParte recojoParte = new RecojoParte();
        RecojoParte recojoParteNuevo = new RecojoParte();

        // Valores por Defecto
        recojoParte.setMoneda("1");
        recojoParte.setEmpresa("10");
        recojoParte.setOperacion("91");
        recojoParte.setParteAnulado(Boolean.FALSE);
        recojoParte.setObservacion("");
        // Valores Auditoria
        recojoParte.setNumParte("");
        recojoParte.setFechaInsert(recojoProductosDTO.getFecha());
        recojoParte.setPcInsert("");
        recojoParte.setUserInsert("");
        // Tomar valores DTO
        recojoParte.setAlmacenCod(recojoProductosDTO.getCodigoAlmacen());
        recojoParte.setFecha(recojoProductosDTO.getFecha());
        recojoParte.setParteCod(codigoNuevo);
        recojoParteNuevo = recojoParteRepositorio.save(recojoParte);
        guardarRecojoParteDetalleDTO(recojoProductosDTO.getDetalles(), recojoParte.getParteCod());
        return recojoParteNuevo;
    }

    @Override
    public void guardarRecojoParteDetalleDTO(List<RecojoDetalleDTO> listaRecojoDetalleDTO, String parteCod){

        int orden = 1;
        for (RecojoDetalleDTO recojoDetalleDTO : listaRecojoDetalleDTO) {

            ParteProduccion  parteProduccion = new ParteProduccion();
            //VALORES POR DEFECTO
            parteProduccion.setCantEquiv(recojoDetalleDTO.getCantidad());
            parteProduccion.setUnimedCod("01");
            parteProduccion.setParprodItem(AvicolaUtil.completarNumeroConCeros(3, orden));
            parteProduccion.setParprodCant(recojoDetalleDTO.getCantidad());
            parteProduccion.setProdCod(recojoDetalleDTO.getCodProducto());
            //VALORES POR DEFINIR
            parteProduccion.setParprodPrecio(new BigDecimal(0.00));
            parteProduccion.setParprodTotal(new BigDecimal(0.00));
            parteProduccion.setStock(new BigDecimal(0.00));
            parteProduccion.setCodigo(parteCod);
            parteProduccionRepositorio.save(parteProduccion);
            orden++;
        }
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
