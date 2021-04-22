package com.reto.spring.springbootbackendapirest.models.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import java.io.Serializable; 


@Entity   //clase entity de JP
@Table(name="clientes") //indicar el nombre de la tabla
public class Cliente implements Serializable{


	@Id //etiqueta que indica que corresponde a la llave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //de forma incremental
	private Long id;
	
	private String nombre;
	private String apellido;
	private String email;
	
	@Column(name="create_at") //cuando el nombre del atributo es diferente al nombre del campo
	@Temporal(TemporalType.DATE) //transformacion o tipo equivalente en la base de datos fecha de java a sql
	private Date creatAt;
	
	@PrePersist  //evento del ciclo de vida de las clases entity que crea la fecha de foram automatica
	public void prePersist() {
		creatAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
