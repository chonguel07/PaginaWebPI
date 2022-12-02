package Proyecto.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "tb_usuario")
@Data
public class Usuario {
	
	@Id
	@Column(name = "id")
	private int codigo;
	
	@Column(name = "nombresusu")
	private String nombre;
	
	@Column(name = "apellidosusu")
	private String apellido;
	
	@Column(name = "fecha_nacusu")
	private String fechanacimiento;
	
	@Column(name = "correousu")
	private String correo;
	
	@Column(name = "claveusu")
	private String clave;
	
	@Column(name = "rol_usu")
	private String rol;

}
