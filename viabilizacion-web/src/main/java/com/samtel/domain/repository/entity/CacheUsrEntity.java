package com.samtel.domain.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cache_usr")
public class CacheUsrEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cache_usr_generator")
    @SequenceGenerator(name = "cache_usr_generator", sequenceName = "cache_usr_seq", allocationSize = 1)
    private Long id;
    @Column(name = "parametros_busq")
    private String paramBusq;

    @OneToMany(
            mappedBy = "cacheUsr",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<LogEntity> log = new ArrayList<>();

}
