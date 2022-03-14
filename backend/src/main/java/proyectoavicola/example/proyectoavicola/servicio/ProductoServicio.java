package proyectoavicola.example.proyectoavicola.servicio;

import proyectoavicola.example.proyectoavicola.entidad.Producto;

import java.util.List;

public interface ProductoServicio {

    public List<Producto> obtenerProducto();
    public Producto buscarPorId (Long id);
    public  Producto crearProducto (Producto producto);
    public Producto modificarProducto (Long id, Producto producto);
    public Producto eliminarProducto(Long id);
}
