package co.com.santander.persistencia.controller.payload;

import co.com.santander.persistencia.entity.LogEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CacheUsrPayload {
    private LogEntity log;
    private String cache;
}
