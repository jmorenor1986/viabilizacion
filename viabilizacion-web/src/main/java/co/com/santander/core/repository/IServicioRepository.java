package co.com.santander.core.repository;

import co.com.santander.domain.repository.entity.ServicioEntity;
import co.com.santander.domain.repository.entity.ServicioEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IServicioRepository extends JpaRepository<ServicioEntity, Long> {
    Optional<ServicioEntity> findByServicio(ServicioEnum servicio);
}
