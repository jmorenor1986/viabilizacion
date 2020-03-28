package co.com.santander.persistencia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.com.santander.persistencia.common.constants.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cache_usr")
@NamedQueries({
        @NamedQuery(name = "CacheUsrEntity.inactiveCacheUsr", query = "update CacheUsrEntity set estado = 'INACTIVO' where estado = 'ACTIVO' and  paramBusq = :paramBusq and tipo = :tipo ")
})
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheUsrEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cache_usr_generator")
    @SequenceGenerator(name = "cache_usr_generator", sequenceName = "cache_usr_seq", allocationSize = 1)
    private Long id;
    @Column(name = "parametros_busq")
    private String paramBusq;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "log_id", unique = true)
    private LogEntity logs;
    @Column(name = "estado")
    @Enumerated(value = EnumType.STRING)
    private EstadoEnum estado;
    @Column(name = "tipo")
    private String tipo;

    public void setLogs(LogEntity logs){
        if(logs == null){
            if(this.logs != null){
                this.logs.setCacheUsr(null);
            }
        }else{
            logs.setCacheUsr(this);
        }
        this.logs = logs;
    }
}
