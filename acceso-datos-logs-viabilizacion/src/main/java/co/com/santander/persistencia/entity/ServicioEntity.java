package co.com.santander.persistencia.entity;

import co.com.santander.persistencia.common.ServicioEnum;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "servicio")
public class ServicioEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicio_generator")
    @SequenceGenerator(name = "servicio_generator", sequenceName = "servicio_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nombre", unique = true)
    @Enumerated(value = EnumType.STRING)
    private ServicioEnum servicio;

    @Column(name = "vigencia")
    private Long vigencia;

    @OneToMany(
            mappedBy = "servicio",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
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