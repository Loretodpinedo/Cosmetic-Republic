package cosmetic.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cosmetic.modelo.entidad.AtributoCosmetico;
															//<Entidad, clave primaria>
public interface AtributoCosmeticoDao extends JpaRepository<AtributoCosmetico, Integer> {

	List<AtributoCosmetico> findByNombreContainingIgnoreCase(String nombre);

	AtributoCosmetico findById(int id);

}