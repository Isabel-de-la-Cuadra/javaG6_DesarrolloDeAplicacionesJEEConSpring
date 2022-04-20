package com.desafiolatam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.ProductosVentas;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductosVentas, Long>{

	//JPQL: no usar el *, usar el objeto y no la tabla
	//SELECT * FROM PRODUCTOS_VENTAS WHERE VENTA_ID=?;
	//?1 el primer parámetro que estemos pasando; ?2 el segundo parámetro que estemos pasando
	@Query("SELECT pv FROM ProductosVentas pv WHERE pv.venta.id = ?1")
	List<ProductosVentas> findAllProductosVentasWhereVentaId(Long ventaId);
	
	@Query("SELECT pv FROM ProductosVentas pv WHERE pv.producto.id = ?1")
	List<ProductosVentas> findAllProductosVentasWhereProductoId(Long productoId);
	
	//Query nativas
	@Query(value="SELECT * FROM productos_ventas WHERE venta_id = ?1", nativeQuery=true)
	List<ProductosVentas> findAllProductosVentas(Long ventaId);
	
}
