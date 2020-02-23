package com.samtel.ports.primary.log;

import com.samtel.domain.repository.entity.CacheUsrEntity;
import com.samtel.domain.repository.entity.LogEntity;

public interface CacheUsrService {

    CacheUsrEntity insertLogCacheUsr(LogEntity log, String cache);

}
