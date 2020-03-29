package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IServicioRepository extends JpaRepository<ServicioEntity, Long> {

    Optional<ServicioEntity> findByServicio(ServicioEnum servicio);
}
