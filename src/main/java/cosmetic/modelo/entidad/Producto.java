package cosmetic.modelo.entidad;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cosmetic.modelo.entidad.Receta;
import cosmetic.modelo.entidad.AtributoCosmetico;

@Entity
@Table(name = "producto")
@Component
@Scope("prototype")
public class Producto extends ElementoCosmetico {

	@OneToOne
	private AtributoCosmetico categoriaCosmetica;
	@ElementCollection
	@OneToMany(targetEntity = Imagen.class, mappedBy = "producto")
	private List<Imagen> ficherosDeImagen;
	@ElementCollection
	@OneToMany(targetEntity = Receta.class, mappedBy = "producto", fetch = FetchType.EAGER)
	private List<Receta> recetas;
	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", ficherosDeImagen=" + ficherosDeImagen + ", categoriaCosmetica="
				+ categoriaCosmetica + ", recetas=" + recetas + "]";
	}

	public Producto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AtributoCosmetico getCategoriaCosmetica() {
		return categoriaCosmetica;
	}

	public void setCategoriaCosmetica(AtributoCosmetico categoriaCosmetica) {
		this.categoriaCosmetica = categoriaCosmetica;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

}
