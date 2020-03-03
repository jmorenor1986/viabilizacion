package co.com.santander.ports.secondary.database.santander;

import co.com.santander.adapters.secondary.database.santander.entity.PrincipalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrincipalRequestRepository extends JpaRepository<PrincipalRequest, Long> {
}
