package pe.edu.cibertec.DSWII_CL2_UrteagaViktto.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.repository.ProductoRepository;
@Service
@AllArgsConstructor
public class ProductoService {
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }
    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

    public Optional<Producto> obtenerProductoPorNombre(String nombreprod){
        Optional<Producto> producto = productoRepository.findBynombreprod(nombreprod);
        if(producto.isEmpty())
            return  Optional.empty();
        else
            return producto;
    }

    public List<Producto> obtenerProductosPorFiltro(String filtro){
        return productoRepository.filtrarProductosPorNombreSQL(filtro);
    }

    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}
