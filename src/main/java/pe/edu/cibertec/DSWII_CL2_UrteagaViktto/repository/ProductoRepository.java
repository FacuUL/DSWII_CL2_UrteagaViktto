package pe.edu.cibertec.DSWII_CL2_UrteagaViktto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL2_UrteagaViktto.model.bd.Producto;
import java.util.List;
import java.util.Optional;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findBynombreprod(String nombreprod);

    List<Producto> findByNombreprodContainingIgnoreCase(String filtro);

    @Query("SELECT * FROM Productos c WHERE c.nombreprod LIKE %:filtro%")
    List<Producto> filtrarProductosPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM Productos WHERE nombreprod LIKE %:filtro%",
            nativeQuery = true)
    List<Producto> filtrarProductosPorNombreSQL(@Param("filtro") String filtro);
}
