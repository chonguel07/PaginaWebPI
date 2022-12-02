package Proyecto.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "tb_denuncia")
@Data
public class Denuncia {
	
	@Id
	@Column(name = "id")
	private int codigo;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "domicilio")
	private String domicilio;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "agresor")
	private String agresor;
	
	@Column(name = "sexoagresor")
	private String sexoagresor;
	
	@Column(name = "telefonoagresor")
	private String telefonoagresor;
	
	@Column(name = "localizacion")
	private String localizacion;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "hechos")
	private String hechos;
	
	@Column(name = "estado")
	private String estado;
	
}
