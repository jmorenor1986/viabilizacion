package com.samtel.core.repository;

import com.samtel.domain.repository.entity.ServicioEntity;
import com.samtel.domain.repository.entity.ServicioEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IServicioRepository extends JpaRepository<ServicioEntity, Long> {
    Optional<ServicioEntity> findByServicio(ServicioEnum servicio);
}
