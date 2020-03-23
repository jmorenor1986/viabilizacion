package co.com.santander.persistencia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.com.santander.persistencia.constants.ServicioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "servicio")
public class ServicioEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicio_generator")
	@SequenceGenerator(name = "servicio_generator", sequenceName = "servicio_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "nombre" , unique = true)
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