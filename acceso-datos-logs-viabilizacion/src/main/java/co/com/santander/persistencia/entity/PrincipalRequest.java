package co.com.santander.persistencia.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "principal_request")
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PrincipalRequest {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "principal_request_generator")
    @SequenceGenerator(name = "principal_request_generator", sequenceName = "principal_request_seq", allocationSize = 1)
    private Long id;
    @Column(name = "codigo_aliado")
    private String codigoAliado;
    @Column(name = "ip_origen")
    private  String ipOrigen;
    @Column(name = "usuario_aliado")
    private String usuarioAliado;
    @Column(name = "json")
    private String json;

    @OneToMany(
            mappedBy = "principalRequest",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LogEntity> logs = new ArrayList<>();

    public void addLog(LogEntity log) {
        logs.add(log);
        log.setPrincipalRequest(this);
    }

    public void removeLog(LogEntity log) {
        logs.remove(log);
        log.setPrincipalRequest(null);
    }

}
