package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.common.EstadoEnum;
import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.common.ServicioEnum;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ICacheUsrRepository extends JpaRepository<CacheUsrEntity, Long> {

    @Transactional
    @Modifying
    Integer inactiveCacheUsr(String paramBusq, String tipo);

    Optional< CacheUsrEntity > findLogInCache(String paramBusq, EstadoEnum estado, String tipo, FlowOperationEnum operation);

}
