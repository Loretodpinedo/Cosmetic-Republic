package cosmetic.modelo.entidad;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import cosmetic.modelo.entidad.Producto;

@Entity
@Table(name = "ingrediente")
@Component
@Scope("prototype")
public class Ingrediente extends ElementoCosmetico {

	@OneToOne
	private AtributoCosmetico categoriaIngrediente;
	@Nullable
	@OneToOne
	private Producto producto;
	
	@JsonIgnore
	@ElementCollection
	@OneToMany(targetEntity = AtributoCosmetico.class, mappedBy = "elementoCosmetico")
	private List<AtributoCosmetico> atributosCosmeticos;

	

	@Override
	public String toString() {
		return "Ingrediente [categoriaIngrediente=" + categoriaIngrediente + ", producto=" + producto
				+ ", atributosCosmeticos=" + atributosCosmeticos + "]";
	}
	

	public List<AtributoCosmetico> getAtributosCosmeticos() {
		return atributosCosmeticos;
	}


	public void setAtributosCosmeticos(List<AtributoCosmetico> atributosCosmeticos) {
		this.atributosCosmeticos = atributosCosmeticos;
	}


	public Ingrediente() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AtributoCosmetico getCategoriaIngrediente() {
		return categoriaIngrediente;
	}

	public void setCategoriaIngrediente(AtributoCosmetico categoriaIngrediente) {
		this.categoriaIngrediente = categoriaIngrediente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
