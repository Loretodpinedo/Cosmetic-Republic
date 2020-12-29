package cosmetic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cosmetic.modelo.entidad.IngredienteReceta;
import cosmetic.modelo.persistencia.IngredienteRecetaDao;

@RestController
public class IngredienteRecetaControlador {
	
	@Autowired
	IngredienteRecetaDao ingredienteRecetaDao;
	
	@PostMapping("/IngredienteReceta")
	IngredienteReceta alta (@RequestBody IngredienteReceta nuevoIngredienteReceta) {
		return ingredienteRecetaDao.save(nuevoIngredienteReceta);
	}
	
	@GetMapping("/IngredienteReceta/{id}")
	IngredienteReceta buscarPorId(@PathVariable Long id) {
		return ingredienteRecetaDao.findById(id.intValue());
	}
	
	
	@GetMapping("/IngredientesReceta")
	List<IngredienteReceta> listar() {
		return ingredienteRecetaDao.findAll();
	}
}
