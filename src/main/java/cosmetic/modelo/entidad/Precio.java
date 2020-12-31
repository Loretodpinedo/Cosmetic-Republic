package cosmetic.modelo.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cosmetic.modelo.entidad.Ingrediente;

@Entity
@Table(name = "precio")
@Component
@Scope("prototype")
public class Precio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Ingrediente ingrediente;
	@OneToOne
	private AtributoCosmetico tienda;
	private Date fechaCompra;
	private double precioPorGramo;// division del precio total entre los gramos.
	private double gramos;
	private double precioTotal;

	public double calculoPrecioPorGramo() {

		precioPorGramo = precioTotal / gramos;
		return precioPorGramo;

	}

	@Override
	public String toString() {
		return "Precio [id=" + id + ", ingrediente=" + ingrediente + ", tienda=" + tienda + ", fechaCompra="
				+ fechaCompra + ", precioPorGramo=" + precioPorGramo + ", gramos=" + gramos + ", precioTotal="
				+ precioTotal + "]";
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

	public AtributoCosmetico getTienda() {
		return tienda;
	}

	public void setTienda(AtributoCosmetico tienda) {
		this.tienda = tienda;
	}

	public Date getFechaCreacion() {
		return fechaCompra;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCompra = fechaCreacion;
	}

	public double getGramos() {
		return gramos;
	}

	public void setGramos(double gramos) {
		this.gramos = gramos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public double getPrecioPorGramo() {
		return precioPorGramo;
	}

	public void setPrecioPorGramo(double precioPorGramo) {
		this.precioPorGramo = precioPorGramo;
	}

	public Precio() {
		super();
	}

}
