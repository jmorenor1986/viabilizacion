package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.entity.PrincipalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrincipalRequestRepository extends JpaRepository<PrincipalRequest, Long> {
}
