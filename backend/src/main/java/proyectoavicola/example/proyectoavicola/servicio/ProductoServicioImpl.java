package proyectoavicola.example.proyectoavicola.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectoavicola.example.proyectoavicola.entidad.Producto;
import proyectoavicola.example.proyectoavicola.repositorio.ProductoRepositorio;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> obtenerProducto() {
        return productoRepositorio.listarProductosAgregables();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto modificarProducto(Long id, Producto producto) {
        Producto productoActualizar = buscarPorId(id);
        productoActualizar = productoRepositorio.save(producto);
        return productoActualizar;
    }

    @Override
    public Producto eliminarProducto(Long id) {
        Producto producto = buscarPorId(id);
        productoRepositorio.delete(producto);
        return null;
    }
}
