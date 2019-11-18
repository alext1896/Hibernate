package es.profersor.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "Profesor", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class Profesor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Id", unique = true)
	private long id;
	@Column(name = "nombre")
	private String nombre;
	@Column (name = "ape1")
	private String ape1;
	@Column (name = "ape2")
	private String ape2;
	@OneToOne (cascade = CascadeType.ALL )
	@JoinColumn (name = "DIRECCION_ID")
	private Direccion direccion;
	
	public Profesor() {

	}

	public Profesor(String ape1, String ape2, Direccion direccion) {
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.direccion = direccion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", ape1=" + ape1 + ", ape2=" + ape2 + ", direccion=" + direccion + "]";
	}
	
	
}
