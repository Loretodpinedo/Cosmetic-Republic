package cosmetic.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cosmetic.modelo.entidad.Ingrediente;
import cosmetic.modelo.entidad.Producto;
import cosmetic.modelo.entidad.Receta;

public interface RecetaDao extends JpaRepository<Receta, Integer>{
	
	Receta findById(int id);
	List<Receta>findByIngredientes(Ingrediente ingrediente);
	List<Receta>findByProducto(Producto producto);

}
