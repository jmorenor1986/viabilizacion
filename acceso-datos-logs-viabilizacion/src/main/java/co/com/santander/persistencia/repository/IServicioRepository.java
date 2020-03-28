package co.com.santander.persistencia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.ServicioEntity;

@Repository
public interface IServicioRepository extends JpaRepository<ServicioEntity, Long> {

    Optional<ServicioEntity> findByServicio(ServicioEnum servicio);
}
