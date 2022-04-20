package com.desafiolatam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafiolatam.models.Producto;
import com.desafiolatam.models.ProductosVentas;
import com.desafiolatam.models.Venta;
import com.desafiolatam.services.ProductoService;
import com.desafiolatam.services.ProductoVentaService;
import com.desafiolatam.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	VentaService ventaService;

	@Autowired
	ProductoService productoService;

	@Autowired
	ProductoVentaService productoVentaService;

	// despliegue
	@RequestMapping("") // https://localhost:9080/venta
	public String showVenta(Model model) {
		model.addAttribute("ventaId", 0);
		model.addAttribute("listaProductos", productoService.findAll());
		return "venta/venta.jsp"; // Llamado al jsp u otra ruta
	}

	// Capturar
	@PostMapping("/agregar")
	public String agregarProducto(@RequestParam("productoId") Long productoId,
			@RequestParam("cantidad") Integer cantidad, @RequestParam("ventaId") Long ventaId, Model model) {
		System.out.println(productoId + cantidad + ventaId);
		if (productoId != null && productoId > 0) {
			if (cantidad != null && cantidad > 0) {
				// Obtener el producto con el id
				Producto producto = productoService.findById(productoId);

				// calcular el monto de la venta
				Float precioProducto = producto.getPrecio();
				Float subtotalProducto = precioProducto * cantidad;
				Venta venta = new Venta();

				if (ventaId == 0) { // no existe, se crea

					// llenar un objeto venta
					venta.setMonto(subtotalProducto);

				} else {
					// si existe la venta, la obtengo, agrego la venta y sumo el monto total
					venta = ventaService.findById(ventaId);
					venta.setMonto(subtotalProducto + venta.getMonto());
				}

				// guardar el objeto en la base de datos y lo retorna actualizado
				venta = ventaService.save(venta);

				// retornar el nuevo ventaId al jsp
				model.addAttribute("ventaId", venta.getId());

				// Crear el objeto ProductosVentas
				ProductosVentas productosVentas = new ProductosVentas();
				productosVentas.setProducto(producto);
				productosVentas.setVenta(venta);
				productosVentas.setCantidad(cantidad);
				productosVentas.setValorUnitario(producto.getPrecio()); // valor histórico
				productosVentas.setTotal(subtotalProducto);

				// guardamos y relacionamos el producto con la venta
				productoVentaService.save(productosVentas);

				// Creamos una lista con la ventaId
				// método 01
				// List<ProductosVentas> listaProductosVentas =
				// productoVentaService.findAllByVentaId(venta.getId());
				// método 02
				List<ProductosVentas> listaProductosVentas = productoVentaService.findAllProductosVentas(venta.getId());

				// Pasamos información al jsp
				model.addAttribute("listaProductosVentas", listaProductosVentas);
				model.addAttribute("venta", venta);
			} else {
				// no se agregó una cantidad
				model.addAttribute("msgError", "Debe ingresar una cantidad");
			}
		} else {
			// no se seleccionó un producto
			model.addAttribute("msgError", "Debe ingresar un producto");
		}

		model.addAttribute("listaProductos", productoService.findAll());
		return "/venta/venta.jsp";
	}

	// desplegar
	@RequestMapping("/ver") // https://localhost:9080/venta/ver
	public String verVenta() {
		return "/venta/verVenta.jsp"; // Llamado al jsp u otra ruta
	}

	@PostMapping("/ver") // https://localhost:9080/venta/ver
	public String buscarVenta(@RequestParam("ventaId") Long ventaId, Model model) {
		Boolean existeVenta = ventaService.existsById(ventaId);
		System.out.println("Boolean " + existeVenta);
		if(!existeVenta) {
			model.addAttribute("msgError", "La venta no existe");
		} else {
			List<ProductosVentas> listaProductosVentas = productoVentaService.findAllProductosVentas(ventaId);

			// Pasamos información al jsp
			model.addAttribute("listaProductosVentas", listaProductosVentas);
			model.addAttribute("venta", ventaService.findById(ventaId));
		}
		return "/venta/verVenta.jsp"; // Llamado al jsp u otra ruta
	}

}
