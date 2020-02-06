package com.samtel.domain.repository.entity;
	
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "log")
@Getter @Setter
public class LogEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_oper_generator")
	@SequenceGenerator(name = "log_oper_generator", sequenceName = "log_oper_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "usuario_micro", nullable = false)
	private String usuarioMicro;
	
	@Column(name = "tipo" )
	@Enumerated(value = EnumType.STRING)
	private FlowOperationEnum tipo;
	
	@Column(name= "traza", columnDefinition = "TEXT")	
	private String traza;
	
	@Column(name = "id_request")
	private Long idRequest;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ServicioEntity servicio;
	
	@PrePersist
    private void prePersistFunction(){
        if(fecha == null){
            this.fecha = new Date();
        }
        if(tipo == null) {
        	this.setTipo(FlowOperationEnum.NO_APLICA);
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntity other = (LogEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}