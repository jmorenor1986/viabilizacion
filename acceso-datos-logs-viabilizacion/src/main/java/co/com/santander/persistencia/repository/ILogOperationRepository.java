package co.com.santander.persistencia.repository;

import co.com.santander.persistencia.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogOperationRepository extends JpaRepository<LogEntity, Long> {
	
}