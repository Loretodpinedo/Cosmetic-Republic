package cosmetic.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "ingredienteReceta")
@Component
@Scope("prototype")
public class IngredienteReceta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@OneToOne
	private Ingrediente ingrediente;
	@OneToOne
	private Receta receta;
	private double porcentaje;
	@OneToOne
	private Precio precioPorGramo;
	private double precioIngredienteReceta;

	public double calculoPrecioIngredienteReceta() {
		
		precioIngredienteReceta=precioPorGramo.calculoPrecioPorGramo()*porcentaje;
		return precioIngredienteReceta;
	}
	
	

	@Override
	public String toString() {
		return "IngredienteReceta [id=" + id + ", ingrediente=" + ingrediente + ", receta=" + receta + ", porcentaje="
				+ porcentaje + ", precioPorGramo=" + precioPorGramo + ", precioIngredienteReceta="
				+ precioIngredienteReceta + "]";
	}



	public IngredienteReceta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Precio getPrecioPorGramo() {
		return precioPorGramo;
	}

	public void setPrecioPorGramo(Precio precioPorGramo) {
		this.precioPorGramo = precioPorGramo;
	}

	public double getPrecioIngredienteReceta() {
		return precioIngredienteReceta;
	}

	public void setPrecioIngredienteReceta(double precioIngredienteReceta) {
		this.precioIngredienteReceta = precioIngredienteReceta;
	}
	
	

}
