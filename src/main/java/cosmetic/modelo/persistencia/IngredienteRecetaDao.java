package cosmetic.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cosmetic.modelo.entidad.Ingrediente;
import cosmetic.modelo.entidad.IngredienteReceta;

public interface IngredienteRecetaDao extends JpaRepository<IngredienteReceta, Integer>{

	IngredienteReceta findById(int id);
	List<IngredienteReceta>findByIngrediente(Ingrediente ingrediente);
	
}
