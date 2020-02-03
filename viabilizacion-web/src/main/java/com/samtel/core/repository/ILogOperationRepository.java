package com.samtel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samtel.domain.repository.entity.LogOperationEntity;

@Repository
public interface ILogOperationRepository extends JpaRepository<LogOperationEntity, Long> {
	
}