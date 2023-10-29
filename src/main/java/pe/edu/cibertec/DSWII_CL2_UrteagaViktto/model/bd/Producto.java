package pe.edu.cibertec.DSWII_CL2_UrteagaViktto.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprod;
    @Column(name = "nombreprod")
    private String nombreprod;
    @Column(name = "descripcionprod")
    private String descripcionprod;
    @Column(name = "cantidadprod")
    private Integer cantidadprod;
    @Column(name = "fechaVencimientoprod")
    private Date fechaVencimientoprod;
}