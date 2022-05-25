package co.com.indra.distrisalud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.indra.distrisalud.model.Producto;
import co.com.indra.distrisalud.repository.CategoriaRepository;
import co.com.indra.distrisalud.repository.ProductosRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/productos")
public class ProductosController {
	@Autowired
	private ProductosRepository productosRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping(value = "/agregar")
	public String agregarProducto(Model model) {

		model.addAttribute("categorias", categoriaRepository.findAll());
		model.addAttribute("producto", new Producto());
		return "productos/agregar_producto";
	}

	@GetMapping(value = "/mostrar")
	public String mostrarProductos(Model model) {
		model.addAttribute("productos", productosRepository.findAll());
		return "productos/ver_productos";
	}

	@PostMapping(value = "/eliminar")
	public String eliminarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("clase", "warning");
		productosRepository.deleteById(producto.getId());
		return "redirect:/productos/mostrar";
	}

	@PostMapping(value = "/editar/{id}")
	public String actualizarProducto(@ModelAttribute @Valid Producto producto, BindingResult bindingResult,
			RedirectAttributes redirectAttrs, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaRepository.findAll());
			if (producto.getId() != null) {
				return "productos/editar_producto";
			}
			return "redirect:/productos/mostrar";
		}

		productosRepository.save(producto);
		redirectAttrs.addFlashAttribute("mensaje", "Editado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/productos/mostrar";
	}

	@GetMapping(value = "/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		model.addAttribute("categorias", categoriaRepository.findAll());
		model.addAttribute("producto", productosRepository.findById(id).orElse(null));
		return "productos/editar_producto";
	}

	@PostMapping(value = "/agregar")
	public String guardarProducto(@ModelAttribute @Valid Producto producto, BindingResult bindingResult,
			RedirectAttributes redirectAttrs, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categorias", categoriaRepository.findAll());
			return "productos/agregar_producto";
		}

		productosRepository.save(producto);
		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/productos/agregar";
	}
}
