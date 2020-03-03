package co.com.santander.core.services.log.impl;

import co.com.santander.adapters.secondary.database.santander.entity.PrincipalRequest;
import co.com.santander.core.services.log.PrincipalRequestService;
import co.com.santander.ports.secondary.database.santander.IPrincipalRequestRepository;
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
