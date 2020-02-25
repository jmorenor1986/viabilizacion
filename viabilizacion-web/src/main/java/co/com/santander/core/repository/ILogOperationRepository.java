package co.com.santander.core.repository;

import co.com.santander.domain.repository.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogOperationRepository extends JpaRepository<LogEntity, Long> {
	
}