package com.samtel.domain.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "servicio")
public class ServicioEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicio_generator")
	@SequenceGenerator(name = "servicio_generator", sequenceName = "servicio_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "nombre" )
	@Enumerated(value = EnumType.STRING)
	private ServicioEnum servicio;
	
	@Column(name = "vigencia")
	private Long vigencia;
	
	@OneToMany(
		mappedBy = "servicio",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<LogEntity> logs = new ArrayList<>();
	
	@Column(name = "descripcion")
	private String descripcion;
	
	public void addLog(LogEntity log) {
		logs.add(log);
		log.setServicio(this);
	}
	
	public void removeLog(LogEntity log) {
		logs.remove(log);
		log.setServicio(null);
	}
	
}