package co.com.santander.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.santander.persistencia.entity.LogEntity;

@Repository
public interface ILogOperationRepository extends JpaRepository<LogEntity, Long> {
	
}