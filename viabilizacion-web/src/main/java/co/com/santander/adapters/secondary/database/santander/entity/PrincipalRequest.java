package co.com.santander.adapters.secondary.database.santander.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
