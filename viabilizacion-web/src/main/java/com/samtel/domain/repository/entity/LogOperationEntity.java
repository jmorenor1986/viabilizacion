package com.samtel.domain.repository.entity;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "log_operations")
@Getter @Setter
public class LogOperationEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_oper_generator")
	@SequenceGenerator(name = "log_oper_generator", sequenceName = "log_oper_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "flow_operation" )
	@Enumerated(value = EnumType.STRING)
	private FlowOperationEnum flowOperation;
	
	@Column(name = "id_request")
	private Long idRequest;
	
	@Column(name= "parameters")
	@Lob
	private String parameters;

}
