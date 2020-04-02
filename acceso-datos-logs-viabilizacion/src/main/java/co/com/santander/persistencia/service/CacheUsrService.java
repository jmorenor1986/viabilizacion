package co.com.santander.persistencia.service;

import co.com.santander.persistencia.common.FlowOperationEnum;
import co.com.santander.persistencia.entity.CacheUsrEntity;
import co.com.santander.persistencia.entity.LogEntity;

import java.util.Optional;

public interface CacheUsrService {

    CacheUsrEntity insertLogCacheUsr(LogEntity log, String cache);

    Optional< String > validityLogUser(String cache, Long vig,  FlowOperationEnum operation);

}
