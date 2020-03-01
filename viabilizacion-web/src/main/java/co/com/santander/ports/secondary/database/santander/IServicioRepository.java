package co.com.santander.ports.secondary.database.santander;

import co.com.santander.adapters.secondary.database.santander.entity.ServicioEntity;
import co.com.santander.adapters.secondary.database.santander.constants.ServicioEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IServicioRepository extends JpaRepository<ServicioEntity, Long> {
    Optional<ServicioEntity> findByServicio(ServicioEnum servicio);
}
