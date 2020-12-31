package cosmetic.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cosmetic.modelo.entidad.Ingrediente;
import cosmetic.modelo.persistencia.IngredienteDao;

@RestController
public class IngredienteControlador {

	private final IngredienteDao ingredienteDao;

	public IngredienteControlador(IngredienteDao ingredienteDao) {
		super();
		this.ingredienteDao = ingredienteDao;
	}

	@PostMapping("/Ingrediente")
	Ingrediente alta(@RequestBody Ingrediente nuevoIngrediente) {
		return ingredienteDao.save(nuevoIngrediente);
	}

	@PostMapping("/Ingrediente/{id}")
	public ResponseEntity<Ingrediente> modificar(@RequestBody Ingrediente ingredienteModificado, @PathVariable int id) {

		Ingrediente opt = ingredienteDao.findById(id);
		if (opt != null) {
			ingredienteModificado.setId(id);
			ingredienteDao.save(ingredienteModificado);
			return new ResponseEntity<Ingrediente>(ingredienteModificado, HttpStatus.OK);
		} else {
			return new ResponseEntity<Ingrediente>(ingredienteModificado, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/Ingrediente/{id}")
	void borrarIngredientePorId(@PathVariable Long id) {
		ingredienteDao.deleteById(id.intValue());
	}

	@GetMapping("/Ingredientes")
	List<Ingrediente> listar() {
		return ingredienteDao.findAll();
	}

	@GetMapping("/Ingrediente/{id}")
	Ingrediente buscarPorId(@PathVariable Long id) {
		return ingredienteDao.findById(id.intValue());
	}

	@GetMapping("/Ingredientes/Nombre/{nombre}")
	List<Ingrediente> buscarPorNombre(@PathVariable String nombre) {
		return ingredienteDao.findByNombreContainingIgnoreCase(nombre);

	}

	/*
	 * HACER CUANDO TENGA DAO DE PRODUCTO
	 * 
	 * @GetMapping("/Ingredientes/Producto{id}") List<Ingrediente>
	 * buscarPorProducto(@PathVariable int id) {
	 * 
	 * id = return ingredienteDao.findByProducto(producto); }
	 */

	/* no va VER TUTORIAL ENUMS hacer con metodo gestor.
	@GetMapping("/Ingredientes/Propiedades/{categoriaAtributo}")
	List<Ingrediente> buscarPorPropiedades(@PathVariable String propiedades) {

		// CategoriaAtributo enumPropiedades = null;
		// enumPropiedades.name();

		List<Ingrediente> todosLosIngredientes = ingredienteDao.findAll();
		List<Ingrediente> ingredientesConLaPropiedadBuscada = new ArrayList<Ingrediente>();
		for (Ingrediente ingredienteBuscado : todosLosIngredientes) {
			for (AtributoCosmetico atributoCosmeticoBuscado : ingredienteBuscado.getAtributoCosmetico()) {
				if (atributoCosmeticoBuscado.getCategoriaAtributo().name().equals(propiedades))
					ingredientesConLaPropiedadBuscada.add(ingredienteBuscado);
			}

		}

		return ingredientesConLaPropiedadBuscada;
	}
	*/
}
