package cosmetic.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Esta entidad esta creada para gestionar los enum del resto de entidades.

@Entity
@Table(name = "atributoCosmetico")
@Component
@Scope("prototype")
public class AtributoCosmetico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private CategoriaAtributo categoriaAtributo;
	// Referenciar al resto de enum desde negocio, podria ser con un switch,
	// cada case seria lo devuelto por categoriaAtributo haciendo referencia
	// a cada uno de los enum
	
	@ManyToOne//para el mapeado con ingrediente. 
	private ElementoCosmetico elementoCosmetico;

	@Override
	public String toString() {
		return "AtributoCosmetico [id=" + id + ", nombre=" + nombre + ", categoriaAtributo=" + categoriaAtributo
				+ ", atributoCosmetico=" + elementoCosmetico + "]";
	}

	public AtributoCosmetico() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaAtributo getCategoriaAtributo() {
		return categoriaAtributo;
	}

	public void setCategoriaAtributo(CategoriaAtributo categoriaAtributo) {
		this.categoriaAtributo = categoriaAtributo;
	}

	public ElementoCosmetico getAtributoCosmetico() {
		return elementoCosmetico;
	}

	public void setAtributoCosmetico(ElementoCosmetico atributoCosmetico) {
		this.elementoCosmetico = atributoCosmetico;
	}

}
