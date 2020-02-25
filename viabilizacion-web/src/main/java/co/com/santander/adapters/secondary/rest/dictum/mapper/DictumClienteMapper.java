package co.com.santander.adapters.secondary.rest.dictum.mapper;

import co.com.santander.domain.solicitud.Cliente;
import co.com.santander.domain.solicitud.dictum.RequestDictum;

public interface DictumClienteMapper {

    RequestDictum toRequestDictum(Cliente cliente);
}
