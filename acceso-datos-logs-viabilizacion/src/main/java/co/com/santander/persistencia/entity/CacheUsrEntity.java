package co.com.santander.persistencia.entity;

import co.com.santander.persistencia.common.EstadoEnum;
import co.com.santander.persistencia.common.FlowOperationEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cache_usr")
@NamedQueries({
        @NamedQuery(name = "CacheUsrEntity.inactiveCacheUsr", query = "update CacheUsrEntity set estado = 'INACTIVO' where estado = 'ACTIVO' and  paramBusq = :paramBusq and tipo = :tipo and tipoLog = :tipoLog"),
        @NamedQuery(name = "CacheUsrEntity.findLogInCache" , query = "from CacheUsrEntity cu join fetch cu.logs lo where  cu.paramBusq = :paramBusq and cu.estado = :estado and cu.tipo = :tipo and lo.tipo = :operation ")
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
    @Column(name = "tipo_log", unique = true)
    @Enumerated(value = EnumType.STRING)
    private FlowOperationEnum tipoLog;

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
