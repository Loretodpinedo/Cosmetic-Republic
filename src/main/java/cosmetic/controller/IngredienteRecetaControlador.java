package cosmetic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//REVISAR NO VA
	@PutMapping("/IngredienteReceta/{id}")
	IngredienteReceta modificarIngredienteReceta(@RequestBody IngredienteReceta ingredienteReceta, @PathVariable int id) {
		IngredienteReceta ingRecObjeto = null;
		ingRecObjeto = ingredienteRecetaDao.findById(id);
		if(ingredienteRecetaDao==null) {
			ingRecObjeto = new IngredienteReceta();
		}
		ingRecObjeto.setId(ingredienteReceta.getId());
		return ingRecObjeto;
	}
	//REVISAR NO VA
	@DeleteMapping("/IngredienteReceta/{id}")
	void borrarIngredienteReceta(@PathVariable int id) {
		ingredienteRecetaDao.deleteById(id);
	
	}
}
