package cosmetic.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cosmetic.modelo.entidad.Ingrediente;

public interface IngredienteDao extends JpaRepository<Ingrediente, Integer> {

	Ingrediente findById(int id);

	 List<Ingrediente> findByNombreContainingIgnoreCase(String nombre);

	 //Hacer cuando tenga DAO DE PRODUCTO
	//List<Ingrediente> findByProducto(int id);

	// @Query("SELECT id, nombre, atributosCosmeticos, comentario,
	// categoriaIngrediente, producto FROM ingredientes WHERE atributoCosmetico=?");

	//List<Ingrediente> findByAtributosCosmeticos(String atributosCosmeticos);

	// Ingrediente findByAtributoCosmetico(AtributoCosmetico categoriaIngrediente);

}
