package co.com.santander.persistencia.service.impl;

import co.com.santander.persistencia.entity.PrincipalRequest;
import co.com.santander.persistencia.repository.IPrincipalRequestRepository;
import co.com.santander.persistencia.service.PrincipalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalRequestImpl implements PrincipalRequestService {

    private final IPrincipalRequestRepository principalRequestRepository;

    @Autowired
    public PrincipalRequestImpl(IPrincipalRequestRepository principalRequestRepository) {
        this.principalRequestRepository = principalRequestRepository;
    }

    @Override
    public PrincipalRequest insertaPrincipalRequest(PrincipalRequest principalRequest) {
        return principalRequestRepository.save(principalRequest);
    }
}
