package pe.edu.cibertec.DSWII_CL2_UrteagaViktto.service;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImp extends ProductoService {
    private ProductoRepository productoRepository;

    public ProductoServiceImp(ProductoRepository productoRepository) {
        super(productoRepository);
    }

    @Override
    public Optional<Producto> obtenerProductoPorNombre(String nombreprod) {
        return productoRepository.findBynombreprod(nombreprod);
    }

    @Override
    public List<Producto> obtenerProductosCantidadEntre10y100() {
        return productoRepository.findProductosCantidadEntre10y100();
    }

    @Override
    public List<Producto> obtenerProductosConVencimientoEn2024() {
        return productoRepository.findProductosConVencimientoEn2024();
    }
}

