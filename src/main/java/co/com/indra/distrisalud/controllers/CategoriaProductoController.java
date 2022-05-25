package co.com.indra.distrisalud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.indra.distrisalud.model.ViewCategoriaProducto;
import co.com.indra.distrisalud.repository.ViewCatProductoRepository;



@Controller
@RequestMapping(path = "/categoriaProducto")
public class CategoriaProductoController {

	 @Autowired
	    private ViewCatProductoRepository catProductoRepository; 
	
	 @GetMapping(value = "/mostrar")
	    public String mostrarCategorias(Model model) {
	        model.addAttribute("categoriasProductos", catProductoRepository.findAll());
	        return "reportes/ver_productosCategorias.html";
	    }

	
}
