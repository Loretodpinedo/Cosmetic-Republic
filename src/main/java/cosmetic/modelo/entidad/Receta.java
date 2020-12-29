package cosmetic.modelo.entidad;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cosmetic.modelo.entidad.Producto;

@Entity
@Table(name = "receta")
@Component
@Scope("prototype")
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Producto producto;
	@ElementCollection
	@OneToMany(targetEntity = IngredienteReceta.class, mappedBy = "receta")
	private List<IngredienteReceta> ingredientes;

	@Override
	public String toString() {
		return "Receta [id=" + id + ", producto=" + producto + ", ingredientes=" + ingredientes + "]";
	}

	public Receta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<IngredienteReceta> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<IngredienteReceta> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
