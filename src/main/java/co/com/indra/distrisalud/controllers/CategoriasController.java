package co.com.indra.distrisalud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.indra.distrisalud.model.CategoriaProducto;
import co.com.indra.distrisalud.repository.CategoriaRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/categorias")
public class CategoriasController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping(value = "/agregar")
    public String agregarCategoria(Model model) {
        model.addAttribute("categorias", new CategoriaProducto());
        return "categorias/agregar_categoria";
    }

    @GetMapping(value = "/mostrar")
    public String mostrarCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categorias/ver_categoria";
    }

    @PostMapping(value = "/eliminar")
    public String eliminarCategoria(@ModelAttribute CategoriaProducto categoriaProducto, RedirectAttributes redirectAttrs) {
        redirectAttrs
                .addFlashAttribute("mensaje", "Eliminado correctamente")
                .addFlashAttribute("clase", "warning");
        categoriaRepository.deleteById(categoriaProducto.getId());
        return "redirect:/categorias/mostrar";
    }

 
    @PostMapping(value = "/editar/{id}")
    public String actualizarCategoria(@ModelAttribute @Valid CategoriaProducto categoriaProducto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            if (categoriaProducto.getId() != null) {
                return "categorias/editar_categoria";
            }
            return "redirect:/categorias/mostrar";
        }     
        categoriaRepository.save(categoriaProducto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/categorias/mostrar";
    }

    @GetMapping(value = "/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        model.addAttribute("categorias", categoriaRepository.findById(id).orElse(null));
        return "categorias/editar_categoria";
    }

    @PostMapping(value = "/agregar")
    public String guardarCategoria(@ModelAttribute @Valid CategoriaProducto categoriaProducto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return "categorias/agregar_categoria";
        }
    
        categoriaRepository.save(categoriaProducto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/categorias/agregar";
    }
}
