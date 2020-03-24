package co.com.santander.persistencia.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import co.com.santander.persistencia.constants.EstadoEnum;
import co.com.santander.persistencia.entity.CacheUsrEntity;

@Repository
public interface ICacheUsrRepository extends JpaRepository<CacheUsrEntity, Long> {

    @Transactional
    @Modifying
    Integer inactiveCacheUsr(String paramBusq, String tipo);

    Optional< CacheUsrEntity > findByParamBusqAndEstadoAndTipo(String paramBusq, EstadoEnum estado, String tipo);

}
