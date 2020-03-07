package co.com.santander.bizagi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BizAgiWSParam {
    private String domain;
    private String userName;
    private List<Case> Case;

}
