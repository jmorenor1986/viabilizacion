package co.com.santander.validation.service;

import co.com.santander.validation.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    public Ciudad buscarPorCodigoONombre(String name);
}
