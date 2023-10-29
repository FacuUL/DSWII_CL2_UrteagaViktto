package pe.edu.cibertec.DSWII_CL2_UrteagaViktto.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {
    private ProductoService productoService;
    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productosList = new ArrayList<>();
        productoService.listarProductos()
                .forEach(productosList::add);
        if(productosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(
            @PathVariable("id") Integer id){
        Producto producto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/nombreprod/{nombreprod}")
    public ResponseEntity<Producto> obtenerProductoPorNombre(
            @PathVariable("nombreprod") String nombreprod){
        Producto producto = productoService
                .obtenerProductoPorNombre(nombreprod)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el nombre "+
                        nombreprod + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/nombreprod/{filtro}")
    public ResponseEntity<List<Producto>> filtrarProductosPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductosPorFiltro(filtro)
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.guardar(producto), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto
    ){
        Producto oldProducto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));
        oldProducto.setNombreprod(producto.getNombreprod());
        oldProducto.setDescripcionprod(producto.getDescripcionprod());
        oldProducto.setCantidadprod(producto.getCantidadprod());
        return new ResponseEntity<>(
                productoService.guardar(oldProducto), HttpStatus.OK
        );
    }
}
