package co.com.santander.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.santander.persistencia.entity.PrincipalRequest;

@Repository
public interface IPrincipalRequestRepository extends JpaRepository<PrincipalRequest, Long> {
}
