package com.samtel.bizagi.service;

import com.samtel.bizagi.dto.RequestCreateCaseDTO;
import com.samtel.bizagi.dto.ResponseCreateCaseDTO;

import java.net.MalformedURLException;

public interface CaseBizagiService {
    ResponseCreateCaseDTO createCase(RequestCreateCaseDTO requestCreateCaseDTO) throws MalformedURLException;
}
