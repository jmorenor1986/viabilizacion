package co.com.santander.bizagi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Case {
    private String Process;
    private List<SolicitudCredito> Entities;
}
