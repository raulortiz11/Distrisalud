package co.com.indra.distrisalud.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.indra.distrisalud.model.CategoriaProducto;

public interface CategoriaRepository extends CrudRepository<CategoriaProducto, Integer> {
    
}
