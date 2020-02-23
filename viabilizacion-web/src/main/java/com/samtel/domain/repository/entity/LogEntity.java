package com.samtel.domain.repository.entity;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
@Builder
@NoArgsConstructor @AllArgsConstructor
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
	private String idRequest;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ServicioEntity servicio;

	@Column(name = "httpStatus" )
	@Enumerated(value = EnumType.STRING)
	private HttpStatus httpStatus;

	@ManyToOne(fetch =  FetchType.LAZY)
	private CacheUsrEntity cacheUsr;

	@Column(name = "url")
	private String url;
	
	@PrePersist
    public void prePersistFunction(){
        if(fecha == null){
            this.fecha = new Date();
        }
        if(tipo == null) {
        	this.setTipo(FlowOperationEnum.NO_APLICA);
        }
        if(httpStatus == null){
        	this.setHttpStatus(HttpStatus.CONTINUE);
		}
        if(url == null){
        	this.setUrl("NO_APLICA");
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