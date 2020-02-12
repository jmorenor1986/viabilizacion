package com.samtel.adapters.secondary.rest.dictum.mapper;

import com.samtel.domain.solicitud.Cliente;
import com.samtel.domain.solicitud.RequestDictum;

public interface DictumClienteMapper {

	public RequestDictum toRequestDictum(Cliente cliente);
}
