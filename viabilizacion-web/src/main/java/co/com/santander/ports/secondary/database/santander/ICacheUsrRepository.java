package co.com.santander.ports.secondary.database.santander;

import co.com.santander.adapters.secondary.database.santander.entity.CacheUsrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ICacheUsrRepository extends JpaRepository<CacheUsrEntity, Long> {

    @Transactional
    @Modifying
    Integer inactiveCacheUsr(String paramBusq, String tipo);

}
